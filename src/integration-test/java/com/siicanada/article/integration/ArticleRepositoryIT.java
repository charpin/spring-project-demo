package com.siicanada.article.integration;

import com.siicanada.article.repository.ArticleRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryIT {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private ArticleRepository articleRepository;

  @Test
  public void whenArticleExist_thenReturnTrue() {
    final boolean articleFound = articleRepository.existsById(1);
    Assert.assertTrue(articleFound);
  }

  @Test
  public void whenDeleteArticle_thenArticleNotExistAnymore() {

    List<ArticleEntity> articleEntityList = articleRepository.findAll();
    final int sizeArticleEntityListBefore = articleEntityList.size();

    ArticleEntity articleEntity = articleEntityList.get(0);
    articleRepository.delete(articleEntity);

    final int sizeArticleEntityListExpected = articleRepository.findAll().size();

    Assert.assertEquals(sizeArticleEntityListExpected, sizeArticleEntityListBefore - 1);

    final boolean articleExist = articleRepository.existsById(articleEntity.getId());
    Assert.assertFalse(articleExist);
  }

  @Test
  public void whenSaveArticle_thenArticleAdded() {

    final int sizeArticleListActual = articleRepository.findAll().size();

    ArticleEntity articleEntity = new ArticleEntity();
    articleEntity.setTitle("Canada");
    articleEntity.setIntro("Welcome to Canada");
    articleEntity.setPicture("Picture");
    articleEntity.setPictureDescription("Drapeau du Canada");
    articleEntity.setText("Voici le Canada");

    entityManager.merge(articleEntity);
    entityManager.flush();

    final int sizeArticleListExpected = articleRepository.findAll().size();

    Assert.assertEquals(sizeArticleListExpected, sizeArticleListActual + 1);

  }

}
