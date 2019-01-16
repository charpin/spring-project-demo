package com.siicanada.article.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tag {

  @JsonIgnore
  private Integer id;
  @JsonProperty("description")
  private String description;
}
