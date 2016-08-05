package model;

public class Contact {
    private String lastName;
    private String firstName;
    private String middleName;
    private String mobilePhone;
    //not necessary
    private String homePhone;
    private String address;
    private String email;

    public Contact(String lastName, String firstName, String middleName, String mobilePhone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.mobilePhone = mobilePhone;
        this.homePhone = null;
        this.address = null;
        this.email = null;
    }

    public Contact(String lastName, String firstName, String middleName, String mobilePhone, String homePhone, String address, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.address = address;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
}
