package cz.cvut.fit.niadp.mvcgame.decorator;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.ICollideable;

public class HugeMissilePowerUp extends MissileDecorator {
    public HugeMissilePowerUp(AbstractMissile missile) {
        super(missile);
    }

    @Override
    public int getDamage() {
        return super.wrappedMissile.getDamage() + 50;
    }

    @Override
    public ObjectSize getSize() {
        return new ObjectSize(MvcGameConfig.BIG_GAME_OBJECT_SIZE.getWidth(), MvcGameConfig.BIG_GAME_OBJECT_SIZE.getHeight());
    }

    @Override
    public void onCollision(ICollideable other, GameModel model) {
        other.collideWithMissile(this, model);
        setLifeStatus(false);


    }

    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {
        super.wrappedMissile.collideWithCanon(Canon, model);
        setLifeStatus(false);

    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {
        super.wrappedMissile.collideWithEnemy(enemy, model);
        setLifeStatus(false);

    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {
        super.wrappedMissile.collideWithMissile(missile, model);
        setLifeStatus(false);


    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {
        super.wrappedMissile.collideWithPowerUp(powerUp, model);
        setLifeStatus(false);


    }
}
