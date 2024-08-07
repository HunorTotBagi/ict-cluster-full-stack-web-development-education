package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "First name must be provided.")
    @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
    private String firstName;

    @NotNull(message = "Last name must be provided.")
    @Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.")
    private String lastName;

    @NotNull(message = "Username must be provided.")
    @Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.")
    private String username;

    @NotNull(message = "Password must be provided.")
    @Size(min = 5, max = 10, message = "Password must be between {min} and {max} characters long.")
    private String password;

    @NotNull(message = "Email must be provided.")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid.")
    private String email;

    @NotNull(message = "Age must be provided.")
    @Min(value = 18, message = "Age must be 18 or higher!")
    private Integer age;

    public UserEntity() {
        super();
    }

    public UserEntity(Integer id, String firstName, String lastName, String username, String password, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    // Getters and setters...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}