package cz.cvut.fit.niadp.mvcgame.model;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;

public class Cannon extends GameObject{
    //int power
    //float angle

    public Cannon(Position position){
        this.position = position;
    }

    public void moveUp(){
        move(new Vector(0, -1 * MvcGameConfig.MOVE_STEP));
    }

    public void moveDown(){
        
        move(new Vector(0, MvcGameConfig.MOVE_STEP));
    }
}
