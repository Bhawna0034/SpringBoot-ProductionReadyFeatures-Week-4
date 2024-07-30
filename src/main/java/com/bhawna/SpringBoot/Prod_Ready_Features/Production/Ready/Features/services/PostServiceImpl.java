package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.services;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.dto.PostDTO;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.entities.PostEntity;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.exceptions.ResourceNotFoundException;
import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements  PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDTO> getAllPosts() {
      return postRepository.findAll()
              .stream()
              .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
              .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputDTO) {
        PostEntity postEntity = modelMapper.map(inputDTO, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post Not Found with id: " + postId));
       return modelMapper.map(postEntity, PostDTO.class);
    }
}
