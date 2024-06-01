package com.github.denglei1024.soloblogger.controller;

import com.github.denglei1024.soloblogger.domain.article.Article;
import com.github.denglei1024.soloblogger.domain.article.ArticleService;
import com.github.denglei1024.soloblogger.dto.request.ArticleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest request){
        Article article = articleService.createArticle(request.getTitle(), request.getContent(), request.getAuthor());
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable String id, @RequestBody ArticleRequest request){
        Article article = articleService.updateArticle(id, request.getTitle(), request.getContent());
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable String id){
        Article article = articleService.getArticle(id);
        return ResponseEntity.ok(article);
    }
}