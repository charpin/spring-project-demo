package com.siicanada.article.service;

import com.siicanada.article.model.Article;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Business Logic Layer interface.
 */
@Service
public interface ArticleService {

  /**
   * Get all articles.
   *
   * @return List list of articles.
   */
  List<Article> getArticles();

  /**
   * Get one article by id.
   *
   * @param id article id
   * @return Article article
   */
  Article getArticleById(Integer id);

  /**
   * Get articles by tag descriptions.
   *
   * @param description tag description
   * @return List list of articles.
   */
  List<Article> getArticlesByTagDescription(String description);

}
