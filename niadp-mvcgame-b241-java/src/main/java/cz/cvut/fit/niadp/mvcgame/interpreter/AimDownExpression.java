package cz.cvut.fit.niadp.mvcgame.interpreter;

import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

public class AimDownExpression implements CommandExpression {
    @Override
    public void interpret(IGameModel model) {
        model.aimCannonDown();
    }
}
