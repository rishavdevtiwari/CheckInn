import checkinn.dao.UserDao;
import checkinn.model.RegistrationRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Puja Pandey
 */
public class UserRegistrationTest {

    String firstName = "User";
    String lastName = "Test";
    String phone = "9700000000";
    String email = "Test1234@gmail.com";  
    String password = "password1234";

    @Test
    public void registerWithNewCredentials() {
        RegistrationRequest request = new RegistrationRequest(
            firstName, lastName, phone, email, password
        );
        
        UserDao dao = new UserDao();
        boolean result = dao.registerUser(request);
        Assert.assertTrue("Registration should succeed with new credentials", result);
    }

    @Test
    public void registerWithExistingCredentials() {
        RegistrationRequest request = new RegistrationRequest(
            firstName, lastName, phone, email, password
        );

        UserDao dao = new UserDao();
        boolean result = dao.registerUser(request);
        Assert.assertFalse("Registration should fail with existing credentials", result);
    }
}
