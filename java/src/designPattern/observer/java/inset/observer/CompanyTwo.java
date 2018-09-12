package designPattern.observer.java.inset.observer;


import designPattern.observer.java.inset.observer.WeatherData.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * define
 * A company is an observer, it depends on a subject( the weather station).
 *
 * @author yuqili
 * Date 12/09/18  11:30
 * @version 1.0
 **/
public class CompanyTwo implements Observer {

        private float mTemperature;
        private float mPressure;
        private float mHumidity;

    @Override
    public void update(Observable arg0, Object arg1) {
        this.mTemperature = ((Data) arg1).mTemperature;
        this.mPressure = ((Data) arg1).mPressure;
        this.mHumidity = ((Data) arg1).mHumidity;
        display();
    }

    private void display(){
        System.out.println(mTemperature + " " + mPressure + " "+mHumidity);
    }
}
