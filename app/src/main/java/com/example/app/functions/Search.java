package com.example.app.functions;

import java.util.List;
import java.util.Optional;
public class Search {
    int numId;
    List<Posts> postsList;
    public Search(String numId, List<Posts> postsList) {
        this.numId = numId;
        this.postsList = postsList;
    }

    public String searchById(){
        String found = null;
        Optional<Posts> searchById = postsList.stream().filter(post -> post.getId() == numId).findFirst();
        if (searchById.isPresent()) {
            found = searchById.get().id+"  |  "+searchById.get().content+"  |  "+searchById.get().likes;
        } else {
            found = "Sorry the post does not exist in the collection!";
        }
        return found;

    }

}
