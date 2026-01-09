package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.CannonState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.EnemyState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.PowerUpState;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;

public interface IGameObjectsFactory {
    AbstractCannon createCannon();

    AbstractCannon createCannon(AbstractCannon cannon);

    AbstractMissile createMissile(double initAngle, int initVelocity);

    AbstractMissile createMissile(AbstractMissile missile);

    AbstractEnemy createEnemy(Position pos);

    AbstractEnemy createEnemy(AbstractEnemy enemy);

    AbstractScene createScene();


    AbstractGameInfo createGameInfo();

    AbstractPowerUp createPowerUp(Position pos, IPowerUpType type);

    AbstractPowerUp createPowerUp(AbstractPowerUp powerUp);

    AbstractCannon createCannonFromState(CannonState cannon);

    CannonState createCannonState(AbstractCannon cannon);

    EnemyState createEnemyState(AbstractEnemy e);

    AbstractEnemy createEnemyFromState(EnemyState s);

    AbstractPowerUp createPowerUpFromState(PowerUpState p);

    PowerUpState createPowerUpState(AbstractPowerUp p);
}
