package ua.vasylkov.phonebook.model;

public class Contact extends BaseEntity{
    private String lastName;
    private String firstName;
    private String middleName;
    private String mobilePhone;
    //not necessary
    private String homePhone;
    private String address;
    private String email;

    public Contact(){}

    public Contact(String lastName, String firstName, String middleName, String mobilePhone, String homePhone, String address, String email) {
        this(null, lastName, firstName, middleName, mobilePhone, homePhone, address, email);
    }

    public Contact(Integer id, String lastName, String firstName, String middleName, String mobilePhone, String homePhone, String address, String email) {
        super(id);
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public boolean isNew() {
        return id == null;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setMobilePhone(String mobilePhone) {
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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}