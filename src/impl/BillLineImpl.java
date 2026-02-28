package impl;

import contracts.BillLine;

import java.math.BigDecimal;

public class BillLineImpl implements BillLine {
    private String name;
    private BigDecimal unitPrice;
    private BigDecimal finalTotal;
    private int quantity;
    private boolean hasDiscount;

    public BillLineImpl(String name, BigDecimal unitPrice, BigDecimal finalTotal, int quantity, boolean hasDiscount) {
        this.name = name;
        this.unitPrice = unitPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.finalTotal = finalTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.quantity = quantity;
        this.hasDiscount = hasDiscount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean isDiscountApplied() {
        return hasDiscount;
    }

    @Override
    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    @Override
    public String toString() {
        return getName() + ";" +
                getQuantity() + ";" +
                getUnitPrice().toPlainString() + ";" +
                (isDiscountApplied() ? "1" : "0") + ";" +
                getFinalTotal().toPlainString();
    }
}
