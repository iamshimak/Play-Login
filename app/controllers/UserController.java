package controllers;

import play.data.DynamicForm;
import play.mvc.*;
import views.html.*;

import java.util.HashMap;
import java.util.Map;

import static play.mvc.Controller.request;
import static play.mvc.Results.ok;
import static play.mvc.Results.redirect;

/**
 * Created by ShimaK on 13-Mar-17.
 */
public class UserController {

    HashMap<String, User> hash = new HashMap<>();

    /**
     * When login button clicked this method will be invoked
     * Gets username and password via POST method and search for User instance
     * @return if password valid success else fail
     */
    public Result login() {
        final Map<String, String[]> values = request().body().asFormUrlEncoded();
        String username = values.get("login_username")[0];
        String password = values.get("password")[0];

        User user = hash.get(username);

        if (user == null) {
            return ok("Profile not found");
        }

        if (user.getPassword().equals(password)) {
            return ok("Successfully Logged in");
        } else {
            redirect("/login");
            return ok("Login Failed");
        }
    }

    /**
     * When signup button clicked this method will be invoked
     * Gets form details via POST
     * @return message or calls another method
     */
    public Result signUp() {
        final Map<String, String[]> values = request().body().asFormUrlEncoded();
        String fName = values.get("fName")[0];
        String lName = values.get("lName")[0];
        String email = values.get("email")[0];
        String password = values.get("password")[0];
        String username = values.get("username")[0];

        //Creating new instance
        User user = new User(username, fName, lName, email, password);
        User r = hash.put(username, user);
        //Adding user to array and check its added
        if (hash.put(username, user) != null) {
            return displayLogin();
        } else {
            return ok("Failed");
        }
    }

    public Result displayLogin() {
        return ok(login.render());
    }

    public Result displaySignup() {
        return ok(signup.render());
    }
}
