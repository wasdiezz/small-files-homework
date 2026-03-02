package impl;

import contracts.DiscountPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SummaryWithDiscount {
    public static BigDecimal sumWithDiscount(DiscountPolicy discountPolicy, BigDecimal subtotal, int quantity) {
        BigDecimal discount = discountPolicy.discountFor(subtotal, quantity);
        return subtotal.subtract(discount);
    }
}