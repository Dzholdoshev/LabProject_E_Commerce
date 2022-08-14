import category.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class    Main {
    public static void main(String[] args) {

        DataGenerator.createCustomer();
        System.out.println(StaticConstants.CUSTOMER_LIST);
        DataGenerator.createCategory();
        System.out.println(StaticConstants.CATEGORY_LIST);
        DataGenerator.createProduct();
        System.out.println(StaticConstants.PRODUCT_LIST);
        DataGenerator.createBalance();
        System.out.println(StaticConstants.BALANCE_LIST);
        DataGenerator.createDiscount();



        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Customer:");

        for(int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); ++i) {
            System.out.println("Type " + i + " for customer:" + (StaticConstants.CUSTOMER_LIST.get(i)).getUserName());
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());

        while (true){

            System.out.println("What would you like to do? Just type ID for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }
            int menuSelection = scanner.nextInt();

            switch (menuSelection){
                case 0:
                    for (Category category: StaticConstants.CATEGORY_LIST) {
                        System.out.println("Category code: " + category.generateCategoryCode()+ "category name: "+ category.getName());
                    }

                    break;
                case 1://list products //product name // product category

                    for (Product product:StaticConstants.PRODUCT_LIST) {
                        System.out.println("Product name: "+ product.getName()+ " Product Category Name: "+ product.getCategoryName());

                    }
                    break;
                case 2:
                    System.out.println(StaticConstants.DISCOUNT_LIST);
                    break;
                case 3:

                    break;
                case 4:
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

    private static String[] prepareMenuOptions (){

        return new String[]{"List Categories", "List Products", "List Discount", "See Balance", "Add Balance", "Add Balance",
        "Place an order", "See Cart", "See Order Details", "See your address", "Close App"};
    };


}
