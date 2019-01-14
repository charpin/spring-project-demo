package com.siicanada.article.persistence;

import com.siicanada.article.model.Article;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryArticleRepository implements ArticleRepository {

  @Override
  public <S extends Article> S save(S s) {
    return null;
  }

  @Override
  public <S extends Article> Iterable<S> saveAll(Iterable<S> iterable) {
    return null;
  }

  @Override
  public Optional<Article> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Article> findAll() {
    return null;
  }

  @Override
  public Iterable<Article> findAllById(Iterable<Long> iterable) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(Article article) {

  }

  @Override
  public void deleteAll(Iterable<? extends Article> iterable) {

  }

  @Override
  public void deleteAll() {

  }
}
