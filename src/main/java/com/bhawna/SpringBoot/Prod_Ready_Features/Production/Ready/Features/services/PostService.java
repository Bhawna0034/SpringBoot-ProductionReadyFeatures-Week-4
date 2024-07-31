package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.services;


import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();
    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
