package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "palekovnet";
    public static final String TESTDATA_USER_PASSWORD = "w3b-drinken715";

    public static User withNameAndPassword() {
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyUsername() {
        return new User("", TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(TESTDATA_USER_NAME, "");
    }
}
