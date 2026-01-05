package cz.cvut.fit.niadp.mvcgame.abstractFactory;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.*;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;

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
    public MissileA createMissile(AbstractMissile missile) {
        return new MissileA(missile);
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
    public AbstractPowerUp createPowerUp(AbstractPowerUp powerUp) {
        return new PowerUpA(powerUp);
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
    public AbstractPowerUp createPowerUp(Position pos, IPowerUpType type) {
        return  new PowerUpA(pos,type);
    }

}
