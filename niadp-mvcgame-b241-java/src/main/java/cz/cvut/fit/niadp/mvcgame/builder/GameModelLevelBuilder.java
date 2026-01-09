package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import javafx.scene.Scene;

public class GameModelLevelBuilder implements ILevelBuilder {

    private GameModel model;

    @Override
    public void reset() {
        model = new GameModel();
    }

    @Override
    public void placeEnemy(Position pos) {
        model.addEnemy(pos);
    }

    @Override
    public void setScene(Scene scene) {

    }

    @Override
    public void placePowerUp(Position pos, IPowerUpType type) {
        model.addPowerUp(pos, type);
    }

    @Override
    public void setFactory() {

    }

    public GameModel getResult() {
        return model;
    }


}
