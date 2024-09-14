package chap9.designPattern.strategyPattern;

// 策略接口
public interface DiscountStrategy {
    // 计算折扣
    double applyDiscount(double price);
}
