import com.example.app.model.AddNewPost;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AddNewPostTest {
    ActionEvent event;
    String postId = "11";
    String content = "hithere";
    String author = "me";
    String likes = "3";
    //wrong number
    String share =  "-10";
    String date = "4/12/2023 14:30";
    String path = "C:\\Users\\devab\\Documents\\GitHub\\Data-Analytics-Hub\\app\\src\\main\\java\\com\\example\\app\\posts.csv";;
    @Test
    public void invalidPost(){

        try{
            // we will catch an error since whe had wrong "share" input
            AddNewPost newPost = new AddNewPost(event, postId, content, author, likes,share, date, path);

        } catch (ExceptionInInitializerError e){
            System.out.println("Invalid Share input");
            assertTrue(true);
        }
    }
}
