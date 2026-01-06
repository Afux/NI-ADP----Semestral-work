package cz.cvut.fit.niadp.mvcgame.proxy;

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RandomMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RealMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.SimpleMovingStrategy;

import java.util.Set;

public class GameModelProxy implements IGameModel {
    private final GameModel subject;

    public GameModelProxy(GameModel subject) {
        this.subject = subject;
    }

    @Override
    public void registerObserver(IObserver observer) {
        subject.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        subject.unregisterObserver(observer);
    }

    @Override
    public void notifyObservers() {
        subject.notifyObservers();
    }

    @Override
    public void update() {
        subject.update();
    }

    @Override
    public Position getCannonPosition() {
        return subject.getCannonPosition();
    }

    @Override
    public void moveCannonUp() {
        if ((subject.getCannonPosition().getY()) <= MvcGameConfig.MAX_Y + MvcGameConfig.MOVE_STEP) {
            subject.moveCannonUp();

        }
    }

    @Override
    public void moveCannonDown() {
        if ((subject.getCannonPosition().getY()) >= (-MvcGameConfig.MOVE_STEP)) {
            subject.moveCannonDown();

        }

    }

    @Override
    public void cannonShoot() {
        subject.cannonShoot();
    }

    @Override
    public void aimCannonUp() {

        if (Math.cos(subject.getCannonAngle() - MvcGameConfig.ANGLE_STEP) >= 0) {
            subject.aimCannonUp();
        }
    }

    @Override
    public void aimCannonDown() {
        if (Math.cos(subject.getCannonAngle() + MvcGameConfig.ANGLE_STEP) >= 0)
            subject.aimCannonDown();
    }

    @Override
    public void cannonPowerUp() {
        if ((subject.getCannonPower() + MvcGameConfig.POWER_STEP) <= MvcGameConfig.MAX_CANON_POWER)
            subject.cannonPowerUp();
    }

    @Override
    public void cannonPowerDown() {
        if ((subject.getCannonPower() - MvcGameConfig.POWER_STEP) >= 0)
            subject.cannonPowerDown();
    }

    @Override
    public Set<AbstractMissile> getMissiles() {
        return subject.getMissiles();
    }

    @Override
    public Set<GameObject> getGameObjects() {
        return subject.getGameObjects();
    }

    @Override
    public IMovingStrategy getMovingStrategy() {
        return subject.getMovingStrategy();
    }

    @Override
    public void toggleMovingStrategy() {
        subject.toggleMovingStrategy();
    }

    @Override
    public IMovingStrategy getNextMovingStrategy(SimpleMovingStrategy strategy) {
        return subject.getNextMovingStrategy(strategy);
    }

    @Override
    public IMovingStrategy getNextMovingStrategy(RandomMovingStrategy strategy) {
        return subject.getNextMovingStrategy(strategy);
    }

    @Override
    public IMovingStrategy getNextMovingStrategy(RealMovingStrategy strategy) {
        return subject.getNextMovingStrategy(strategy);
    }

    @Override
    public String getMovingStrategyName() {
        return subject.getMovingStrategyName();
    }

    @Override
    public AbstractScene getScene() {
        return subject.getScene();
    }

    @Override
    public void toggleShootingMode() {
        subject.toggleShootingMode();
    }

    @Override
    public Object createMemento() {
        return subject.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        subject.setMemento(memento);
    }

    @Override
    public void registerCommand(AbstractGameCommand command) {
        subject.registerCommand(command);
    }

    @Override
    public void undoLastCommand() {
        subject.undoLastCommand();
    }

    @Override
    public int getScore() {
        return subject.getScore();
    }

    @Override
    public double getCannonAngle() {
        return subject.getCannonAngle();
    }

    @Override
    public int getCannonPower() {
        return subject.getCannonPower();
    }

    @Override
    public String getCannonShootingModeName() {
        return subject.getCannonShootingModeName();
    }

    @Override
    public Set<AbstractEnemy> getEnemies() {
        return subject.getEnemies();
    }

    @Override
    public Set<AbstractPowerUp> getPowerUps() {
        return subject.getPowerUps();
    }
}
