package Decorator;

public class Coffee implements ICoffee{
    int COFFEE_COST =10;
    public int cost(){
        System.out.println("+"+ COFFEE_COST +" за кофе");
        return COFFEE_COST;
    }
}
