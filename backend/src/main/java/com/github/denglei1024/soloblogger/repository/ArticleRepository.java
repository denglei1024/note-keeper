package com.github.denglei1024.soloblogger.repository;

import com.github.denglei1024.soloblogger.domain.article.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ArticleRepository
 *
 * @author denglei
 * @since 2024-06-01 23:03
 */
public interface ArticleRepository extends MongoRepository<Article, String> {
}