package chap9.strategyPattern;

// 没有折扣
class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // 原价
        return price;
    }
}
