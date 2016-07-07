package admi.api;

/**
 * Created by Admin on 7/7/2016.
 */
public class Bin {
    private String name;
    private String email;
    private String address;
    private String phone;

    public Bin() {

    }

    public Bin(String email, String name, String address, String phone) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
