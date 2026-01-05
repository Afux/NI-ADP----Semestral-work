package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.GameInfoA;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import javafx.geometry.Pos;

import java.util.Set;

public interface IGameObjectsFactory {
    public AbstractCannon createCannon();
    public AbstractCannon createCannon(AbstractCannon cannon);
    public AbstractMissile createMissile(double initAngle, int initVelocity);
    public AbstractMissile createMissile(AbstractMissile missile);

    public AbstractEnemy createEnemy(Position pos);
    public AbstractEnemy createEnemy(AbstractEnemy enemy);
    public AbstractScene createScene();
    public AbstractCollision createCollision(Position pos);
    public AbstractGameInfo createGameInfo();
    public AbstractPowerUp createPowerUp(Position pos, IPowerUpType type);
    public AbstractPowerUp createPowerUp(AbstractPowerUp powerUp);

}
