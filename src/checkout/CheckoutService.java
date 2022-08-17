package checkout;

import cord.Customer;

public interface CheckoutService {
    boolean checkout(Customer customer, Double totalAmount);
}
