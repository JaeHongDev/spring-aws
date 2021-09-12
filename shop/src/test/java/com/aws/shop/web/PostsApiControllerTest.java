package com.aws.shop.web;

import com.aws.shop.domain.posts.PostsRepository;
import com.aws.shop.web.dto.PostsSaveRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class PostsApiControllerTest {
  
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private PostsRepository postsRepository;

  @After
  public void tearDonw() throws Exception {
    postsRepository.deleteAll();
  }

  @Test
  public void Posts_regist() throws Exception{
    String title = "title";
    String content = "content";
    PostsSaveRequestDto requestDto = 
      PostsSaveRequestDto.builder()
      .title(title)
      .content(content)
      .author("author")
      .build();

      String url = "http://localhost:" + port + "/api/v1/posts";

      ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);


  }
}
