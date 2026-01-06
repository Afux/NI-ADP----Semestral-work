package cz.cvut.fit.niadp.mvcgame.decorator;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;

public abstract class MissileDecorator extends AbstractMissile {
    protected AbstractMissile wrappedMissile;

    public MissileDecorator(AbstractMissile missile) {
        super(missile);
        this.wrappedMissile = missile;
    }


}


