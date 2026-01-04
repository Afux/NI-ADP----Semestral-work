package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCollision;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractGameInfo;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.*;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.util.HashSet;
import java.util.Set;

public class GameObjectsFactoryA implements IGameObjectsFactory{

    protected final IGameModel model;

    public GameObjectsFactoryA(IGameModel model){
        this.model = model;
    }

    @Override
    public CannonA createCannon() {
        return new CannonA(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y), this);
    }

    @Override
    public SceneA createScene() {
        return new SceneA();
    }

    @Override
    public MissileA createMissile(double initAngle, int initVelocity) {
        return new MissileA(
            new Position(model.getCannonPosition().getX(), model.getCannonPosition().getY()),
            initAngle,
            initVelocity,
            model.getMovingStrategy()
        );
    }

    @Override
    public EnemyA createEnemy(Position pos) {
        return new EnemyA(pos);
    }

    @Override
    public AbstractCollision createCollision(Position pos) {
        return new CollisionA(pos);
    }
    @Override
    public AbstractGameInfo createGameInfo() {
        return new GameInfoA(model);
    }

    @Override
    public AbstractCannon createCannon(AbstractCannon cannon) {
        return new CannonA(cannon);
    }

    @Override
    public AbstractEnemy createEnemy(AbstractEnemy enemy) {
        return new EnemyA(enemy);
    }

    @Override
    public Set<AbstractEnemy> createEnemies() {
        Set<AbstractEnemy> enemies = new HashSet<>();
        for (Position p : MvcGameConfig.ENEMY_POSITIONS) {
            enemies.add(createEnemy(p));
        }

        return enemies;
    }
}
