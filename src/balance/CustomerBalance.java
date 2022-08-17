package balance;

import balance.Balance;

import java.util.UUID;

public class CustomerBalance extends Balance {
    public CustomerBalance(UUID customerId, Double balance) {
        super(customerId, balance);
    }

    public Double addBalance(Double additionalBalance) {
        this.setBalance(this.getBalance() + additionalBalance);
        return this.getBalance();
    }


}
