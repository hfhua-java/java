package West2FriedChickenRestaurant;

import java.time.LocalDate;

//饮料类
public abstract class Drinks {

    protected String name;

    protected double cost;

    protected LocalDate mfd;

    protected long shelfLife;


    //全参构造
    public Drinks(String name, double cost, LocalDate mfd, long shelfLife) {

        this.name = name;

        this.cost = cost;

        this.mfd = mfd;

        this.shelfLife = shelfLife;
    }

    //判断是否过期,子类中继承了该方法
    public boolean isExp(LocalDate mfd, long shelfLife) {
        LocalDate now = LocalDate.now();
        if (now.toEpochDay() - mfd.toEpochDay() < shelfLife) {
            System.out.println("该饮料已过期");
            return true;
        }
        return false;
    }

    //抽象的toString方法
    @Override
    public abstract String toString();

}
