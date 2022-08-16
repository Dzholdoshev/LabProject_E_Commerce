import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import discount.Discount;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        DataGenerator.createCustomer();
        System.out.println(StaticConstants.CUSTOMER_LIST);
        DataGenerator.createCategory();
        System.out.println(StaticConstants.CATEGORY_LIST);
        DataGenerator.createProduct();
        System.out.println(StaticConstants.PRODUCT_LIST);
        DataGenerator.createBalance();
        System.out.println(StaticConstants.CUSTOMER_BALANCE_LIST);
        DataGenerator.createDiscount();

        System.out.println(StaticConstants.CUSTOMER_BALANCE_LIST.get(0).getBalance());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Customer:");

        for (int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); ++i) {
            System.out.println("Type " + i + " for customer:" + (StaticConstants.CUSTOMER_LIST.get(i)).getUserName());
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());




        while (true) {

            System.out.println("What would you like to do? Just type ID for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }
            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0:
                    for (Category category : StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category code: " + category.generateCategoryCode() + "category name: " + category.getName());
                    }

                    break;
                case 1://list products //product name // product category
                    try {
                        for (Product product : StaticConstants.PRODUCT_LIST) {
                            System.out.println("Product Name:" + product.getName() + "Product Category Name:" + product.getCategoryName());
                        }
                    } catch (Exception e) {
                        System.out.println("Product could not printed because category not found for product name:" + e.getMessage().split(",")[1]);
                    }
                    break;
                case 2:

                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("Discount name:" + discount.getName() + "  Threshold Amount: " + discount.getThresholdAmount());
                    }
                    break;
                case 3:

                    CustomerBalance cBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance gBalance = findGiftCardBalance(customer.getId());
                    double totalBalance = cBalance.getBalance() + gBalance.getBalance();
                    System.out.println("Total Balance: " + totalBalance);
                    System.out.println("Customer Balance: " + cBalance.getBalance());
                    System.out.println("Gift Card Balance: " + gBalance.getBalance());

                    break;
                case 4:
                    CustomerBalance customerBalance = findCustomerBalance(customer.getId());
                    GiftCardBalance giftCardBalance = findGiftCardBalance(customer.getId());

                    System.out.println("Which account would like to add? ");
                    System.out.println("Type 1 for Customer Balance "+ customerBalance.getBalance());
                    System.out.println("Type 2 for Gift Card Balance "+ giftCardBalance.getBalance());
                    int balanceSelection = scanner.nextInt();

                    System.out.println("How much you would like to add?");
                    double additionalAmount = scanner.nextInt();


                    switch (balanceSelection){
                        case 1:
                            customerBalance.addBalance(additionalAmount);
                            System.out.println("New Customer Balance: " + customerBalance.getBalance() );
                            break;
                        case 2:
                            giftCardBalance.addBalance(additionalAmount);
                            System.out.println("New Gift Card Balance: " + giftCardBalance.getBalance() );
                            break;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;


            }

        }


    }

    public static CustomerBalance findCustomerBalance(UUID customerID) {
        for (Balance customerBalance : StaticConstants.CUSTOMER_BALANCE_LIST) {
            if (customerBalance.getCustomerID().toString().equals(customerID.toString())) {
                return (CustomerBalance) customerBalance;
            }


        }
        CustomerBalance customerBalance = new CustomerBalance(customerID, 0d);
        StaticConstants.CUSTOMER_BALANCE_LIST.add(customerBalance);

        return customerBalance;

    }

    public static GiftCardBalance findGiftCardBalance(UUID customerID) {
        for (Balance giftCardBalance : StaticConstants.GIFT_CARD_BALANCE_LIST) {
            if (giftCardBalance.getCustomerID().toString().equals(customerID.toString())) {
                return (GiftCardBalance) giftCardBalance;
            }
        }
        GiftCardBalance giftCardBalance = new GiftCardBalance(customerID, 0d);
        StaticConstants.GIFT_CARD_BALANCE_LIST.add(giftCardBalance);

        return giftCardBalance;

    }

    private static String[] prepareMenuOptions() {

        return new String[]{"List Categories", "List Products", "List Discount", "See Balance", "Add Balance",
                "Place an order", "See Cart", "See Order Details", "See your address", "Close App"};
    }

    ;


}
