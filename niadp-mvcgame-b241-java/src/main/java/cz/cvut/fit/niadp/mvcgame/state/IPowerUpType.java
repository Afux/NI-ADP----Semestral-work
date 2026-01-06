package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public interface IPowerUpType {
    static IPowerUpType getInstance(String type) {
        return switch (type) {
            case "SpeedPowerUp" -> new SpeedPowerUp();
            case "HugeMissilePowerUp" -> new HugeMissilePowerUp();
            default -> new SpeedPowerUp();
        };
    }

    String getName();

    AbstractMissile applyPowerUp(AbstractMissile missile);
}
