package com.company.controller;

import com.company.model.Article;
import com.company.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

        @Autowired
        private ArticleRepository articleRepository;

        @GetMapping("/article") // find all articles
        public List<Article> getAllArticles() {
                return articleRepository.findAll();
        }

        @GetMapping("/article/{articleId}") // find article by String articleId
        public Article getArticleById(@PathVariable int articleId) {
               Article article = articleRepository.findById(articleId).get();

                return article;
        }

        @DeleteMapping("article/{articleId}")
        public void deleteArticleById(@PathVariable int articleId) {
                articleRepository.deleteById(articleId);
        }
}