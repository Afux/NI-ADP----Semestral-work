package cz.cvut.fit.niadp.mvcgame.visitor;

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;

public interface IVisitor {
    void visit(AbstractCannon cannon);

    void visit(AbstractMissile missile);

    void visit(AbstractEnemy enemy);

    void visit(AbstractScene abstractScene);


    void visit(AbstractGameInfo gameInfo);

    void visit(AbstractPowerUp abstractPowerUp);
}
