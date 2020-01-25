package team.kasta.bridaya.payload.request;

import javax.validation.constraints.NotBlank;

public class BusinessRequest {

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Address can't be blank")
    private String address;

    @NotBlank(message = "Contact number can't be blank")
    private String contactNumber;

    @NotBlank(message = "Email can't be blank")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
