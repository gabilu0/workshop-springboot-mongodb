package com.gabilu.workshopmongo.services;

import com.gabilu.workshopmongo.domain.Post;
import com.gabilu.workshopmongo.repository.PostRepository;
import com.gabilu.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElseThrow(() -> new ObjectNotFoundException("Post not found with ID: " + id));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }
}