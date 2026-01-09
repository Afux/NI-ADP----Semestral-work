package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.Vector;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.ICollideable;

public abstract class GameObject implements IVisitable, ICollideable {
    protected Position position;
    protected ObjectSize size;
    protected boolean isAlive;

    GameObject() {
        this.size = MvcGameConfig.MEDIUM_GAME_OBJECT_SIZE;
        this.isAlive = true;
    }

    public void move(Vector vector) {
        position.add(vector);
    }

    public Position getPosition() {
        return position;
    }

    public ObjectSize getSize() {
        return size;
    }

    public boolean getLifeStatus() {
        return isAlive;
    }

    public void setLifeStatus(boolean isAlive) {
        this.isAlive = isAlive;
    }

}
