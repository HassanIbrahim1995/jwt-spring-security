package jwt.controller;

public class CreateUserDto {
    private String username;
    private String email;
    private String password;
    private String roleName;

    public CreateUserDto() {
    }

    public CreateUserDto(String username, String email, String password, String roleName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
    }

    // Add getters and setters for the fields

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
