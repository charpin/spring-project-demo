package com.siicanada.article.persistence;

import com.siicanada.article.model.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {}
