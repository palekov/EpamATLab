package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

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
