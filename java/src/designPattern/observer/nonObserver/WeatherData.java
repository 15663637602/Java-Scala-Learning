package designPattern.observer.nonObserver;

/**
 * define
 * 问题是 当其他新公司要接入气象站获取数据时，
 * 无法动态的添加第三方。
 *
 * @author yuqili
 * Date 12/09/18  11:12
 * @version 1.0
 **/
public class WeatherData {
    private float mTemperature;
    private float mPressure;
    private float mHumidity;

    private CompanyOneApi companyOneApi;

    public WeatherData(CompanyOneApi companyOneApi) {
        this.companyOneApi = companyOneApi;
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

    public void dataChange(){
        companyOneApi.update(getmTemperature(),getmPressure(), getmHumidity());
    }

    public void setData(float mHumidity, float mPressure, float mTemperature){
        this.mHumidity = mHumidity;
        this.mPressure = mPressure;
        this.mTemperature = mTemperature;
        dataChange();
    }
}
