package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractMissile extends LifetimeLimitedGameObject {

    private final double initAngle;
    private final int initVelocity;
    protected IMovingStrategy movingStrategy;
    private final int damage;

    protected AbstractMissile(Position initPosition, double initAngle, int initVelocity, IMovingStrategy movingStrategy) {
        super(initPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
        this.movingStrategy = movingStrategy;
        this.damage = MvcGameConfig.INIT_DAMAGE;
    }

    protected AbstractMissile(AbstractMissile missile) {
        super(new Position(missile.getPosition().getX(), missile.getPosition().getY()));
        this.initAngle = missile.initAngle;
        this.initVelocity = missile.initVelocity;
        this.movingStrategy = missile.movingStrategy;
        this.damage = missile.damage;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int getDamage() {
        return damage;
    }

    public double getInitAngle() {
        return initAngle;
    }

    public int getInitVelocity() {
        return initVelocity;
    }

    public void move() {
        movingStrategy.updatePosition(this);
    }
}
