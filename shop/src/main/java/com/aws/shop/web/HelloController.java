package com.aws.shop.web;

import com.aws.shop.web.dto.HelloResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.aws.shop.domain.posts.Posts;
import com.aws.shop.domain.posts.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HelloController {
  @Autowired
  PostsRepository postsRepository;

  @GetMapping("/hello")
  public Posts hello(){
		String title ="테스트 게시글";
    String content = "테스트 본문";

    postsRepository.save(
			Posts.builder()
			.title(title)
			.content(content)
			.author("test@email.com")
			.build() 
			);
    
    List<Posts> posts = postsRepository.findAll();


    return posts.get(0);
  }

  @GetMapping("/hello/dto")
  public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam int amount){
    return new HelloResponseDto(name, amount);
  }
}
