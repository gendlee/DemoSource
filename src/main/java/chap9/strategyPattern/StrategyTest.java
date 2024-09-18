package chap9.strategyPattern;

public class StrategyTest {
    public static void main(String[] args) {
        // 普通用户
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        System.out.println("普通客户的价格: " + calculator.calculatePrice(100)); // 输出：100.0

        // VIP用户
        calculator = new PriceCalculator(new VIPDiscount());
        System.out.println("VIP客户的价格: " + calculator.calculatePrice(100)); // 输出：90.0
    }
}
