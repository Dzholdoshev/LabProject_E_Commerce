import java.util.UUID;

public class Test {
    public static void main(String[] args) {
       Customer customer = new Customer(UUID.randomUUID(),"mark","marklen@gmail.com");
       StaticConstants.CUSTOMER_LIST.add(customer);
        System.out.println(StaticConstants.CUSTOMER_LIST);

    }
}
