package com.aws.shop.service;

import javax.transaction.Transactional;

import com.aws.shop.domain.posts.PostsRepository;
import com.aws.shop.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository; 


  @Transactional
  public Long save(PostsSaveRequestDto requestDto){
    return postsRepository.save(requestDto.toEntity()).getId();
  }
}
