package com.siicanada.article.repository.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "article")
public class ArticleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "title")
  private String title;
  @Column(name = "intro")
  private String intro;
  @Column(name = "text")
  private String text;
  @Column(name = "picture")
  private String picture;
  @Column(name = "picture_description")
  private String pictureDescription;
  @ManyToMany(fetch = FetchType.LAZY, cascade = {
      CascadeType.PERSIST, CascadeType.MERGE
  })
  @JoinTable(name = "article_tag",
      joinColumns = {@JoinColumn(name = "article_id")},
      inverseJoinColumns = {@JoinColumn(name = "tag_id")})
  @OrderColumn(name = "description")
  private Set<TagEntity> tags = new HashSet<>();

}
