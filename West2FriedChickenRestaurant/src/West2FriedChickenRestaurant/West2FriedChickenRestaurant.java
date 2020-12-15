package West2FriedChickenRestaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//要准备很多考试，可能时间有点紧张，写的可能挺粗糙的，不过除了多线程其他的基础应该都算有所了解，我很努力的，求通过。

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {

    private double balance;

    //我觉得套餐使用ArrayList,方便检索有哪些套餐，就是把套餐当成菜单一样的东西吧。
    static List<SetMeal> setMealList= new ArrayList<>();


    //果汁和啤酒使用LinkedList，顾客随机买走物品，该链表的优点是随意增删，用它应该好一点吧。
    static List<Juice> juiceList = new LinkedList<>();
    static List<Beer> beerList = new LinkedList<>();


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    //静态代码块初始化，暂时只有两种套餐。
static {
    //这批啤酒的生产日期
    LocalDate mfd1 = LocalDate.of(2020,12,12);
    //这批果汁的生产日期
    LocalDate mfd2= LocalDate.of(2020,12,30);


    //一般套餐里的东西是固定的，但是饮料的生产日期应该是改变的,但是我好像只能这么写。
    setMealList.add(new SetMeal("套餐1",42,"炸鸡1",new Beer("青岛",10,mfd1,30,7)));
    setMealList.add(new SetMeal("套餐2",32,"炸鸡2",new Juice("橙汁",12,mfd2,2)));
}


    /*
    * 先遍历，移除过期的啤酒，
    * 再判断是否存在，不存在抛出异常。
    */
    private void use(Beer beer) {
        for (Beer beer0 : beerList) {
            if (beer0.isExp(beer0.mfd, 30)) {
                beerList.remove(beer0);
            }
            if (!beerList.contains(beer)) {
                throw new IngredientSortOutException(beer.name+"已售完");
            }
        }
    }


    /*
    * 方法重载
    */
    private void use(Juice juice) {
        for (Juice juice0 : juiceList) {
            if (juice0.isExp(juice0.mfd, 2)) {
                juiceList.remove(juice0);
            }
            if (!juiceList.contains(juice)) {
                System.out.print(juice.name);
                throw new IngredientSortOutException(juice.name+"已售完");
            }
        }
    }


    //移除过期的前提下售卖.
    @Override
    public void forSale(SetMeal setMeal) {
        for (SetMeal setMeal0 : setMealList) {
            if (setMeal0.drinks instanceof Juice) {
                if (juiceList.contains(setMeal0.drinks)) {
                    juiceList.remove(setMeal0.drinks);
                } else {
                    throw new IngredientSortOutException("该套餐的"+setMeal0.drinks.name+"已售完");
                }
            }
            if (setMeal0.drinks instanceof Beer) {
                if (beerList.contains(setMeal0.drinks)) {
                    beerList.remove(setMeal0.drinks);
                } else {
                    throw new IngredientSortOutException("该套餐的"+setMeal0.drinks.name+"已售完");
                }
            }
        }
    }


    //批量进货，
    @Override
    public void purchaseBatch(Drinks drinks) {
        if (balance>=drinks.cost){
            if (drinks instanceof Juice){
                Juice juiceNew = (Juice)drinks;
                juiceList.add(juiceNew);
            }
            if (drinks instanceof Beer){
                Beer beerNew = (Beer)drinks;
                beerList.add(beerNew);
            }
        }else{
            throw new OverdraftBalanceException("余额不足:进货差"+(drinks.cost-balance)+"元");
        }
    }
}