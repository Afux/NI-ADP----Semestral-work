package cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.PowerUpState;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.Collideable;

public class PowerUpA extends AbstractPowerUp {


    public PowerUpA(Position pos, IPowerUpType type) {
        super(pos, type);
    }

    public PowerUpA(PowerUpState p) {
        super(new Position(p.posX(), p.posY()), IPowerUpType.getInstance(p.type()));
    }

    public PowerUpA(AbstractPowerUp powerUp) {
        super(new Position(powerUp.getPosition().getX(), powerUp.getPosition().getY()), powerUp.getType());
    }

    @Override
    public void onCollision(Collideable other, GameModel model) {
        other.collideWithPowerUp(this, model);

    }

    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {
        setLifeStatus(false);
    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {
        setLifeStatus(false);

    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {
        setLifeStatus(false);

    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {


    }
}
