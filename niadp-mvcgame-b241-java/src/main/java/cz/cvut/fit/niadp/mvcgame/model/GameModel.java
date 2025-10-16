package cz.cvut.fit.niadp.mvcgame.model;

import java.util.HashSet;
import java.util.Set;

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.niadp.mvcgame.observer.IObservable;
import cz.cvut.fit.niadp.mvcgame.observer.IObserver;

public class GameModel implements IObservable{
    private final Cannon cannon;
    private final Set<IObserver> observers;

    public GameModel(){
        observers = new HashSet<IObserver>();
        cannon = new Cannon(new Position(MvcGameConfig.CANNON_POS_X, MvcGameConfig.CANNON_POS_Y));
    }
    
    public void update() {
        // remove killed enemies
        // move missiles
        // check for collisions
    }

    public Position getCannonPosition(){
        return cannon.getPosition();
    }

    public void moveCannonUp(){
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown(){
        cannon.moveDown();
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
       observers.forEach(IObserver::update);
    }

}
