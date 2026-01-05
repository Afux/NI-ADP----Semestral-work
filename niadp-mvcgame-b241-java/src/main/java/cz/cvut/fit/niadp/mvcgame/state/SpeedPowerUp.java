package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.decorator.SpeedyMissilePowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public class SpeedPowerUp implements IPowerUpType{
    @Override
    public String getName() {
        return "SpeedPowerUp";
    }

    @Override
    public AbstractMissile applyPowerUp(AbstractMissile missile) {
        return new SpeedyMissilePowerUp(missile);
    }
}
