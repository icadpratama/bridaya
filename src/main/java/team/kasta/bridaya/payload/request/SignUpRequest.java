package team.kasta.bridaya.payload.request;

import team.kasta.bridaya.util.RoleName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank(message = "first name can't be blank")
    @Size(min = 4, max = 20, message = "first name min length is 4 and max length is 20")
    private String phoneNumber;

    @NotBlank(message = "username can't be blank")
    @Size(min = 3, max = 15, message = "username min length is 3 and max length is 15")
    private String username;

    @NotBlank(message = "email can't be blank")
    @Size(min = 6, max = 100, message = "email min length is 6 and max length is 100")
    @Email(message = "email is not valid")
    private String email;

    @NotBlank(message = "password can't be blank")
    @Size(min = 6, max = 20, message = "password min length is 6 and max length is 20")
    private String password;

    private RoleName role;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
