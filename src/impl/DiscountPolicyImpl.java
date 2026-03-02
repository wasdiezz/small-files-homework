package impl;

import contracts.DiscountPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountPolicyImpl implements DiscountPolicy {
    private static final BigDecimal DISCOUNT = new BigDecimal("0.10");

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        if (quantity >= 3) return subtotal.multiply(DISCOUNT).setScale(2, RoundingMode.HALF_UP);
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }
}
