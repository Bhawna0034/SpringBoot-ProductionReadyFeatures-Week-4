package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.controllers;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.PostDTO;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(path = "/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputDTO){
        return postService.createNewPost(inputDTO);
    }

}
