package designPattern.decoration.product;

import designPattern.decoration.product.base.Coffee;

/**
 * define TODO
 *
 * @author yuqili
 * Date 13/09/18  11:06
 * @version 1.0
 **/
public class Espresso extends Coffee {
    public Espresso(){
        setDescription("Espresso");
        setPrice(4.0f);
    }
}
