package chap8.strategyPattern;

// VIP折扣
class VIPDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // 9折
        return price * 0.9;
    }
}
