package impl;

import contracts.ProductLine;
import validators.ProductLineValidator;

import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine {
    private String name;
    private int quantity;
    BigDecimal unitPrice;

    public ProductLineImpl(String name, int quantity, BigDecimal unitPrice) {
//        ProductLineValidator.validateProductLine(name, quantity, unitPrice);
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
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
}
