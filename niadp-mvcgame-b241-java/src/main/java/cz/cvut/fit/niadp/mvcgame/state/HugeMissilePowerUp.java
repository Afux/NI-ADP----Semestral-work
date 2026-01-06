package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public class HugeMissilePowerUp implements IPowerUpType {
    @Override
    public String getName() {
        return "HugeMissilePowerUp";
    }

    @Override
    public AbstractMissile applyPowerUp(AbstractMissile missile) {
        return new cz.cvut.fit.niadp.mvcgame.decorator.HugeMissilePowerUp(missile);
    }
}
