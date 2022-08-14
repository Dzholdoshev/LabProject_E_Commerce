import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createCustomer();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Customer:");

        for(int i = 0; i < StaticConstants.CUSTOMER_LIST.size(); ++i) {
            System.out.println("Type " + i + " for customer:" + (StaticConstants.CUSTOMER_LIST.get(i)).getUserName());
        }

        Customer customer = StaticConstants.CUSTOMER_LIST.get(scanner.nextInt());
    }
}
