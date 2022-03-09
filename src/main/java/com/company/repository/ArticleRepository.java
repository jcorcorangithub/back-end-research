package com.company.repository;

import com.company.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String>{
    Optional<Article> findByArticleId(String articleId);
    Optional<Article> deleteByArticleId(String articleId);
}
