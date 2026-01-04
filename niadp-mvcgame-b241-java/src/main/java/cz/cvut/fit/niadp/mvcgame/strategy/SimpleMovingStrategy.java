package cz.cvut.fit.niadp.mvcgame.strategy;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public class SimpleMovingStrategy implements IMovingStrategy{

    @Override
    public void updatePosition(AbstractMissile missile) {

        double speed = missile.getInitVelocity();
        double angle = missile.getInitAngle();
        int dX = (int) (speed * Math.cos(angle));
        int dY = (int) (speed * Math.sin(angle));
        missile.move(new Vector(dX, dY));
    }

    @Override
    public IMovingStrategy getNextStrategy(GameModel model) {
        return model.getNextMovingStrategy(this);
    }
    @Override
    public String getName() {
        return "SimpleMovingStrategy";
    }
}
