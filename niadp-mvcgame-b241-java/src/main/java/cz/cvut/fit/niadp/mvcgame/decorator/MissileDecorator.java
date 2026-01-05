package cz.cvut.fit.niadp.mvcgame.decorator;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.Collideable;

public abstract class MissileDecorator extends AbstractMissile {
    protected AbstractMissile wrappedMissile;
    public MissileDecorator(AbstractMissile missile){
        super(missile);
        this.wrappedMissile = missile;
    }


}


