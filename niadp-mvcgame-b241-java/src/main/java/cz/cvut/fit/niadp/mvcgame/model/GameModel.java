package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractFactory.GameObjectsFactoryA;
import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RandomMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.RealMovingStrategy;
import cz.cvut.fit.niadp.mvcgame.strategy.SimpleMovingStrategy;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel implements IGameModel {
    protected final Queue<AbstractGameCommand> unexecutedCommands;
    protected final Stack<AbstractGameCommand> executedCommands;
    private final Set<AbstractMissile> missiles;
    private final Set<AbstractCollision> collisions;
    private final Set<IObserver> observers;
    private final Set<AbstractEnemy> enemies;
    private final AbstractScene scene;
    private final IGameObjectsFactory factory;
    private final AbstractGameInfo gameInfo;
    protected IMovingStrategy movingStrategy;
    private AbstractCannon cannon;
    private int score;

    public GameModel() {
        factory = new GameObjectsFactoryA(this);
        observers = new HashSet<IObserver>();
        cannon = factory.createCannon();
        missiles = new HashSet<AbstractMissile>();
        movingStrategy = new RealMovingStrategy();
        unexecutedCommands = new LinkedBlockingQueue<>();
        executedCommands = new Stack<>();
        scene = factory.createScene();
        enemies = factory.createEnemies();
        collisions = new HashSet<AbstractCollision>();
        gameInfo = factory.createGameInfo();
        score = 0;

    }

    public void update() {
        removeKilledEnemies();
        moveMissiles();
        executeCommands();
        checkForCollisions();
    }

    private void executeCommands() {
        while (!unexecutedCommands.isEmpty()) {
            executedCommands.push(unexecutedCommands.poll().doExecute());
        }
    }

    protected void moveMissiles() {
        missiles.forEach(missile -> missile.move());
        destroyMissiles();
        notifyObservers();
    }

    protected void destroyMissiles() {
        missiles.removeAll(missiles.stream().filter(missile -> missile.getPosition().getX() > MvcGameConfig.MAX_X || missile.getPosition().getX() < MvcGameConfig.MIN_X || missile.getPosition().getY() > MvcGameConfig.MAX_Y || missile.getPosition().getY() < MvcGameConfig.MIN_Y).toList());
    }

    protected void checkForCollisions() {
        Set<AbstractMissile> missilesToRemove = new HashSet<>();
        Set<AbstractEnemy> enemiesToRemove = new HashSet<>();
        missiles.forEach(missile -> {
            enemies.forEach(enemy -> {
                if (isCollision(missile, enemy)) {
                    enemy.hitEnemy(missile.getDamage());
                    missilesToRemove.add(missile);
                    if (enemy.getHealthPoints() < 0) {
                        collisions.add(factory.createCollision(enemy.getPosition()));
                        enemiesToRemove.add(enemy);
                        score++;
                    }
                }
            });
        });

        missiles.removeAll(missilesToRemove);
        enemies.removeAll(enemiesToRemove);
        notifyObservers();
    }

    public Position getCannonPosition() {
        return cannon.getPosition();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void cannonShoot() {
        missiles.addAll(cannon.shoot());
        notifyObservers();
    }

    public void aimCannonUp() {
        cannon.aimUp();
        notifyObservers();
    }

    public void aimCannonDown() {
        cannon.aimDown();
        notifyObservers();
    }

    public void cannonPowerUp() {
        cannon.powerUp();
        notifyObservers();
    }

    public void cannonPowerDown() {
        cannon.powerDown();
        notifyObservers();
    }

    public AbstractScene getScene() {
        return scene;
    }

    public Set<AbstractMissile> getMissiles() {
        return missiles;
    }

    private boolean isCollision(GameObject a, GameObject b) {
        return a.getPosition().getX() < b.getPosition().getX() + b.getSize().getWidth() && a.getPosition().getX() + a.getSize().getWidth() > b.getPosition().getX() && a.getPosition().getY() < b.getPosition().getY() + b.getSize().getHeight() && a.getPosition().getY() + a.getSize().getHeight() > b.getPosition().getY();
    }

    public Set<GameObject> getGameObjects() {
        var gameObjects = new HashSet<GameObject>();
        gameObjects.add(gameInfo);
        gameObjects.addAll(missiles);
        gameObjects.add(cannon);
        gameObjects.addAll(enemies);
        gameObjects.addAll(collisions);
        return gameObjects;
    }

    public void removeKilledEnemies() {
        collisions.forEach(collision -> {
            if (collision.getAge() > 25) collisions.remove(collision);
        });
    }

    public IMovingStrategy getMovingStrategy() {
        return movingStrategy;
    }


    public double getCannonAngle() {
        return cannon.getAngle();
    }

    public int getCannonPower() {
        return cannon.getPower();
    }

    public int getScore() {
        return score;
    }

    public String getCannonShootingModeName() {
        return cannon.getShootingModeName();
    }

    public Set<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public String getMovingStrategyName() {
        return movingStrategy.getName();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    public void toggleMovingStrategy() {
        movingStrategy = movingStrategy.getNextStrategy(this);

    }


    public IMovingStrategy getNextMovingStrategy(SimpleMovingStrategy strategy) {
        return new RandomMovingStrategy();
    }

    public IMovingStrategy getNextMovingStrategy(RandomMovingStrategy strategy) {
        return new RealMovingStrategy();
    }

    public IMovingStrategy getNextMovingStrategy(RealMovingStrategy strategy) {
        return new SimpleMovingStrategy();
    }

    public void toggleShootingMode() {
        cannon.toggleShootingMode();
    }

    public Object createMemento() {
        Memento gameModelSnapshot = new Memento();
        gameModelSnapshot.cannon = factory.createCannon(cannon);
        gameModelSnapshot.movingStrategy = this.movingStrategy;
        gameModelSnapshot.score = this.score;
        gameModelSnapshot.enemies = new HashSet<>();
        for (AbstractEnemy e : enemies) {
            gameModelSnapshot.enemies.add(factory.createEnemy(e));
        }
        return gameModelSnapshot;
    }

    public void setMemento(Object memento) {
        Memento gameModelSnapshot = (Memento) memento;
        this.movingStrategy = gameModelSnapshot.movingStrategy;
        this.score = gameModelSnapshot.score;
        cannon = factory.createCannon(gameModelSnapshot.cannon);
        enemies.clear();
        enemies.addAll(gameModelSnapshot.enemies);
        missiles.clear();

    }

    @Override
    public void registerCommand(AbstractGameCommand command) {
        unexecutedCommands.add(command);
    }

    @Override
    public void undoLastCommand() {
        if (!executedCommands.isEmpty()) {
            executedCommands.pop().unExecute();
            notifyObservers();
        }
    }

    private static class Memento {
        private AbstractCannon cannon;
        private Set<AbstractEnemy> enemies;
        private IMovingStrategy movingStrategy;
        private int score;
        // game snapshot
    }
}
