package admi.api;

/**
 * Created by Admin on 7/4/2016.
 */
public class Contacts {
    private String name;
    private String id;
    private String email;
    private String address;
    private String gender;
    private String mobile;
    private String home;
    private String office;

    public Contacts(String name, String id, String email, String address, String gender, String mobile, String home, String office) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.mobile = mobile;
        this.home = home;
        this.office = office;
    }

    public Contacts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
