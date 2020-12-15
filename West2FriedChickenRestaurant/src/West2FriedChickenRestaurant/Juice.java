package West2FriedChickenRestaurant;

import java.time.LocalDate;

public class Juice extends Drinks {


    public Juice(String name, double cost, LocalDate mfd, long shelfLife) {
        super(name, cost, mfd, shelfLife);
        super.shelfLife=2;
    }


    @Override
    public String toString() {
        return "West2FriedChickenRestaurant.West2FriedChickenRestaurant.Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", mfd=" + mfd +
                ", shelfLife=" + shelfLife +
                '}';
    }
}
