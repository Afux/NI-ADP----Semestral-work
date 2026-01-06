package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.IPowerUpType;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;

public abstract class AbstractPowerUp extends GameObject {
    protected IPowerUpType type;

    public AbstractPowerUp(Position pos, IPowerUpType type) {
        this.type = type;
        this.position = pos;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public AbstractMissile applyPowerUp(AbstractMissile missile) {
        return type.applyPowerUp(missile);
    }

    public IPowerUpType getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.type.getName();
    }
}
