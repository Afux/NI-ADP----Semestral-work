package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.GameInfoA;
import javafx.geometry.Pos;

import java.util.Set;

public interface IGameObjectsFactory {
    public AbstractCannon createCannon();
    public AbstractCannon createCannon(AbstractCannon cannon);
    public AbstractMissile createMissile(double initAngle, int initVelocity);
    public AbstractEnemy createEnemy(Position pos);
    public AbstractEnemy createEnemy(AbstractEnemy enemy);
    public AbstractScene createScene();
    public Set<AbstractEnemy> createEnemies();
    public AbstractCollision createCollision(Position pos);
    public AbstractGameInfo createGameInfo();
}
