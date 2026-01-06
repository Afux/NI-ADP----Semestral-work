package cz.cvut.fit.niadp.mvcgame.state;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;

public interface IShootingMode {
    String getName();

    void shoot(AbstractCannon cannon);

    static IShootingMode getInstance(String name) {
        return switch (name) {
            case "SingleShootingMode" -> new SingleShootingMode();
            case "DoubleShootingMode" -> new DoubleShootingMode();
            default -> new SingleShootingMode();
        };
    }
}
