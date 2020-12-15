package West2FriedChickenRestaurant;

import java.time.LocalDate;

public class Beer extends Drinks {
    float alcohol_by_volume;


    public Beer(String name, double cost, LocalDate mfd, long shelfLife, float alcohol_by_volume) {
        super(name, cost, mfd, shelfLife);
        super.shelfLife=30;
        this.alcohol_by_volume = alcohol_by_volume;
    }


    @Override
    public String toString() {
        return "West2FriedChickenRestaurant.West2FriedChickenRestaurant.Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", mfd=" + mfd +
                ", shelfLife=" + shelfLife +
                '}';
    }
}
