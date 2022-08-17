import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import category.Category;
import discount.Discount;


import java.util.HashMap;
import java.util.Map;
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

        Cart cart = new Cart(customer);


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
                            System.out.println("Product Name:" + product.getName() + "Product Category Name:" + product.getCategoryName() + " Stock " + product.getRemainingStock());
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
                    System.out.println("Type 1 for Customer Balance " + customerBalance.getBalance());
                    System.out.println("Type 2 for Gift Card Balance " + giftCardBalance.getBalance());
                    int balanceSelection = scanner.nextInt();

                    System.out.println("How much you would like to add?");
                    double additionalAmount = scanner.nextInt();


                    switch (balanceSelection) {
                        case 1:
                            customerBalance.addBalance(additionalAmount);
                            System.out.println("New Customer Balance: " + customerBalance.getBalance());
                            break;
                        case 2:
                            giftCardBalance.addBalance(additionalAmount);
                            System.out.println("New Gift Card Balance: " + giftCardBalance.getBalance());
                            break;
                    }
                    break;
                case 5:

                    Map<Product, Integer> map = new HashMap<>();
                    cart.setProductMap(map);

                    while (true) {


                        System.out.println("What product do you want to add to cart? ");
                        System.out.println("Please choose your product and type id:");
                        System.out.println("For exit product selection. type : EXIT");

                        for (Product product : StaticConstants.PRODUCT_LIST) {

                            try {
                                System.out.println("ID" + product.getId() +
                                        " Product name: " + product.getName() +
                                        " Price: " + product.getPrice() +
                                        "Stock: " + product.getRemainingStock() +
                                        "category name " + product.getCategoryId() +
                                        " Product delivery due " + product.getDeliveryDueDate());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }


                        }

                        String productId = scanner.next();

                        try {
                            Product product = findProductByID(productId);
                            if (!putItemCartIfStockAvailable(cart, product)) {
                                System.out.println("Stock is insufficient.Please try again");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Product doesn't exist. please try again");
                            ;
                            continue;
                        }

                        System.out.println("Do you want to add more product. Type Y for adding, N for exist");
                        String decision = scanner.next();
                        if (!decision.equals("Y")) {
                            break;
                        }

                    }

                    System.out.println("Seems there are discount options. Do you want to see and apply to your cart if it is applicable. For no discount type no");

                    for (Discount discount : StaticConstants.DISCOUNT_LIST) {
                        System.out.println("discount ID " + discount.getId() + " discount name " + discount.getName());
                    }

                    String discountId = scanner.next();

                    if (!discountId.equals("no")) {
                        try {
                            Discount discount = findDiscountById(discountId);
                            if (discount.decideDiscountIsApplicableToCart()) {
                                cart.setDiscountId(discount.getId());
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }

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

private static Discount findDiscountById(String discountId) throws Exception{
for(Discount discount: StaticConstants.DISCOUNT_LIST){
if(discount.getId().toString().equals(discountId)){
return discount;
}
}
    throw new Exception("Discount couldn't applied because couldn't found");
}


    private static boolean putItemCartIfStockAvailable(Cart cart, Product product) {
        System.out.println("Please provide product count:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount != null && product.getRemainingStock() > cartCount + count) {
            cart.getProductMap().put(product, cartCount + count);
            return true;
        } else if (product.getRemainingStock() >= count) {
            cart.getProductMap().put(product, count);
            return true;
        }
        return false;
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

    public static Product findProductByID(String productId) throws Exception {
        for (Product product : StaticConstants.PRODUCT_LIST) {
            if (product.getId().toString().equals(productId)) {
                return product;

            }
        }
        throw new Exception("product not found");
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
