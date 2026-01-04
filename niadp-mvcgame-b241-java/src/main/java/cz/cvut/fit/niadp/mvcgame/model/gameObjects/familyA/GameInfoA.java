package cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractGameInfo;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public class GameInfoA extends AbstractGameInfo {


    public GameInfoA(IGameModel model) {
        super(model);
        position=new Position(10,20);
        gameData.put("Score", 0);
        gameData.put("Angle", "0.00");
        gameData.put("Power", 0);
        gameData.put("Mode", "");
        gameData.put("Strategy", "");
        gameData.put("Enemies Left", 0);
        updateInfo(model);


    }

    @Override
    public void updateInfo(IGameModel model) {
         gameData.put("Score",model.getScore());
         gameData.put("Angle",Math.cos(model.getCannonAngle()));
         gameData.put("Power",model.getCannonPower());
         gameData.put("Mode",model.getCannonShootingModeName());
         gameData.put("Enemies Left",model.getEnemies().size());
         gameData.put("Strategy",model.getMovingStrategyName());

    }


}
