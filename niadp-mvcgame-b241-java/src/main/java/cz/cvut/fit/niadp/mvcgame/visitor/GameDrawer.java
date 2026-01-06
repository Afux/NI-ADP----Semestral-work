package cz.cvut.fit.niadp.mvcgame.visitor;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameResources;
import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.*;

public class GameDrawer implements IVisitor {
    @Override
    public void visit(AbstractScene scene) {
        drawBackGround(MvcGameResources.BACKGROUND_RESOURCE);
    }

    protected IGameGraphics gameGraphics;

    public void setGraphicsContext(IGameGraphics gameGraphics) {
        this.gameGraphics = gameGraphics;
    }

    @Override
    public void visit(AbstractCannon cannon) {
        drawGameObject(cannon, MvcGameResources.CANNON_RESOURCE);
    }

    @Override
    public void visit(AbstractMissile missile) {
        drawGameObject(missile, MvcGameResources.MISSILE_RESOURCE);
    }

    @Override
    public void visit(AbstractEnemy enemy) {
        if (enemy.getHealthPoints() > 50)
            drawGameObject(enemy, MvcGameResources.ENEMY_RESOURCE);
        else if (enemy.getHealthPoints() < 50 && enemy.getHealthPoints() > 0)
            drawGameObject(enemy, MvcGameResources.COLLISION_RESOURCE);
        else
            drawGameObject(enemy, MvcGameResources.DEAD_ENEMY_RESOURCE);


    }

    @Override
    public void visit(AbstractCollision collision) {
        drawGameObject(collision, MvcGameResources.DEAD_ENEMY_RESOURCE);
    }

    @Override
    public void visit(AbstractGameInfo gameInfo) {
        drawGameInfo(gameInfo);
    }

    @Override
    public void visit(AbstractPowerUp powerUp) {
        drawGameObject(powerUp, MvcGameResources.POWER_UP_RESOURCE);
    }

    protected void drawGameObject(GameObject gameObject, String resource) {
        if (gameGraphics != null)
            gameGraphics.drawImage(resource, gameObject.getPosition(), gameObject.getSize());

    }

    protected void drawBackGround(String resource) {
        if (gameGraphics != null)
            gameGraphics.drawImage(resource, new Position(0, 0), new ObjectSize(MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y));

    }


    protected void drawGameInfo(AbstractGameInfo gameInfo) {
        int lineHeight = 20;
        int startPosX = gameInfo.getPosition().getX();
        int currPosY = gameInfo.getPosition().getY();
        if (gameGraphics != null) {
            for (var entry : gameInfo.getInfo().entrySet()) {
                gameGraphics.drawText(entry.getKey() + ":" + entry.getValue(), new Position(startPosX, currPosY + lineHeight));
                currPosY += lineHeight;
            }
        }

    }

}

