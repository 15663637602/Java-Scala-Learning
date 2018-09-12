package designPattern.observer.withObserver.companies;

import designPattern.observer.withObserver.observer.Observer;
import designPattern.observer.withObserver.observer.Subject;

import java.util.ArrayList;

/**
 * define
 * 当存在观察者和被观察者的关系 且 时多对一的关系时。
 * 可以使用观察者模式
 * 使用观察者模式可以达到  松耦合 高内聚
 *
 * @author yuqili
 * Date 12/09/18  11:12
 * @version 1.0
 **/
public class WeatherData implements Subject {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;
    private ArrayList<Observer> mObservers;

    public WeatherData(){
        mObservers = new ArrayList<>();
    }


    public float getmTemperature() {
        return mTemperature;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }


    public void setData(float mHumidity, float mPressure, float mTemperature){
        this.mHumidity = mHumidity;
        this.mPressure = mPressure;
        this.mTemperature = mTemperature;
        dataChange();
    }

    private void dataChange() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        mObservers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(mObservers.contains(o)){
            mObservers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer mObserver : mObservers) {
            mObserver.update(getmTemperature(), getmPressure(), getmHumidity());
        }
    }
}
