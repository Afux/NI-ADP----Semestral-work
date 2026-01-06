package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractScene implements IVisitable {
    protected AbstractScene() {


    }


    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
