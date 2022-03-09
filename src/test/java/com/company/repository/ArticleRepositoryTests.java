package com.company.repository;

import com.company.model.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleRepositoryTests {
    @Autowired
    ArticleRepository articleRepository;

    private Article article;
    private Article article2;


    @Before
    public void setUp() throws Exception {
       articleRepository.deleteAll();

       article = new Article();

        article.setArticleId("T_EST");
        article.setUsername("Tester");
        article.setTitle("Testing with Junit");
        article.setLink("www.test.com");
        article.setSnippet("test snippet");
        article.setSummary("Testing");

        article2 = new Article();

        article2.setArticleId("M_OCK");
        article2.setUsername("Mock");
        article2.setTitle("Mocking with Mockify");
        article2.setLink("www.mock.com");
        article2.setSnippet("mock snippet");
        article2.setSummary("Mocking");
    }

    @Test
    public void shouldGetArticleByArticleIdFromDatabase() {
       Article article1 = articleRepository.save(article);
        System.out.println(article1.getTitle());

        Article fromRepo = articleRepository.findByArticleId(article.getArticleId()).get();
        assertEquals(article.getTitle(), fromRepo.getTitle());
    }

    @Test
    public void shouldGetAllArticlesFromDatabase() {
        article = articleRepository.save(article);
        article2 = articleRepository.save(article2);

        List<Article> articleList = articleRepository.findAll();
        assertEquals(articleList, articleRepository.findAll());
    }

    @Test
    public void shouldDeleteArticleFromDatabase() {
      article = articleRepository.save(article);
      article2 = articleRepository.save(article2);

      articleRepository.deleteByArticleId(article2.getArticleId()).get();

      Optional<Article> fromRepo = articleRepository.findByArticleId(article2.getArticleId());
      assertFalse(fromRepo.isPresent());
    }
}
