package designPattern.observer.withObserver.observer;

/**
 * define TODO
 *
 * @author yuqili
 * Date 12/09/18  11:28
 * @version 1.0
 **/
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
