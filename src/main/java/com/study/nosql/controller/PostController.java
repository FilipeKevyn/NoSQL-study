package com.study.nosql.controller;

import com.study.nosql.domain.Post;
import com.study.nosql.domain.dto.PostDTO;
import com.study.nosql.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        Post post = service.findById(id);
        var dto = new PostDTO(post.getId(), post.getTitle(), post.getBody(), post.getAuthor().getName());

        return ResponseEntity.ok().body(dto);
    }
}
