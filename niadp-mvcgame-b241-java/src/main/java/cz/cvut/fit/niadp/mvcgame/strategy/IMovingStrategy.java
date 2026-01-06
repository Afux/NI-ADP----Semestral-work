package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public interface IMovingStrategy {

    static IMovingStrategy getStrategy(String name) {
        return switch (name) {
            case "Random" -> new RandomMovingStrategy();
            case "Real" -> new RealMovingStrategy();
            case "Simple" -> new SimpleMovingStrategy();
            default -> new RandomMovingStrategy();
        };
    }

    void updatePosition(AbstractMissile missile);

    IMovingStrategy getNextStrategy(GameModel model);

    String getName();

}
