package com.aws.shop.web;


import org.junit.runner.RunWith;


import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
  @Autowired
  private MockMvc mvc;

  @Test
   public void return_hello() throws Exception {
    String hello = "hello";
    mvc.perform(
      MockMvcRequestBuilders.get("/hello")
    ).andExpect(MockMvcResultMatchers.status().isOk())
    .andExpect(MockMvcResultMatchers.content().string(hello));
  }

  @Test
  public void return_helloDto() throws Exception {

    String name = "hello";
    int amount = 1;

    mvc.perform(
      MockMvcRequestBuilders.get("/hello/dto")
      .param("name",name)
      .param("amount",String.valueOf(amount))
    ).andExpect(MockMvcResultMatchers.status().isOk())
     .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Is.is(amount)))
     .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(name)));

  } 
}
