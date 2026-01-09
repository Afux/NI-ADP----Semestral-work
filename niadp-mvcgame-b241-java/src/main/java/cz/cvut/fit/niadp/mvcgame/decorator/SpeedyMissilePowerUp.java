package cz.cvut.fit.niadp.mvcgame.decorator;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.ICollideable;

public class SpeedyMissilePowerUp extends MissileDecorator {
    public SpeedyMissilePowerUp(AbstractMissile missile) {
        super(missile);
    }

    @Override
    public int getInitVelocity() {
        return super.wrappedMissile.getInitVelocity() * 2;

    }

    @Override
    public void onCollision(ICollideable other, GameModel model) {
        super.wrappedMissile.onCollision(other, model);
    }

    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {
        setLifeStatus(false);
        super.wrappedMissile.collideWithCanon(Canon, model);
    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {
        setLifeStatus(false);
        super.wrappedMissile.collideWithEnemy(enemy, model);
    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {
        setLifeStatus(false);
        super.wrappedMissile.collideWithMissile(missile, model);
    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {
        setLifeStatus(false);
        super.wrappedMissile.collideWithPowerUp(powerUp, model);
    }
}
