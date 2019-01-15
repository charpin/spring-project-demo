package com.siicanada.article.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class TagTest {

  @Test
  public void whenConvertTagToJson_thenCorrect() throws JsonProcessingException {
    Tag tag = new Tag();
    tag.setId(1);
    tag.setDescription("sport");

    String jsonExpected = "{\"description\":\"sport\"}";
    String result = new ObjectMapper().writeValueAsString(tag);

    Assert.assertEquals(jsonExpected, result);
  }
}
