package com.siicanada.article.service.mapping;

import com.siicanada.article.model.Article;
import com.siicanada.article.repository.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses= {TagMapper.class})
public interface ArticleMapper {

  ArticleMapper INSTANCE = Mappers.getMapper( ArticleMapper.class );

  Article entityToModel(ArticleEntity entity);

}
