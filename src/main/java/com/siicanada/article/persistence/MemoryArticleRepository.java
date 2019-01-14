package com.siicanada.article.persistence;

import com.siicanada.article.model.Article;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryArticleRepository implements ArticleRepository {

  @Override
  public List<Article> getArticles() {
    return null;
  }
}
