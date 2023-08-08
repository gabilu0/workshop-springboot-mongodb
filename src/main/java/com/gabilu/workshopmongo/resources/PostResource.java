package com.gabilu.workshopmongo.resources;

import com.gabilu.workshopmongo.domain.Post;

import com.gabilu.workshopmongo.resources.util.URL;
import com.gabilu.workshopmongo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        List<Post> posts = service.findByTitle(title);
        return ResponseEntity.ok(posts);
    }
}
