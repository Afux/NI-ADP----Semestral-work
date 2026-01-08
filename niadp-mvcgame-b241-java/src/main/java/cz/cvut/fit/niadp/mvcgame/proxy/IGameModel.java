package cz.cvut.fit.niadp.mvcgame.proxy;

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RandomMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RealMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.SimpleMovingStrategy;

import java.util.Set;

public interface IGameModel extends IObservable {
    void update();

    Position getCannonPosition();

    void moveCannonUp();

    void moveCannonDown();

    void cannonShoot();

    void aimCannonUp();

    void aimCannonDown();

    void cannonPowerUp();

    void cannonPowerDown();

    Set<AbstractMissile> getMissiles();

    Set<GameObject> getGameObjects();

    IMovingStrategy getMovingStrategy();

    void toggleMovingStrategy();

    IMovingStrategy getNextMovingStrategy(SimpleMovingStrategy strategy);

    IMovingStrategy getNextMovingStrategy(RandomMovingStrategy strategy);

    IMovingStrategy getNextMovingStrategy(RealMovingStrategy strategy);

    void toggleShootingMode();

    Object createMemento();

    void setMemento(Object memento);

    void registerCommand(AbstractGameCommand command);

    void undoLastCommand();

    AbstractScene getScene();

    int getScore();

    double getCannonAngle();

    int getCannonPower();

    String getCannonShootingModeName();

    Set<AbstractEnemy> getEnemies();

    String getMovingStrategyName();

    Set<AbstractPowerUp> getPowerUps();

    void enterTextCommand(IGameModel model);

    void changeLevel();
}
