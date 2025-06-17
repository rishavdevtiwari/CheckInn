import checkinn.dao.UserDao;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserLoginTest {

    private static final String TEST_EMAIL = "Test1234@gmail.com"; // Same as in your registration test
    private static final String TEST_PASSWORD = "password1234";

    private static UserDao dao;

    @BeforeClass
    public static void setup() {
        dao = new UserDao();
    }

    @Test
    public void loginWithValidCredentials_shouldSucceed() {
        boolean result = dao.authenticateUser(TEST_EMAIL, TEST_PASSWORD);
        Assert.assertTrue("Login should succeed with correct credentials", result);
    }

    @Test
    public void loginWithInvalidPassword_shouldFail() {
        boolean result = dao.authenticateUser(TEST_EMAIL, "wrongpassword");
        Assert.assertFalse("Login should fail with wrong password", result);
    }

    @Test
    public void loginWithNonexistentEmail_shouldFail() {
        boolean result = dao.authenticateUser("nonexistent@example.com", "anyPassword");
        Assert.assertFalse("Login should fail with nonexistent email", result);
    }
}
