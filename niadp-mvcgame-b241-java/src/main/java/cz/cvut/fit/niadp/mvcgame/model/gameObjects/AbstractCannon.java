package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import java.util.List;

import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.state.IShootingMode;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractCannon extends GameObject {
    protected IGameObjectsFactory gameObjectsFactory;
    protected IShootingMode shootingMode;
    protected AbstractCannon(){
        this.size= MvcGameConfig.CANON_SIZE;
    }
    public abstract void moveUp();
    public abstract void moveDown();
    protected double angle;
    protected int power;
    public abstract void aimUp();
    public abstract void aimDown();
    public abstract void powerUp();
    public abstract void powerDown();

    public abstract void toggleShootingMode();
    public abstract List<AbstractMissile> shoot();
    public abstract void primitiveShoot();
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }

    public IGameObjectsFactory getGameObjectsFactory() {
        return gameObjectsFactory;
    }

    public IShootingMode getShootingMode() {
        return shootingMode;
    }

    public double getAngle() {
        return angle;
    }
    public String getShootingModeName(){
        return shootingMode.getName();
    }
    public int getPower() {
        return power;
    }

}
