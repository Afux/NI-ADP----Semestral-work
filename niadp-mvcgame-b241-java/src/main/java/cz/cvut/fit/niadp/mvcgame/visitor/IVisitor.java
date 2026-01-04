package cz.cvut.fit.niadp.mvcgame.visitor;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;

public interface IVisitor {
    public void visit(AbstractCannon cannon);
    public void visit(AbstractMissile missile);
    public void visit(AbstractEnemy enemy);
    public void visit(AbstractScene abstractScene);
    public void visit(AbstractCollision abstractCollision);
    public void visit(AbstractGameInfo gameInfo);
}
