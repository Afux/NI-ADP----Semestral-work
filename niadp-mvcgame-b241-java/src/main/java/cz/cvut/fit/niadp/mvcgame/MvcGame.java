package cz.cvut.fit.niadp.mvcgame;

import java.util.List;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.controller.GameController;
import cz.cvut.fit.niadp.mvcgame.model.GameModel;
import cz.cvut.fit.niadp.mvcgame.view.GameView;
// in the future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;

public class MvcGame {
    private GameModel model;
    private GameController controller;
    private GameView view;


    public void init() {
        model = new GameModel();
        view = new GameView(model);
        controller = view.getController(); 
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

    public void setGraphicsContext(GraphicsContext graphicsContext){
        view.setGraphicsContext(graphicsContext);
    }
}