package com.siicanada.article.service;

import com.siicanada.article.repository.TagRepository;
import com.siicanada.article.repository.entity.TagEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagServiceImpl implements TagService {

  @Autowired
  private TagRepository tagRepository;

  public List<TagEntity> getTags() {
    return tagRepository.findAll();
  }
}
