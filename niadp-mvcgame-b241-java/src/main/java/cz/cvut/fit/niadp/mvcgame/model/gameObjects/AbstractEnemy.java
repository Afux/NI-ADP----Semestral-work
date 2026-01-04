package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractEnemy extends GameObject {

    protected int healthPoints;
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    public abstract void hitEnemy(int damage);
    public int getHealthPoints() {
        return healthPoints;
    }
}

