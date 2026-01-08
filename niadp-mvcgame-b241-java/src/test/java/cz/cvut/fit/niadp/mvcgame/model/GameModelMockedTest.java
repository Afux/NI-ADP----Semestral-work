package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.decorator.HugeMissilePowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import org.junit.Assert;
import org.junit.Test;

import cz.cvut.fit.niadp.mvcgame.abstractFactory.GameObjectsFactoryA;
import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

public class GameModelMockedTest {
    private static final double INIT_ANGLE = 0;
    private static final int INIT_VELOCITY = 0;
    private static final int CANNON_POS_X = 123;
    private static final int CANNON_POS_Y = 456;

    @Mocked
    private GameModel model;
    @Test
    public void createMissileTest() {
        generalMocks();
        IGameObjectsFactory factory = new GameObjectsFactoryA(model);
        AbstractMissile missile = factory.createMissile(INIT_ANGLE, INIT_VELOCITY);
        Assert.assertEquals(CANNON_POS_X, missile.getPosition().getX());
        Assert.assertEquals(CANNON_POS_Y, missile.getPosition().getY());
    }

    @Test
    public void multiplePowerUpsStackCorrectlyTest() {
        IGameObjectsFactory factory = new GameObjectsFactoryA(model);
        AbstractMissile missile = factory.createMissile(INIT_ANGLE, INIT_VELOCITY);
        int missileInitDamage= missile.getDamage();
        missile = new HugeMissilePowerUp(missile);
        Assert.assertEquals(missileInitDamage+50, missile.getDamage());
        missile = new HugeMissilePowerUp(missile);
        Assert.assertEquals(missileInitDamage+50+50, missile.getDamage());

    }
    @Test
    public void missileCollidedWithEnemyTest() {
        IGameObjectsFactory factory = new GameObjectsFactoryA(model);
        AbstractMissile missile = factory.createMissile(INIT_ANGLE, INIT_VELOCITY);
        AbstractEnemy enemy = factory.createEnemy(new Position(0,0));
        Assert.assertEquals(100, enemy.getHealthPoints());
        Assert.assertEquals(true, missile.getLifeStatus());
        missile.onCollision(enemy,model);
        enemy.onCollision(missile,model);
        Assert.assertEquals(100-missile.getDamage(), enemy.getHealthPoints());
        Assert.assertEquals(false, missile.getLifeStatus());

    }


    private void generalMocks() {
        new MockUp<GameModel>() {
            @Mock
            public Position getCannonPosition() {
                return new Position(CANNON_POS_X, CANNON_POS_Y);
            }

        };
    }

}
