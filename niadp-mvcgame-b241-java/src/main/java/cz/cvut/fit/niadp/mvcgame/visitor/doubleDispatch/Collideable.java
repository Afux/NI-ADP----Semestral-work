package cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;

public interface Collideable {
    void onCollision(Collideable other, GameModel model);

    void collideWithCanon(AbstractCannon Canon,GameModel model);
    void collideWithEnemy(AbstractEnemy enemy,GameModel model);
    void collideWithMissile(AbstractMissile missile,GameModel model);
    void collideWithPowerUp(AbstractPowerUp powerUp,GameModel model);
}
