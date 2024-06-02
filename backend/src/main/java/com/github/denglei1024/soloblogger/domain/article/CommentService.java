package com.github.denglei1024.soloblogger.domain.article;

import cn.hutool.core.util.StrUtil;
import com.github.denglei1024.soloblogger.domain.user.CustomUserDetails;
import com.github.denglei1024.soloblogger.exception.ResourceNotFoundException;
import com.github.denglei1024.soloblogger.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * CommentService
 *
 * @author denglei
 * @since 2024-06-02 10:56
 */
@Service
@Slf4j
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    public Comment createComment(String content, String author, String articleId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthor(author);
        comment.setArticleId(articleId);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByArticleId(String articleId) {
        return commentRepository.findByArticleId(articleId);
    }

    public void deleteComment(String id, String currentUser) throws AccessDeniedException {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("找不到评论"));
        if(comment.getAuthor().equals(currentUser) || isAdmin(currentUser)){
            commentRepository.deleteById(id);
        }else{
            throw new AccessDeniedException("没有权限删除评论");
        }
    }

    private boolean isAdmin(String currentUser) {
        UserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return StrUtil.equalsAnyIgnoreCase(userDetails.getUsername(), "admin");
    }
}