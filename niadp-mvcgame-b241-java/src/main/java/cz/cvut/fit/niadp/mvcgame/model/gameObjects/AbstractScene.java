package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractScene implements IVisitable {
    protected AbstractScene() {


    }


    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
