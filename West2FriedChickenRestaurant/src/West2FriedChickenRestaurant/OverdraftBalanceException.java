package West2FriedChickenRestaurant;

//进货费用超出拥有余额
public class OverdraftBalanceException extends RuntimeException{
    //String参数
    public OverdraftBalanceException(String message) {
        super(message);
    }
}
