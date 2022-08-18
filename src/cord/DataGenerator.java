package cord;

import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import category.Electronic;
import category.Furniture;
import category.SkinCare;
import discount.AmountBasedDiscount;
import discount.Discount;
import discount.RateBasedDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DataGenerator {


    public static void createCustomer() {
        Address address1Customer1 = new Address("7925", "Jones Branch Dr", "Suite 3300", "22102", "VA");
        Address address2Customer1 = new Address("825", "George Parkway", "S 3800", "22102", "VA");
        new Address("5924", "JLee Hwy", "Suite 30", "22102", "VA");
        List<Address> customer1AddressList = new ArrayList();
        customer1AddressList.add(address1Customer1);
        customer1AddressList.add(address2Customer1);
        Customer customer1 = new Customer((int) (Math.random()*1000000), "ozzy", "ozzy@cydeo.com", customer1AddressList);
        Customer customer2 = new Customer((int) (Math.random()*1000000), "mike", "mike@gmail.com");
        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);
    }

    public static void createCategory() {
        Category category1 = new Electronic((int) (Math.random()*1000000), "Electronic");
        Category category2 = new Furniture((int) (Math.random()*1000000), "Furniture");
        Category category3 = new SkinCare((int) (Math.random()*1000000), "SkinCare");
        Category category4 = new SkinCare((int) (Math.random()*1000000), "Food");
        StaticConstants.CATEGORY_LIST.add(category1);
        StaticConstants.CATEGORY_LIST.add(category2);
        StaticConstants.CATEGORY_LIST.add(category3);
        StaticConstants.CATEGORY_LIST.add(category4);
    }

    public static void createProduct() {
        Product product1 = new Product((int) (Math.random()*1000000), "PS5", 230.72, 7, 7, ((Category) StaticConstants.CATEGORY_LIST.get(0)).getId());
        Product product2 = new Product((int) (Math.random()*1000000), "XBOX", 120.34, 15, 15, ((Category) StaticConstants.CATEGORY_LIST.get(0)).getId());
        Product product3 = new Product((int) (Math.random()*1000000), "Chair", 30.87, 85, 85, ((Category) StaticConstants.CATEGORY_LIST.get(1)).getId());
        Product product4 = new Product((int) (Math.random()*1000000), "Milk", 3.87, 185, 185, (int) (Math.random()*1000000));

        StaticConstants.PRODUCT_LIST.add(product1);
        StaticConstants.PRODUCT_LIST.add(product2);
        StaticConstants.PRODUCT_LIST.add(product3);
        StaticConstants.PRODUCT_LIST.add(product4);

    }

    public static void createBalance() {
        Balance customerBalance = new CustomerBalance(((Customer) StaticConstants.CUSTOMER_LIST.get(0)).getId(), 1000.22);
        Balance giftCardBalance = new GiftCardBalance(((Customer) StaticConstants.CUSTOMER_LIST.get(0)).getId(), 500.0);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);
    }

    public static void createDiscount() {
        Discount amountBasedDiscount = new AmountBasedDiscount((int) (Math.random()*1000000), "Buy 250 Free 50", 250.0, 50.0);
        Discount rateBasedDiscount = new RateBasedDiscount((int) (Math.random()*1000000), "Buy 500 Free %15", 500.0, 15.0);
        StaticConstants.DISCOUNT_LIST.add(amountBasedDiscount);
        StaticConstants.DISCOUNT_LIST.add(rateBasedDiscount);
    }


}