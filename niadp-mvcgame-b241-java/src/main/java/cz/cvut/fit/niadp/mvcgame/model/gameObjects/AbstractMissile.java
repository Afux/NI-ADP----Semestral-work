package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;
import cz.cvut.fit.niadp.mvcgame.model.Position;

public abstract class AbstractMissile extends LifetimeLimitedGameObject {

    private final double initAngle;
    private final int initVelocity;

    protected AbstractMissile(Position initPosition, double initAngle, int initVelocity) {
        super(initPosition);
        this.initAngle = initAngle;
        this.initVelocity = initVelocity;
    }

    public void accept(IVisitor visitor){
        visitor.visit(this);
    }

    public double getInitAngle() {
        return initAngle;
    }
    public int getInitVelocity() {
        return initVelocity;
    }

}
