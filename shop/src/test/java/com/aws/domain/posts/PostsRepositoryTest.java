package com.aws.domain.posts;

import com.aws.shop.domain.posts.Posts;
import com.aws.shop.domain.posts.PostsRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    
  }
}
