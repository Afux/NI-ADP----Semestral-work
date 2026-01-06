package cz.cvut.fit.niadp.mvcgame.model.gameObjects.records;

import java.io.Serializable;

public record PowerUpState(int posX, int posY, String type) implements Serializable {

}
