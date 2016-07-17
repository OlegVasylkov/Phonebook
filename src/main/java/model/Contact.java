package model;

/**
 * Created by filipenko_n on 14.07.2016.
 */
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
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
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
