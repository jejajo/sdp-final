package Observer;

public interface TrainSubject {
    void registerObserver(TrainObserver observer);
    void removeObserver(TrainObserver observer);
    void notifyObservers();
}

