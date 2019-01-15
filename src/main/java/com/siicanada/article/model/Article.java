package com.siicanada.article.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Article {

  @JsonProperty("id")
  private Integer id;
  @JsonProperty("title")
  private String title;
  @JsonProperty("intro")
  private String intro;
  @JsonProperty("text")
  private String text;
  @JsonProperty("picture")
  private String picture;
  @JsonProperty("picture_description")
  private String pictureDescription;
  @JsonProperty("tags")
  private String[] tags;

}
