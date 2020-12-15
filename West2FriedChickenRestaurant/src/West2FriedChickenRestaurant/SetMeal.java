package West2FriedChickenRestaurant;

public class SetMeal {
    String setMeal;

    double price;

    String friedChicken;

    Drinks drinks;

    //到时候给套餐集合中增添果汁或啤酒就是多态的运用。
    public SetMeal(String setMeal, double price, String friedChicken,Drinks drinks) {
        this.setMeal = setMeal;
        this.price = price;
        this.friedChicken = friedChicken;
        this.drinks = drinks;
    }


    @Override
    public String toString() {
        return "SetMeal{" +
                "setMeal='" + setMeal + '\'' +
                ", price=" + price +
                ", friedChicken='" + friedChicken + '\'' +
                ", drinks=" + drinks +
                '}';
    }
}
