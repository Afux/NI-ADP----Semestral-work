package cz.cvut.fit.niadp.mvcgame.interpreter;

import cz.cvut.fit.niadp.mvcgame.proxy.IGameModel;

import java.util.ArrayList;
import java.util.List;

public class SequenceExpression implements CommandExpression {
    private final List<CommandExpression> commands = new ArrayList<>();

    public void addExpression(CommandExpression expression) {
        commands.add(expression);
    }

    @Override
    public void interpret(IGameModel model) {
        for (CommandExpression command : commands) {
            command.interpret(model);
        }
    }
}
