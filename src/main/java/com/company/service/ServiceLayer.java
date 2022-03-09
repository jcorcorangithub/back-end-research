package com.company.service;

import com.company.model.Article;
import com.company.model.User;
import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {
    private ArchiveRepository archiveRepository;
    private ArticleRepository articleRepository;
<<<<<<< HEAD
//    private MemberRepository memberRepository;
=======
    //    private MemberRepository memberRepository;
>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
    private UserRepository userRepository;

    @Autowired
    public ServiceLayer(
            ArchiveRepository archiveRepository,
            ArticleRepository articleRepository,
//            MemberRepository memberRepository,
            UserRepository userRepository) {
        this.archiveRepository = archiveRepository;
        this.articleRepository = articleRepository;
//        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User findUser(String username) {

        User foundUser = userRepository.findByUsername(username);
        return foundUser;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {

        User foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.getUsername() == null) {
            throw new IllegalArgumentException("Cannot update, user does not exist in the database.");
        }

        //      Overwriting foundUser's previous field values with the
        //      Field values from RequestBody user object.
        //      We need to set the field values because the incoming RequestBody user
        //      Will contain the new field values to replace the foundUser's current field values
        //      (i.e. username, firstname, lastname, email, & password)
        foundUser.setUsername(user.getUsername());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        return userRepository.save(foundUser);
    }

    public void deleteUser(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.getUsername() == null) {
            throw new IllegalArgumentException("Cannot delete, user does not exist in the database.");
        }

        //  Delete a user
        userRepository.delete(foundUser);
    }

    public Article saveArticle(Article article) {

        return articleRepository.save(article);
    }

    public Article findArticle(String articleId) {

        Article foundArticle = articleRepository.findByArticleId(articleId);
        return foundArticle;
    }

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> findUserArticles(String username) {
        User foundUser = userRepository.findByUsername(username);

        if (foundUser.getUsername() == null) {
            throw new IllegalArgumentException("User does not exist in the database");
        }

        List<Article> articleList = articleRepository.findAll();

        List<Article> userArticles = articleList
                .stream()
                .filter(a -> a.getUsername() == username)
                .collect(Collectors.toList());

        return userArticles;
    }

    public void deleteArticle(Article article) {

        Article foundArticle = articleRepository.findByArticleId(article.getArticleId());

        if (foundArticle.getArticleId() == null) {
            throw new IllegalArgumentException("Cannot delete, article does not exist in database.");
        }

        articleRepository.delete(foundArticle);
    }
}
