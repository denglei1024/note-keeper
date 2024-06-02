package com.github.denglei1024.soloblogger.initializer;

import com.github.denglei1024.soloblogger.domain.article.Article;
import com.github.denglei1024.soloblogger.domain.user.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MongoInitializer
 *
 * @author denglei
 * @since 2024-06-02 21:53
 */
@Component
public class MongoInitializer implements CommandLineRunner {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        initUsers();
        initArticles();
    }

    private void initUsers() {
        MongoCollection<Document> users = mongoTemplate.getCollection("users");
        if(users.countDocuments() == 0){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setAdmin(true);
            mongoTemplate.save(user);
        }
    }

    private void initArticles() {
        MongoCollection<Document> articles = mongoTemplate.getCollection("articles");
        if(articles.countDocuments()==0){
            Article article = new Article();
            article.setTitle("Hello World");
            article.setContent("This is the first article.");
            article.setTag("java");
            article.setAuthor("admin");
            mongoTemplate.save(article);
        }
    }
}