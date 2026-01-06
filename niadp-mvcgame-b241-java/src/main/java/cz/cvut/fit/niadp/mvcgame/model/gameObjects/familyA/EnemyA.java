package cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractCannon;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractMissile;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractPowerUp;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.records.EnemyState;
import cz.cvut.fit.niadp.mvcgame.visitor.doubleDispatch.Collideable;

public class EnemyA extends AbstractEnemy {
    public EnemyA(Position pos) {
        this.position = pos;
        this.healthPoints = MvcGameConfig.MAX_HEALTH_POINTS;
    }

    public EnemyA(AbstractEnemy enemy) {
        this.position = new Position(enemy.getPosition());
        this.healthPoints = enemy.getHealthPoints();
    }

    public EnemyA(EnemyState enemy) {
        this.position = new Position(enemy.posX(), enemy.posY());
        this.healthPoints = enemy.healthPoints();
    }

    @Override
    public void hitEnemy(int damage) {
        healthPoints -= damage;
    }

    @Override
    public void onCollision(Collideable other, GameModel model) {
        other.collideWithEnemy(this, model);
    }

    @Override
    public void collideWithCanon(AbstractCannon Canon, GameModel model) {

    }

    @Override
    public void collideWithEnemy(AbstractEnemy enemy, GameModel model) {

    }

    @Override
    public void collideWithPowerUp(AbstractPowerUp powerUp, GameModel model) {

    }

    @Override
    public void collideWithMissile(AbstractMissile missile, GameModel model) {
        hitEnemy(missile.getDamage());
        if (getHealthPoints() <= 0) {
            setLifeStatus(false);
        }
    }


}
