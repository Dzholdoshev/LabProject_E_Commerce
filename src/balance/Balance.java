package balance;

import java.util.UUID;

public abstract class Balance {
    private Integer customerId;
    private Double balance;

    public Balance(Integer customerId, Double balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Double getBalance() {
        return balance;
    }

    public abstract Double addBalance(Double additionalBalance);

    @Override
    public String toString() {
        return "Balance{" +
                "customerID=" + customerId +
                ", balance=" + balance +
                '}';
    }


}
