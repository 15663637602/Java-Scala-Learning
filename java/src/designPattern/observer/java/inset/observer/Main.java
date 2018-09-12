package designPattern.observer.java.inset.observer;

/**
 * define TODO
 *
 * @author yuqili
 * Date 12/09/18  11:18
 * @version 1.0
 **/
public class Main {
    public static void main(String[] args){
        CompanyOne one = new CompanyOne();
        CompanyTwo two = new CompanyTwo();
        WeatherData data = new WeatherData();

        data.addObserver(one);
        data.addObserver(two);
        data.setData(1,2,3);

    }
}
