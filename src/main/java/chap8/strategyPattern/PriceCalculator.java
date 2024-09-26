package chap8.strategyPattern;

// 上下文类：使用不同的折扣策略
public class PriceCalculator {
    private DiscountStrategy strategy;

    // 构造函数
    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
    // 计算价格：子类区别实现
    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
