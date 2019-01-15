package com.siicanada.article.model;

import java.util.Set;
import lombok.Data;

@Data
public class Article {

  private Integer id;
  private String title;
  private String intro;
  private String text;
  private String picture;
  private String pictureDescription;
  private Set<Tag> tags;

}
