package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.decorator.HugeMissilePowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public class HugeMissilePoweUp implements IPowerUpType {
    @Override
    public String getName() {
        return "HugeMissilePoweUp";
    }

    @Override
    public AbstractMissile applyPowerUp(AbstractMissile missile) {
        return new HugeMissilePowerUp(missile);
    }
}
