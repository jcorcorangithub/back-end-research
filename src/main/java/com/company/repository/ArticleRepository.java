package com.company.repository;

import com.company.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
<<<<<<< HEAD
public interface ArticleRepository extends JpaRepository<Article, String>{
    Optional<Article> findByArticleId(String articleId);
    Optional<Article> deleteByArticleId(String articleId);
=======
public interface ArticleRepository extends JpaRepository<Article, Integer>{
    public Article findByArticleId(String articleId);
>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
}
