package cz.cvut.fit.niadp.mvcgame.interpreter;

import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

public interface CommandExpression {
    void interpret(IGameModel model);
}
