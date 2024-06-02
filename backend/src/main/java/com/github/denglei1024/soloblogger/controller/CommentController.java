package com.github.denglei1024.soloblogger.controller;

import com.github.denglei1024.soloblogger.domain.article.Comment;
import com.github.denglei1024.soloblogger.domain.article.CommentService;
import com.github.denglei1024.soloblogger.domain.user.CustomUserDetails;
import com.github.denglei1024.soloblogger.request.CommentRequest;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * CommentController
 *
 * @author denglei
 * @since 2024-06-02 11:03
 */
@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createCommon(@PathVariable String articleId, @RequestBody CommentRequest request){
        Comment comment = commentService.createComment(request.getContent(), request.getAuthor(), articleId);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getCommonsByArticleId(@PathVariable String articleId){
        List<Comment> comments = commentService.getCommentsByArticleId(articleId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{commentId}")
    @SneakyThrows
    public ResponseEntity<Void> deleteComment(@PathVariable String commentId, @AuthenticationPrincipal CustomUserDetails userDetails){
        String currentUser = userDetails.getUsername();
        commentService.deleteComment(commentId, currentUser);
        return ResponseEntity.noContent().build();
    }
}