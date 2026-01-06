package cz.cvut.fit.niadp.mvcgame.model.gameObjects.records;

import java.io.Serializable;

public record EnemyState(int posX, int posY, int healthPoints) implements Serializable {

}
