package designPattern.observer.nonObserver;

/**
 * define TODO
 *
 * @author yuqili
 * Date 12/09/18  11:12
 * @version 1.0
 **/
public class CompanyOneApi {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    public void update(float mTemperature, float mPressure, float mHumidity){
        this.mTemperature = mTemperature;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display(){
        System.out.println(mTemperature + " " + mPressure + " "+mHumidity);
    }
}
