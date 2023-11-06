public class SecurePassword {
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }


    /* Returns true if password:
       - Is at least 8 characters long
       - Contains at least one uppercase letter
       - Contains at least one lowercase letter
       - Contains at least one numeric digit
       - Contains at least one of these "special symbols":  ! @ # $ % ^ & * ?
       Must satisfy ALL FIVE categories for password to be "secure"
       Return false if any of the above security requirements are not fulfilled.
    */
    public boolean isSecure() {
        if (!containsDigit()) {
            return false;
        }
        if (!containsLowercase()) {
            return false;
        }
        if (!containsUppercase()) {
            return false;
        }
        if (!containsSpecialSymbol()) {
            return false;
        }
        return isLongEnough(password);
    }


    /* Returns a String that contains information about the security status of the
       current password.

       If isSecure() is true, this method returns the string "Password is secure"
       If isSecure() is false, this methods should return a single String that informs the
       user of which security requirements are not currently being met.

       For example, the password 3WrT6tH does not meet length or special symbol
       requirements, so this method should return the following String (using a line
       break \n):

       "The password must be at least 8 characters
        The password must contain a special symbol: ! @ # $ % ^ & * ?"
    */
    public String status() {
        if (isSecure()) {
            return "Congrats! Your password is secure";
        } else {
            return "You might as well not have a password.";
        }
    }

    public String insult() {
        int randNum = (int) (Math.random() * 10) + 1;
        if (randNum == 1) {
            return "You might as well not have a password.";
        } else if (randNum == 2) {
            return "Is that really the best you can think of?";
        } else if (randNum == 3) {
            return "Are you blind? Do you know how to read?";
        } else if (randNum == 4) {
            return "Its a miracle you passed second grade";
        } else if (randNum == 5) {
            return "All you had to do is mash your keyboard. It isn't that hard.";
        } else if (randNum == 6) {
            return "Just tell everyone your password";
        } else if (randNum == 7) {
            return "I hope you don't plan on using this password on an account you want to keep";
        } else if (randNum == 8) {

        }
    }

    // PRIVATE "HELPER" METHODS (marked "private" rather than "public" which means other
    // methods in this class can call these methods, but code outside of this class cannot)

    /* Returns true if the password’s length meets the minimum requirement of 8 characters
       and false otherwise.
     */
    private boolean isLongEnough(String password) {
        return password.length() >= 8;
    }


    /* Returns true if the password has at least one uppercase letter and false otherwise.
     */
    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }


    /* Returns true if the password has at least one lowercase letter and false otherwise.
     */
    private boolean containsLowercase() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }


    /* Returns true if the password has at least one digit and false otherwise.
     */
    private boolean containsDigit() {
        String digits = "1234567890";
        return checkString(digits);
    }


    /* Returns true if the password has at least one of these special symbols:
       ! @ # $ % ^ & * ?    and false otherwise.
     */
    private boolean containsSpecialSymbol() {
        String specialChar = "!@#$%^&*?";
        return checkString(specialChar);
    }

    /* Checks characterString to see if password contains at least one
       character from that string. Returns true if so, false otherwise.

       For example, if characterString is "ABCDEFGH" and password == "jbHFmfA"
       this method will find two occurrences (F and A) and return true, since two
       is at least one.  If characterString is "ABCDEFGH" and password == "xyz123"
       this method will return false, since password contains none of the characters in
        characterString.
     */
    private boolean checkString(String characterString) {
        for (int i = 0; i < characterString.length(); i++) {
            if (password.contains(characterString.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    }
}
