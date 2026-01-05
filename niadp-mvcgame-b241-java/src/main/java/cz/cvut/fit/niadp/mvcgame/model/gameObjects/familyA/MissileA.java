package cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.Collideable;

public class MissileA extends AbstractMissile { 

    public MissileA(Position initPosition, double initAngle, int initVelocity, IMovingStrategy movingStrategy) {
        super(initPosition, initAngle, initVelocity, movingStrategy);
        position = initPosition;
    }
    public MissileA(AbstractMissile missile) {
        super(missile);
    }

    @Override
    public void onCollision(Collideable other, GameModel model) {
        other.collideWithMissile(this,model);
    }


    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {

    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {
        setLifeStatus(false);
    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {

    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {
        model.getPoweredUppedMissiles().add(powerUp.applyPowerUp(this));
        setLifeStatus(false);
    }
}
