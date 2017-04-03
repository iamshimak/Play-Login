/**
 * Created by ShimaK on 13-Mar-17.
 */
console.log("Javasript");
/**
 * gets signup page values and validates
 * @return {boolean}
 */
function validateSignupForm() {
    var form = document.forms['signup'];
    if (validateName(form['fName'].value) && validateName(form['lName'].value)
        && validateUsername(form['username'].value) && validatePassword(form['password'].value)) {
        return true;
    }
    document.getElementById('error').innerHTML = "Something missing please fill the form again";
    return false;
}
/**
 * Gets login page values and validates
 * @return {boolean}
 */
function validateLoginForm() {
    var form = document.forms['login'];
    if (!(validateUsername(form['username'].value) && isNotEmpty(form['password'].value))) {
        document.getElementById('login_error').innerHTML = "Username or Password is empty try again";
        return false;
    }
    return true;
}
/**
 * Check this String contains numbers
 * && String length less than 20
 * && String is not null
 * @param name String to validate
 * @return boolean
 */
function validateName(name) {
    return (!name.match('.*\\d+.*') && name.length < 20 && isNotEmpty(name));
}
/**
 * Check this Sting is not null
 * && String length is not more than 15
 * @param name String
 * @return boolean
 */
function validateUsername(name) {
    return name.length < 15 && isNotEmpty(name);
}
/**
 * Check password length is greater than 8
 * @param password
 * @return {boolean}
 */
function validatePassword(password) {
    return password.length > 8 && isNotEmpty(password);
}
/**
 * Check String is null
 * @param text
 * @return {boolean}
 */
function isNotEmpty(text) {
    return text.length > 0;
}
