package cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbstractEnemy;

public class EnemyA extends AbstractEnemy {
    public EnemyA(Position pos) {
        this.position = pos;
        this.healthPoints = MvcGameConfig.MAX_HEALTH_POINTS;
    }
    public EnemyA(AbstractEnemy enemy) {
        this.position = new Position(enemy.getPosition());
        this.healthPoints = enemy.getHealthPoints();
    }

    @Override
    public void hitEnemy(int damage) {
        healthPoints-=damage;
    }
}
