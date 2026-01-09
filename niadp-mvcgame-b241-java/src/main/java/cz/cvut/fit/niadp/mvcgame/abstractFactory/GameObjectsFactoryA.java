package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.CannonState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.EnemyState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.PowerUpState;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;

public class GameObjectsFactoryA implements IGameObjectsFactory {

    protected final IGameModel model;

    public GameObjectsFactoryA(IGameModel model) {
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
    public MissileA createMissile(AbstractMissile missile) {
        return new MissileA(missile);
    }

    @Override
    public EnemyA createEnemy(Position pos) {
        return new EnemyA(pos);
    }


    @Override
    public GameInfoA createGameInfo() {
        return new GameInfoA(model);
    }

    @Override
    public PowerUpA createPowerUp(AbstractPowerUp powerUp) {
        return new PowerUpA(powerUp);
    }

    @Override
    public CannonA createCannon(AbstractCannon cannon) {
        return new CannonA(cannon);
    }

    @Override
    public EnemyA createEnemy(AbstractEnemy enemy) {
        return new EnemyA(enemy);
    }

    @Override
    public PowerUpA createPowerUp(Position pos, IPowerUpType type) {
        return new PowerUpA(pos, type);
    }

    @Override
    public CannonA createCannonFromState(CannonState cannon) {
        return new CannonA(cannon, this);

    }

    @Override
    public CannonState createCannonState(AbstractCannon cannon) {
        return new CannonState(cannon.getPosition().getX(), cannon.getPosition().getY(), cannon.getAngle(), cannon.getPower(), cannon.getShootingModeName());
    }

    @Override
    public EnemyState createEnemyState(AbstractEnemy e) {
        return new EnemyState(e.getPosition().getX(), e.getPosition().getY(), e.getHealthPoints());
    }

    @Override
    public AbstractEnemy createEnemyFromState(EnemyState s) {
        return new EnemyA(s);

    }

    @Override
    public AbstractPowerUp createPowerUpFromState(PowerUpState p) {
        return new PowerUpA(p);
    }

    @Override
    public PowerUpState createPowerUpState(AbstractPowerUp p) {
        return new PowerUpState(p.getPosition().getX(), p.getPosition().getY(), p.getTypeName());
    }
}
