package com.example.app.model;

import java.util.List;
import java.util.Optional;
public class Search {


    int numId;
    List<Posts> postsList;
    public Search(String numId, List<Posts> postsList) {
        this.numId = Integer.parseInt(numId);
        this.postsList = postsList;
    }

    public Search() {

    }

    public Posts searchById(){
        String found = null;
        Posts foundPost = new Posts();
        Optional<Posts> searchById = postsList.stream().filter(post -> post.getId() == numId).findFirst();
        if (searchById.isPresent()) {
            found = searchById.get().id+"  |  "+searchById.get().content+"  |  "+searchById.get().likes;
            foundPost.setContent(searchById.get().content);
            foundPost.setAuthor(searchById.get().author);
            foundPost.setShares(searchById.get().shares);
            foundPost.setLikes(searchById.get().likes);
            foundPost.setDateTime(searchById.get().dateTime);
            return foundPost;
        } else {
            found = "Sorry the post does not exist in the collection!";
            System.out.println(found);
            return null;
        }

    }

}
