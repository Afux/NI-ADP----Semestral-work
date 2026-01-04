package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractCollision extends LifetimeLimitedGameObject {

    public AbstractCollision(Position position) {
        super(position);

    }
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}
