package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import javafx.scene.Scene;

public interface ILevelBuilder {
    void reset();

    void placeEnemy(Position pos);

    void setScene(Scene scene);

    void placePowerUp(Position pos, IPowerUpType type);

    void setFactory();
}
