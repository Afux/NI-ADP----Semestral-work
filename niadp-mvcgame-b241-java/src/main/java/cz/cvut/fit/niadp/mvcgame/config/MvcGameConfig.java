package cz.cvut.fit.niadp.mvcgame.config;

import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;

import java.util.List;

public class MvcGameConfig {

    public static final int INIT_DAMAGE = 51;
    public static final int MAX_SNAPSHOT_SAVE_SLOTS = 3;
    public static final String SNAPSHOT_FILE_PREFIX = "snapshot_";

    private MvcGameConfig() {

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
    public static final List<Position> EASY_LEVEL_ENEMY_POSITIONS = List.of(
            new Position(500, 500),
            new Position(580, 500),
            new Position(540, 420)
    );
    public static final List<Position> EASY_LEVEL_POWER_UPS__POSITIONS = List.of(new Position(600, 800));

    public static final List<Position> MEDIUM_LEVEL_ENEMY_POSITIONS = List.of(
            new Position(480, 500),
            new Position(620, 500),
            new Position(550, 350),
            new Position(650, 350),
            new Position(600, 250)
    );

    public static final List<Position> MEDIUM_LEVEL_POWER_UPS__POSITIONS = List.of(new Position(200, 500));

    public static final List<Position> HARD_LEVEL_ENEMY_POSITIONS = List.of(
            new Position(450, 500),
            new Position(750, 500),
            new Position(850, 480),
            new Position(550, 300),
            new Position(650, 300),
            new Position(600, 150),
            new Position(700, 200)
    );

    public static final List<Position> HARD_LEVEL_POWER_UPS__POSITIONS = List.of(new Position(600, 800));

    public static List<Position> ALL_POSSIBLE_ENEMIES_POSITION = List.of(

            new Position(480, 500),
            new Position(580, 500),
            new Position(680, 500),
            new Position(780, 500),

            new Position(530, 350),
            new Position(630, 350),
            new Position(580, 400),

            new Position(550, 200),
            new Position(650, 180),
            new Position(750, 250)
    );
    public static final List<Position> ALL_POSSIBLE_POWER_UPS_POSITIONS = List.of(new Position(600, 800),
            new Position(200, 500));

    public static final ObjectSize CANON_SIZE = new ObjectSize(25, 70);
    public static final ObjectSize SMALL_GAME_OBJECT_SIZE = new ObjectSize(30, 30);
    public static final ObjectSize MEDIUM_GAME_OBJECT_SIZE = new ObjectSize(50, 50);
    public static final ObjectSize BIG_GAME_OBJECT_SIZE = new ObjectSize(70, 70);
}