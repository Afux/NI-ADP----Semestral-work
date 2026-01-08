package cz.cvut.fit.niadp.mvcgame.interpretor;

public class CommandParser {

    public static CommandExpression parse(String text) {
        SequenceExpression sequence = new SequenceExpression();


        String[] tokens = text.toLowerCase().split(" ");

        for (String token : tokens) {
            switch (token) {
                case "up":
                    sequence.addExpression(new AimUpExpression());
                    break;
                case "down":
                    sequence.addExpression(new AimDownExpression());
                    break;
                case "shoot":
                    sequence.addExpression(new ShootExpression());
                    break;
                default:
                    System.out.println("Neznámý příkaz: " + token);
            }
        }

        return sequence;
    }
}
