package impl;

import contracts.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BIllCalculatorImpl implements BillCalculator {
    DiscountPolicy discountPolicy = new DiscountPolicyImpl();

        @Override
        public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
            ArrayList<BillLine> billLines = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

            for (ProductLine product : products) {
                String name = product.getName();
                int quantity = product.getQuantity();
                BigDecimal unitPrice = product.getUnitPrice();

                BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
                subtotal = SummaryWithDiscount.sumWithDiscount(discountPolicy, subtotal, quantity);


                BigDecimal discount = discountPolicy.discountFor(subtotal, quantity);
                boolean isDiscount = discount.compareTo(BigDecimal.ZERO) > 0;

                total = total.add(subtotal.subtract(discount));

                BillLineImpl toBillLine = new BillLineImpl(name, unitPrice, subtotal, quantity, isDiscount);
                billLines.add(toBillLine);
            }

            return new BillResultImpl<>(billLines, total);
        }

}
