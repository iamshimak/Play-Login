package controllers;

/**
 * Created by ShimaK on 03-Mar-17.
 */
public class User {
    private String userName;
    private String fName;
    private String lName;
    private String email;
    private String password;

    public User(String userName, String fName, String lName, String email, String password) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        if(fName == null) {
            return null;
        }
        return "FName " + fName + " LName " + lName;
    }
}
