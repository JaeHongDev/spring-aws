package com.aws.domain.posts;

import java.util.List;

import com.aws.shop.ShopApplication;
import com.aws.shop.domain.posts.Posts;
import com.aws.shop.domain.posts.PostsRepository;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
  
  @Autowired
  PostsRepository postsRepository;


  @After
  public void cleanup(){
    postsRepository.deleteAll();
  }

  @Test
  public void load_postSave(){
    String title ="테스트 게시글";
    String content = "테스트 본문";

    postsRepository.save(Posts.builder().title(title).content(content).author("test@email.com").build() );
    
    List<Posts> posts = postsRepository.findAll();

    Posts post = posts.get(0);

    Assertions.assertThat(post.getTitle()).isEqualTo(title);
    Assertions.assertThat(post.getContent()).isEqualTo(content);
  }
}
