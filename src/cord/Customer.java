package cord;

import java.util.List;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String userName;
    private String email;
    private List<Address> address;

    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public Customer(UUID id, String userName, String email, List<Address> address) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
    }

    public UUID getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Address> getAddress() {
        return this.address;
    }

    public String toString() {
        return "cord.Customer{id=" + this.id + ", userName='" + this.userName + "', email='" + this.email + "', address=" + this.address + "}";
    }
}
