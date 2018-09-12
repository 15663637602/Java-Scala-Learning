package designPattern.observer.withObserver.companies;

import designPattern.observer.withObserver.observer.Observer;

/**
 * define
 * A company is an observer, it depends on a subject( the weather station).
 *
 * @author yuqili
 * Date 12/09/18  11:30
 * @version 1.0
 **/
public class CompanyTwo implements Observer{

        private float mTemperature;
        private float mPressure;
        private float mHumidity;

    @Override
    public void update(float mTemperature, float mPressure, float mHumidity) {
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display(){
        System.out.println(mTemperature + " " + mPressure + " "+mHumidity);
    }
}
