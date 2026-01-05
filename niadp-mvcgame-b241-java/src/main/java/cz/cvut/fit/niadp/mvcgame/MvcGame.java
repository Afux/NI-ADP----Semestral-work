package cz.cvut.fit.niadp.mvcgame;

import java.util.List;

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.niadp.mvcgame.builder.Director;
import cz.cvut.fit.niadp.mvcgame.builder.GameModelLevelBuilder;
import cz.cvut.fit.niadp.mvcgame.builder.ILevelBuilder;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.proxy.GameModelProxy;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.niadp.mvcgame.view.GameView;

public class MvcGame {
    private IGameModel model;
    private GameController controller;
    private GameView view;

    private GameModelLevelBuilder builder = new GameModelLevelBuilder();
    private final Director director =  new Director(builder);
    public void init() {
        director.CreateMediumLevel();
        model = new GameModelProxy(builder.getResult());
        view = new GameView(model);
        controller = view.getController(); 
        CareTaker.getInstance().setModel(model);
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        controller.processPressedKeys(pressedKeysCodes);
    }


    public String getWindowTitle() {
        return "The NI-ADP MvcGame";
    }

    public int getWindowWidth() {
        return MvcGameConfig.MAX_X;
    }

    public int getWindowHeight() {
        return  MvcGameConfig.MAX_Y;
    }

    public void setGraphicsContext(IGameGraphics gameGraphics){
        view.setGraphicsContext(gameGraphics);
    }
}