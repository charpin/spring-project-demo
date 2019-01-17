package com.siicanada.article.service.mapping;


import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import com.siicanada.article.model.Article;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.repository.entity.TagEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/** Classe de test de la classe {@link com.siicanada.article.service.mapping.ArticleMapper} */
@RunWith(SpringRunner.class)
public class ArticleMapperTest {

  private ArticleMapper articleMapper;

  @Before
  public void setUp(){
    articleMapper = new ArticleMapperImpl();
  }

  @Test
  public void shouldMapEntityToModel() {
    // given
    ArticleEntity articleEntity = new ArticleEntity();
    articleEntity.setId(1);
    articleEntity.setIntro("test intro");
    articleEntity.setText("test text");
    articleEntity.setTitle("test title");
    articleEntity.setPicture("test picture");
    articleEntity.setPictureDescription("test picture description");
    TagEntity tagEntity = new TagEntity();
    tagEntity.setId(1);
    tagEntity.setDescription("test description");
    Set<TagEntity> tags = new HashSet<>();
    tags.add(tagEntity);
    articleEntity.setTags(tags);

    // when
    Article article = articleMapper.entityToModel(articleEntity);

    // then
    assertThat(article)
        .hasFieldOrPropertyWithValue("id",1)
        .hasFieldOrPropertyWithValue("intro","test intro")
        .hasFieldOrPropertyWithValue("text","test text")
        .hasFieldOrPropertyWithValue("title","test title")
        .hasFieldOrPropertyWithValue("picture","test picture")
        .hasFieldOrPropertyWithValue("pictureDescription","test picture description");
    assertTrue(Arrays.asList(article.getTags()).contains("test description"));
  }

  @Test
  public void whenArticleNullThenReturnArticleNull() {
    // given
    ArticleEntity articleEntity = null;
    // when
    Article article = articleMapper.entityToModel(articleEntity);
    // then
    assertTrue(article == null);
  }

  @Test
  public void whenTagNullThenReturnArticleWithTagNull() {
    // given
    ArticleEntity articleEntity = new ArticleEntity();
    articleEntity.setId(1);
    articleEntity.setIntro("test intro");
    articleEntity.setText("test text");
    articleEntity.setTitle("test title");
    articleEntity.setPicture("test picture");
    articleEntity.setPictureDescription("test picture description");
    Set<TagEntity> tags = null;
    articleEntity.setTags(tags);

    // when
    Article article = articleMapper.entityToModel(articleEntity);

    // then
    assertThat(article)
        .hasFieldOrPropertyWithValue("id",1)
        .hasFieldOrPropertyWithValue("intro","test intro")
        .hasFieldOrPropertyWithValue("text","test text")
        .hasFieldOrPropertyWithValue("title","test title")
        .hasFieldOrPropertyWithValue("picture","test picture")
        .hasFieldOrPropertyWithValue("pictureDescription","test picture description");
    assertTrue(article.getTags() == null);
  }

}