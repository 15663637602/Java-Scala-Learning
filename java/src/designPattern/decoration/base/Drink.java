package designPattern.decoration.base;

/**
 * define
 * 在这个抽象类的基础上， 扩展出两个分支（ 1： 咖啡的单品 2： 调料） 他们之间可以存在中间层
 *
 * @author yuqili
 * Date 13/09/18  10:58
 * @version 1.0
 **/
public abstract class Drink {
    public String description = "";
    private float price = 0f;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
