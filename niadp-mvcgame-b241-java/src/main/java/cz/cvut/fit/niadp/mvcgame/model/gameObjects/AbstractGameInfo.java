package cz.cvut.fit.niadp.mvcgame.model.gameObjects;

import cz.cvut.fit.niadp.mvcgame.observer.IObserver;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractGameInfo extends GameObject implements IObserver {
    protected IGameModel gameModel;
    protected final Map<String, Object> gameData;
    public AbstractGameInfo(IGameModel model){
        gameModel = model;
        gameData= new LinkedHashMap<>();
        this.gameModel.registerObserver(this);
    }

    public Map<String, Object> getInfo(){
        return gameData;
    };
    public abstract void updateInfo(IGameModel model);
    @Override
    public void update() {
        updateInfo(gameModel);
    }
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
