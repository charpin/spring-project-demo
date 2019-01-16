package com.siicanada.article.integration;

import com.siicanada.article.repository.TagRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.repository.entity.TagEntity;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryIT {

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private TagRepository tagRepository;

  @Test
  public void whenTagExistThenReturnTrue() {
    final boolean tagFound = tagRepository.existsById(1);
    Assert.assertTrue(tagFound);
  }

  @Test
  public void getArticlesFromSpecificTag() {
    TagEntity tagFound = tagRepository.findById(1).get();
    List<ArticleEntity> articlesFromTag = tagFound.getArticles();
    Assert.assertFalse(articlesFromTag.isEmpty());
  }
}
