package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.HugeMissilePowerUp;
import cz.cvut.fit.niadp.mvcgame.state.SpeedPowerUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameModelLevelDirector {
    private ILevelBuilder builder;
    private final List<Position> allPossibleEnemiesPosition = new ArrayList<>(MvcGameConfig.ALL_POSSIBLE_ENEMIES_POSITION);
    private final List<Position> allPossiblePowerUpsPosition = new ArrayList<>(MvcGameConfig.ALL_POSSIBLE_POWER_UPS_POSITIONS);
    private long seed = System.nanoTime();
    private final Random random = new Random(seed);

    public GameModelLevelDirector(ILevelBuilder builder) {
        this.builder = builder;
        reset();
    }

    public void CreatePeaceFullLevel() {
        reset();
    }

    public void CreateRandomLevel() {
        reset();
        Collections.shuffle(allPossibleEnemiesPosition);
        Collections.shuffle(allPossiblePowerUpsPosition);
        int pigCount = random.nextInt(allPossibleEnemiesPosition.size());
        int powerUpsCount = random.nextInt(allPossiblePowerUpsPosition.size());

        allPossibleEnemiesPosition.stream().limit(pigCount).forEach(pos -> {
            builder.placeEnemy(pos);
        });
        allPossiblePowerUpsPosition.stream().limit(powerUpsCount).forEach(pos -> {
            builder.placePowerUp(pos, new SpeedPowerUp());
        });

    }

    public void CreateEasyLevel() {
        reset();
        MvcGameConfig.EASY_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {
                    builder.placeEnemy(position);
                }
        );
        MvcGameConfig.EASY_LEVEL_POWER_UPS_POSITIONS.forEach(
                position -> {
                    builder.placePowerUp(position, new SpeedPowerUp());
                }
        );
    }

    public void CreateMediumLevel() {
        reset();
        MvcGameConfig.MEDIUM_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {
                    builder.placeEnemy(position);
                }
        );
        MvcGameConfig.MEDIUM_LEVEL_POWER_UPS_POSITIONS.forEach(
                position -> {
                    builder.placePowerUp(position, new HugeMissilePowerUp());
                }
        );
    }

    public void CreateHardLevel() {
        reset();
        MvcGameConfig.HARD_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {
                    builder.placeEnemy(position);
                }
        );
        MvcGameConfig.HARD_LEVEL_POWER_UPS_POSITIONS.forEach(
                position -> {
                    builder.placePowerUp(position, new SpeedPowerUp());
                }
        );
    }

    private void reset() {
        seed = System.nanoTime();
        random.setSeed(seed);
        this.builder.reset();
    }

    public void setBuilder(ILevelBuilder builder) {
        this.builder = builder;
        this.builder.reset();
    }
}
