package balance;

import balance.Balance;

import java.util.UUID;

public class CustomerBalance extends Balance {
    public CustomerBalance(UUID customerID, Double balance) {
        super(customerID, balance);
    }

    public Double addBalance(Double additionalBalance) {
        this.setBalance(this.getBalance() + additionalBalance);
        return this.getBalance();
    }


}
