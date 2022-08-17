package cord;

public class Address {
    private String streetNumber;
    private String streetName;
    private String additionalAddressLine;
    private String zipCode;
    private String state;

    public Address(String streetNumber, String streetName, String additionalAddressLine, String zipCode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddressLine = additionalAddressLine;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getAdditionalAddressLine() {
        return this.additionalAddressLine;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getState() {
        return this.state;
    }
}
