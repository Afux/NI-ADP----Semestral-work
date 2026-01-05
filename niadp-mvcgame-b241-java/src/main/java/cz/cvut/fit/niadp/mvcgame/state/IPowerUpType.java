package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public interface IPowerUpType {
    String getName();
    AbstractMissile applyPowerUp(AbstractMissile missile);
}
