package cz.cvut.fit.niadp.mvcgame.builder;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.model.Position;
import cz.cvut.fit.niadp.mvcgame.state.HugeMissilePoweUp;
import cz.cvut.fit.niadp.mvcgame.state.SpeedPowerUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Director {
    private  ILevelBuilder builder;
    private List<Position> allPosibleEnemiesPosition =new ArrayList<>(MvcGameConfig.ALL_POSSIBLE_ENEMIES_POSITION);
    private List<Position> allPosiblePowerUpsPosition =new ArrayList<>(MvcGameConfig.ALL_POSSIBLE_POWER_UPS_POSITIONS);

    long seed = System.nanoTime();
    Random random = new Random(seed);

    public Director(ILevelBuilder builder) {
        this.builder = builder;
        this.builder.reset();
    }

    public void CreatePeaceFullLevel(){
        //builder.setWalls()
       // builder.setSceneWheatherTime();
    }
    public void CreateRandomLevel(){

        Collections.shuffle(allPosibleEnemiesPosition);
        Collections.shuffle(allPosiblePowerUpsPosition);
        int pigCount =  random.nextInt(allPosibleEnemiesPosition.size());
        int powerUpsCount =  random.nextInt(allPosiblePowerUpsPosition.size());

        allPosibleEnemiesPosition.stream().limit(pigCount).forEach(pos -> {builder.placeEnemy(pos);});
        allPosibleEnemiesPosition.stream().limit(powerUpsCount).forEach(pos -> {builder.placePowerUp(pos,new SpeedPowerUp());});

       // builder.setSceneWheatherTime();
    }
    public void CreateEasyLevel(){
        MvcGameConfig.EASY_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {builder.placeEnemy(position);}
        );
        MvcGameConfig.EASY_LEVEL_POWER_UPS__POSITIONS.forEach(
                position -> {builder.placePowerUp(position,new SpeedPowerUp());}
        );
    }
    public void CreateMediumLevel(){
        MvcGameConfig.MEDIUM_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {builder.placeEnemy(position);}
        );
        MvcGameConfig.MEDIUM_LEVEL_POWER_UPS__POSITIONS.forEach(
                position -> {builder.placePowerUp(position,new HugeMissilePoweUp());}
        );
    }
    public void CreateHardLevel(){
        MvcGameConfig.HARD_LEVEL_ENEMY_POSITIONS.forEach(
                position -> {builder.placeEnemy(position);}
        );
        MvcGameConfig.HARD_LEVEL_POWER_UPS__POSITIONS.forEach(
                position -> {builder.placePowerUp(position,new SpeedPowerUp());}
        );
    }

    public void setBuilder(ILevelBuilder builder) {
        this.builder = builder;
        this.builder.reset();
    }
}
