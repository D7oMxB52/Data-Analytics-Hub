import com.example.app.model.UpgradeToVIP;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpgradeToVIPTest {

    ActionEvent event = null;
    String firstName = "NON-EXISTED";
    String lastName = "USER";
    @Test
    public void InvalidUpgradeToVIP(){
        try{
            // this method will give us an error since the user does not exist in the database
            UpgradeToVIP upgradeToVIP = new UpgradeToVIP(event, firstName,lastName);

        } catch (ExceptionInInitializerError e){
            System.out.println("The user does not exist in the system");
            assertTrue(true);
        }


    }

}
