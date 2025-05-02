package com.study.nosql.services;

import com.study.nosql.domain.Post;
import com.study.nosql.domain.dto.PostDTO;
import com.study.nosql.exceptions.PostNotFoundException;
import com.study.nosql.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        return repository.findById(id).orElseThrow(() -> new PostNotFoundException());
    }
}
