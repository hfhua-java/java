package West2FriedChickenRestaurant;

//果汁或啤酒售完
public class IngredientSortOutException extends RuntimeException{
    //String参数
    public IngredientSortOutException(String message) {
        super(message);
    }
}
