import com.example.app.model.FetchPostById;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
ActionEvent event;

    @Test
    public void testSearchForExistedPost(){

        FetchPostById f = new FetchPostById( event, "55");
        String expectedAuthor = "abdul";

        //test fetchPostById functionality
        assertEquals(expectedAuthor, f.FetchPostById(event,"55").author);

    }

    @Test
    public void testSearchForNonExistedPost(){
        try {
            FetchPostById f = new FetchPostById( event, "5");
            String expectedAuthor = "abdul";

            //test fetchPostById functionality
            assertEquals(expectedAuthor,f.FetchPostById(event,"5").author );

        } catch ( ExceptionInInitializerError e){
            assertTrue(true);
        }
    }


}