package com.github.denglei1024.soloblogger.controller;

import com.github.denglei1024.soloblogger.domain.article.Article;
import com.github.denglei1024.soloblogger.domain.article.ArticleService;
import com.github.denglei1024.soloblogger.dto.request.CreateArticleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ArticleController
 *
 * @author denglei
 * @since 2024-06-01 23:05
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/create")
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleRequest request){
        Article article = articleService.createArticle(request.getTitle(), request.getContent(), request.getAuthor());
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }
}