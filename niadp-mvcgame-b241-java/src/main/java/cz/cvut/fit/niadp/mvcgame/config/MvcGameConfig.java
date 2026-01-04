package cz.cvut.fit.niadp.mvcgame.config;

import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import javafx.css.Size;

import java.util.List;

public class MvcGameConfig {

    public static final int INIT_DAMAGE = 51 ;

    private MvcGameConfig(){

    }

    public static final int MAX_X = 1920;
    public static final int MAX_Y = 1080;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MOVE_STEP = 10;

    public static final int CANNON_POS_X = 50;
    public static final int CANNON_POS_Y = MAX_Y / 2;

    public static final double INIT_ANGLE = 6.28;
    public static final int INIT_POWER = 25;
    public static final double ANGLE_STEP = Math.PI / 18;
    public static final int POWER_STEP = 1;
    public static final double GRAVITY = 9.81;
    public static final int MAGIC_TIME_CONST = 100;
    public static final int MAX_CANON_POWER = 50;
    public static final int MAX_HEALTH_POINTS = 100;
    public static final List<Position> ENEMY_POSITIONS = List.of(
            new Position(480, 490),
            new Position(550, 350),
            new Position(650, 500),
            new Position(720, 280),
            new Position(600, 180)
    );
    public static final ObjectSize CANON_SIZE = new ObjectSize(25,70);
    public static final ObjectSize SMALL_GAME_OBJECT_SIZE = new ObjectSize(30,30);
    public static final ObjectSize MEDIUM_GAME_OBJECT_SIZE = new ObjectSize(50,50);
    public static final ObjectSize BIG_GAME_OBJECT_SIZE = new ObjectSize(70,70);
}