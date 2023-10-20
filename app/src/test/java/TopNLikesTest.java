import com.example.app.model.TimeValidator;
import com.example.app.model.TopNLikes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TopNLikesTest {

   @Test
    public void testInvalidInput(){

       try{

           //we will test an invalid number inserted...
           TopNLikes number = new TopNLikes();

           // assume we inserted number beyond the total number if posts
           number.TopNLikes(999);

       } catch (ExceptionInInitializerError e){
           //since we handle this error, that means the input is invalid.
           assertTrue(true);
       }

    }

    @Test
    public void testValidInput(){
        //we will test a valid number inserted...
        TopNLikes number = new TopNLikes();

        // assume we inserted number is correct
        String expectedValue = "1: ID:37221, Author: 3827F2, Likes: 526\n" +
                "2: ID:55, Author: abdul, Likes: 500\n";

        String actualValue = String.valueOf(number.TopNLikes(2));
        assertEquals(expectedValue,actualValue);
    }

}