package discount;

import java.util.UUID;

public class AmountBasedDiscount extends Discount {

private Double discountAmount;


    public AmountBasedDiscount(Integer id, String name, Double thresholdAmount, Double discountAmount) {
        super(id, name, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public Double calculateCartAmountAfterDiscountApplied(Double amount) {
        return amount - discountAmount;
    }



}
