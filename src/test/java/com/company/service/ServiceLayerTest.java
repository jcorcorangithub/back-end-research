package com.company.service;

import com.company.model.Archive;
import com.company.model.Article;
//import com.company.model.Member;
import com.company.model.User;
import com.company.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    //    Instantiate ServiceLayer when needed
    @Autowired
    ServiceLayer service;

    //    Declare mockbean repositories
    @MockBean
    UserRepository userRepository;

    @MockBean
    ArticleRepository articleRepository;

    @MockBean
    ArchiveRepository archiveRepository;

<<<<<<< HEAD
    @MockBean
=======
//    @MockBean
>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
//    MemberRepository memberRepository;

    //    Declare input & output objects
    User inputUser;
    User outputUser;
    List<User> users;

    Article inputArticle;
    Article outputArticle;
    List<Article> articles;

    Archive inputArchive;
    Archive outputArchive;
    List<Archive> archives;
<<<<<<< HEAD
//
=======

>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
//    Member inputMember;
//    Member outputMember;
//    List<Member> members;

    @Before
    public void setUp() throws Exception {
        //  Initialize input objects & output objects

        //  User
        inputUser = new User("@johndoe123", "John", "Doe", "johndoe@gmail.com", "password1");
        outputUser = new User();
        outputUser.setUsername("@johndoe123");
        users = new ArrayList<>();
        users.add(outputUser);

        //   Article
        inputArticle = new Article(
                "JC4Acibs_4kJ",
                "@johndoe123",
                "Population biology of plants.",
                "https://www.cabdirect.org/cabdirect/abstract/19782321379",
                "The first chapter is concerned with experiments, analogies and models.",
                "JL Harper - Population biology of plants., 1977 - cabdirect.org"
        );
        outputArticle = new Article();
        outputArticle.setArticleId("JC4Acibs_4kJ");
        articles = new ArrayList<>();
        articles.add(outputArticle);

        //   Archive
        inputArchive = new Archive("@johndoe123", "Biology");
        outputArchive = new Archive();
        outputArchive.setArchiveId(1);
        archives = new ArrayList<>();
        archives.add(outputArchive);

        //   Member
//        inputMember = new Member(outputUser, 1);
//        outputMember = new Member(outputUser, 1);
//        members = new ArrayList<>();
//        members.add(outputMember);
    }

    @Test
    public void shouldSaveUserToDatabase() {
        //      Pass input user to service
        when(userRepository.save(inputUser)).thenReturn(outputUser);
        when(userRepository.findByUsername(outputUser.getUsername())).thenReturn(outputUser);

        User savedUser = service.saveUser(inputUser);
        User fromServiceUser = service.findUser(savedUser.getUsername());
        assertEquals(fromServiceUser.getUsername(), outputUser.getUsername());
    }

    @Test
    public void shouldReturnAUserFromTheDatabase() {
        when(userRepository.findByUsername(outputUser.getUsername())).thenReturn(outputUser);

        User fromServiceUser = service.findUser(outputUser.getUsername());
        assertEquals(fromServiceUser.getUsername(), outputUser.getUsername());
    }

    @Test
    public void shouldReturnAListOfUsersFromTheDatabase() {
        when(userRepository.findAll()).thenReturn(users);

        List<User> fromServiceUsers = service.findAllUsers();
        assertEquals(fromServiceUsers.get(0).getUsername(), outputUser.getUsername());
    }

    @Test
    public void shouldUpdateAUserFromTheDatabase() {
        User updatedUser = new User("@johndoe123", "Jane", "Dawson", "janedawson@gmail.com", "password1");

        when(userRepository.findByUsername(updatedUser.getUsername())).thenReturn(inputUser);
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);

        User fromServiceUpdatedUser = service.updateUser(updatedUser);
        assertEquals(fromServiceUpdatedUser.getUsername(), updatedUser.getUsername());
    }

    @Test
    public void shouldDeleteAUserFromTheDatabase() {
        User foundUser = new User("@johndoe123", "John", "Doe", "johndoe@gmail.com", "password1");

        when(userRepository.findByUsername(inputUser.getUsername())).thenReturn(foundUser);
        doNothing().when(userRepository).delete(foundUser);

        service.deleteUser(foundUser);
    }

    @Test
    public void shouldStoreAnArticleToAUserInDatabase() {
        when(articleRepository.findByArticleId(inputArticle.getArticleId())).thenReturn(outputArticle);
        when(articleRepository.save(inputArticle)).thenReturn(outputArticle);

        Article saveArticle = service.saveArticle(inputArticle);
        Article fromServiceArticle = service.findArticle(inputArticle.getArticleId());
        assertEquals(fromServiceArticle.getArticleId(), saveArticle.getArticleId());
    }

    @Test
    public void shouldReturnAnArticleFromTheDatabase() {
        when(articleRepository.findByArticleId(inputArticle.getArticleId())).thenReturn(outputArticle);

        Article fromServiceArticle = service.findArticle(inputArticle.getArticleId());
        assertEquals(fromServiceArticle.getArticleId(), outputArticle.getArticleId());
    }

    @Test
    public void shouldReturnAllArticlesFromTheDatabase() {
        when(articleRepository.findAll()).thenReturn(articles);

        List<Article> fromServiceArticles = service.findAllArticles();
        assertEquals(fromServiceArticles.get(0).getArticleId(), outputArticle.getArticleId());
    }

    @Test
    public void shouldReturnAllArticlesBelongingToAUser() {
        List<Article> userArticlesList = new ArrayList<>(Arrays.asList(inputArticle));
        when(articleRepository.findAll()).thenReturn(userArticlesList);
        when(userRepository.findByUsername(outputUser.getUsername())).thenReturn(inputUser);

        List<Article> fromServiceUserArticles = service.findUserArticles(outputUser.getUsername());
        assertEquals(fromServiceUserArticles.get(0).getArticleId(), outputArticle.getArticleId());
    }

    @Test
    public void shouldDeleteAnArticleFromTheDatabase() {
        Article articleToDelete = new Article(
                "JC4Acibs_4kJ",
                "@johndoe123",
                "Population biology of plants.",
                "https://www.cabdirect.org/cabdirect/abstract/19782321379",
                "The first chapter is concerned with experiments, analogies and models.",
                "JL Harper - Population biology of plants., 1977 - cabdirect.org"
        );

        when(articleRepository.findByArticleId(inputArticle.getArticleId())).thenReturn(articleToDelete);
        doNothing().when(articleRepository).delete(articleToDelete);
        service.deleteArticle(articleToDelete);
    }

    @Test
    public void shouldCreateANewArchiveToDatabase() {

    }

    @Test
    public void shouldUpdateAnArchiveNameInDatabase() {

    }

    @Test
    public void shouldDeleteAnArchiveInTheDatabase() {

    }

    @Test
    public void shouldSaveAnArticleToAnArchive() {

    }

    @Test
    public void shouldCreateANewArchiveMember() {

    }

    @Test
    public void shouldDeleteAnArchiveMember() {

    }
}