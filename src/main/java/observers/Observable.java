package observers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 12/4/2016.
 */
public class Observable {
    protected Object state;
    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * Notify all observers that observable has changed.
     */
    public void notifyAllObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Add an observer to the observable.
     * @param observer the observer to add.
     */
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    /**
     * Getter of state.
     * @return the state.
     */
    public Object getState(){
        return this.state;
    }
}
