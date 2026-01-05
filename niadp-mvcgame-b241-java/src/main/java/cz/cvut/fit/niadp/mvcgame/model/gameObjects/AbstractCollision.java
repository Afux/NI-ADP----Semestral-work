package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.Collideable;

public abstract class AbstractCollision extends LifetimeLimitedGameObject {

    public AbstractCollision(Position position) {
        super(position);

    }
    @Override
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public void onCollision(Collideable other, GameModel model) {

    }

    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {

    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {

    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {

    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {

    }
}
