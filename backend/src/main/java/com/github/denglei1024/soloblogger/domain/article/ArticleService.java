package com.github.denglei1024.soloblogger.domain.article;

import cn.hutool.core.util.StrUtil;
import com.github.denglei1024.soloblogger.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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

    public Article updateArticle(String id, String title, String content){
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("文章不存在"));
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.save(article);
    }

    public void deleteArticle(String id){
        articleRepository.deleteById(id);
    }

    public Article getArticle(String id){
        return articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("文章不存在"));
    }

    public Page<Article> getArticles(int page, int size, String tag, Pageable pageable){
        if(StrUtil.isEmpty(tag)){
            return articleRepository.findAll(pageable);
        }
        return articleRepository.findByTagsContaining(tag, pageable);
    }

    public List<Article> searchArticles(String text){
        return articleRepository.searchArticles(text);
    }
}