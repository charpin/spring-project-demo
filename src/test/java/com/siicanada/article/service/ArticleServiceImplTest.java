package com.siicanada.article.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.siicanada.article.model.Article;
import com.siicanada.article.repository.ArticleRepository;
import com.siicanada.article.repository.entity.ArticleEntity;
import com.siicanada.article.service.mapping.ArticleMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Classe de test de la classe {@link ArticleServiceImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

  @Mock
  private ArticleRepository articleRepository;

  @Mock
  private ArticleMapper articleMapper;

  @InjectMocks
  ArticleServiceImpl articleServiceImpl;

  @Test
  public void testGetArticles(){
    //given
    List<ArticleEntity> articleEntityList = new ArrayList<>();
    ArticleEntity articleEntity = new ArticleEntity();
    articleEntityList.add(articleEntity);
    //when
    when(articleRepository.findAll()).thenReturn(articleEntityList);
    when(articleMapper.entityToModel(articleEntity)).thenReturn(new Article());
    //then
    List<Article> articles = articleServiceImpl.getArticles();
    assertFalse(articles.isEmpty());
  }

}