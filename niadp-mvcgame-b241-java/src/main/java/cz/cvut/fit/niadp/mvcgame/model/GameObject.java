package cz.cvut.fit.niadp.mvcgame.model;

public abstract class GameObject {
    protected Position position;
    
    public void move(Vector vector){
        position.add(vector);
    }

    public Position getPosition(){
        return position;
    }
}
