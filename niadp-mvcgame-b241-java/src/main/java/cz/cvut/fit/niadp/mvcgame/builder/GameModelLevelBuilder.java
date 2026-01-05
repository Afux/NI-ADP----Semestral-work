package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import javafx.scene.Scene;

public class GameModelLevelBuilder implements ILevelBuilder{

    private GameModel result;
    @Override
    public void reset() {
        result = new GameModel();
    }

    @Override
    public void placeEnemy(Position pos) {
        result.addEnemy(pos);
    }

    @Override
    public void setScene(Scene scene) {

    }

    @Override
    public void placePowerUp(Position pos, IPowerUpType type) {
        result.addPowerUp(pos,type);
    }

    @Override
    public void setFactory() {

    }

    public GameModel getResult() {
        return result;
    }


}
