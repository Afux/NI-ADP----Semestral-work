package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractFactory.GameObjectsFactoryA;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.CannonState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.EnemyState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.PowerUpState;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

public class MementoWithMockedObjectsTest {
    @Mocked
    private AbstractCannon mockCannon;
    @Mocked
    private AbstractEnemy mockEnemy;
    @Mocked
    private AbstractScene mockScene;
    @Mocked
    private AbstractGameInfo mockGameInfo;
    @Mocked
    private AbstractCannon restoredCannon;
    @Mocked
    private AbstractEnemy restoredEnemy;
    @Mocked
    private AbstractPowerUp mockedPowerUp;
    @Mocked
    private AbstractPowerUp restoredPowerUp;
    @Test
    public void saveAndRestoreMemento() {
        setupFactoryMock();


        GameModel model = new GameModel();

        model.updateScore(100);
        model.toggleMovingStrategy();
        String originalStrategy = model.getMovingStrategyName();
        model.getEnemies().add(mockEnemy);
        model.getPowerUps().add(mockedPowerUp);


        Object memento = model.createMemento();


        model.updateScore(10);
        model.toggleMovingStrategy();
        model.getEnemies().clear();
        model.getPowerUps().clear();


        Assert.assertNotEquals(100, model.getScore());
        Assert.assertNotEquals(originalStrategy, model.getMovingStrategyName());

        model.setMemento(memento);

        Assert.assertEquals(100, model.getScore());
        Assert.assertEquals( originalStrategy, model.getMovingStrategyName());

        Assert.assertEquals(1, model.getEnemies().size());
        Assert.assertTrue(model.getEnemies().contains(restoredEnemy));
        Assert.assertEquals(1, model.getPowerUps().size());
        Assert.assertTrue(model.getPowerUps().contains(restoredPowerUp));
    }

    private void setupFactoryMock() {
        new MockUp<GameObjectsFactoryA>() {
            @Mock
            AbstractCannon createCannon() {
                return mockCannon;
            }

            @Mock
            AbstractScene createScene() {
                return mockScene;
            }

            @Mock
            AbstractGameInfo createGameInfo() {
                return mockGameInfo;
            }

            @Mock
            AbstractEnemy createEnemy(mockit.Invocation inv) {
                return mockEnemy;
            }


            @Mock
            CannonState createCannonState(AbstractCannon cannon) {
                return new CannonState(cannon.getPosition().getX(), cannon.getPosition().getY(), cannon.getAngle(), cannon.getPower(), cannon.getShootingModeName());
            }

            @Mock
            EnemyState createEnemyState(AbstractEnemy e) {
                return new EnemyState(e.getPosition().getX(), e.getPosition().getY(), e.getHealthPoints());

            }


            @Mock
            AbstractCannon createCannonFromState(CannonState s) {
                return restoredCannon;
            }

            @Mock
            AbstractEnemy createEnemyFromState(EnemyState s) {
                return restoredEnemy;
            }

            @Mock
            AbstractPowerUp createPowerUpFromState(PowerUpState p) {
                return restoredPowerUp;
            }

            @Mock
            public PowerUpState createPowerUpState(AbstractPowerUp p) {
                return new PowerUpState(p.getPosition().getX(), p.getPosition().getY(), p.getTypeName());
            }
        };
    }


}
