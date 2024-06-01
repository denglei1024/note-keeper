package com.github.denglei1024.soloblogger.domain.article;

import com.github.denglei1024.soloblogger.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ArticleService
 *
 * @author denglei
 * @since 2024-06-01 23:03
 */
@Service
@Slf4j
public class ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    public Article createArticle(String title, String content, String author){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        article.setCreatedAt(LocalDateTime.now());
        return articleRepository.save(article);
    }
}