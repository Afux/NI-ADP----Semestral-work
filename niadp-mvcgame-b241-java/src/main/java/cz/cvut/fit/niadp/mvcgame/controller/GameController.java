package cz.cvut.fit.niadp.mvcgame.controller;

import cz.cvut.fit.niadp.mvcgame.command.*;
import cz.cvut.fit.niadp.mvcgame.config.MvcGameKeys;
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker;
import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import java.util.List;

public class GameController {
    private final IGameModel model;

    public GameController(IGameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for (String code : pressedKeysCodes) {
            switch (code) {
                case MvcGameKeys.UP_KEY:
                    model.registerCommand(new MoveCannonUpCommand(model));
                    break;
                case MvcGameKeys.DOWN_KEY:
                    model.registerCommand(new MoveCannonDownCommand(model));
                    break;
                case MvcGameKeys.SPACE_KEY:
                    model.registerCommand(new CannonShootCommand(model));
                    break;
                case MvcGameKeys.ESCAPE_KEY:
                    System.exit(0);
                    break;
                case MvcGameKeys.AIM_UP_KEY:
                    model.registerCommand(new AimCannonUpCommand(model));
                    break;
                case MvcGameKeys.AIM_DOWN_KEY:
                    model.registerCommand(new AimCannonDownCommand(model));
                    break;
                case MvcGameKeys.POWER_UP_KEY:
                    model.registerCommand(new CannonPowerUpCommand(model));
                    break;
                case MvcGameKeys.POWER_DOWN_KEY:
                    model.registerCommand(new CannonPowerDownCommand(model));
                    break;
                case MvcGameKeys.TOGGLE_MOVING_STRATEGY_KEY:
                    model.registerCommand(new ToggleMovingStrategyCommand(model));
                    break;
                case MvcGameKeys.TOGGLE_SHOOTING_MODE_KEY:
                    model.registerCommand(new ToggleShootingModeCommand(model));
                    break;
                case MvcGameKeys.STORE_GAME_SNAPSHOT_KEY:
                    CareTaker.getInstance().createMemento();
                    break;
                case MvcGameKeys.RESTORE_GAME_SNAPSHOT_KEY:
                    CareTaker.getInstance().restoreMemento();
                    break;
                case MvcGameKeys.UNDO_LAST_COMMAND_KEY:
                    model.undoLastCommand();
                    break;
                case MvcGameKeys.ENTER_TEXT_COMMAND_KEY:
                    model.enterTextCommand(model);
                    break;
                case MvcGameKeys.CHANGE_LEVEL_KEY:
                    model.changeLevel();
                    break;
                default:
                    //nothing
            }
        }
        model.update();
        pressedKeysCodes.clear(); //solves problem with multiple shots being fired for single press, as a side effect causes delay in the movement input
    }
}
