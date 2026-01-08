package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.abstractFactory.GameObjectsFactoryA;
import cz.cvut.fit.niadp.mvcgame.decorator.HugeMissilePowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.EnemyA;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.MissileA;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.PowerUpA;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.CannonState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.EnemyState;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.PowerUpState;
import cz.cvut.fit.niadp.mvcgame.strategy.SimpleMovingStrategy;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import cz.cvut.fit.niadp.mvcgame.command.MoveCannonUpCommand;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import java.security.PrivateKey;


public class GameModelBasicTest {




    @Test
    public void undoLastCommandTest() {
        IGameModel gameModel = new GameModel();
        int beginCannonPositionX = gameModel.getCannonPosition().getX();
        int beginCannonPositionY = gameModel.getCannonPosition().getY();
        gameModel.registerCommand(new MoveCannonUpCommand(gameModel));
        gameModel.update();
        Assert.assertEquals(beginCannonPositionX, gameModel.getCannonPosition().getX());
        Assert.assertEquals(beginCannonPositionY - MvcGameConfig.MOVE_STEP, gameModel.getCannonPosition().getY());
        gameModel.undoLastCommand();
        Assert.assertEquals(beginCannonPositionX, gameModel.getCannonPosition().getX());
        Assert.assertEquals(beginCannonPositionY, gameModel.getCannonPosition().getY());

    }

}
