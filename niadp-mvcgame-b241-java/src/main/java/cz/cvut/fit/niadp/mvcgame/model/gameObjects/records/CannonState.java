package cz.cvut.fit.niadp.mvcgame.model.gameObjects.records;

import java.io.Serializable;

public record CannonState(int posX, int posY, double angle, int power,
                          String shootingModeName) implements Serializable {


}
