package com.example.app.functions;

import java.util.List;

public class Delete extends Search{
    public Delete(int numId, List<Posts> postsList) {
        super(String.valueOf(numId), postsList);
        this.numId = numId;
        this.postsList = postsList;
    }
    String deleted = null;
    // Delete
    public String deleteById(){
        boolean removed = postsList.removeIf(post -> post.getId() == numId);
        if (removed){
            deleted = "The post with "+ numId + " ID got deleted";
        }
        else {
            deleted = "Sorry the post does not exist in the collection!";
        }
        return deleted;
    }
}

