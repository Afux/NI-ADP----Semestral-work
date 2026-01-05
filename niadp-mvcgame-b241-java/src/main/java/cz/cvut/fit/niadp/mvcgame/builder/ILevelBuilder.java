package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public interface ILevelBuilder {
    public void reset();

    void placeEnemy(Position pos);
    public void setScene(Scene scene);

    void placePowerUp(Position pos, IPowerUpType type);

    public void setFactory();
}
