package com.company.service;

import com.company.model.Archive;
import com.company.model.Article;
import com.company.model.User;
import com.company.repository.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.junit.Assert.*;

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

    @MockBean
    ArchiveArticleRepository archiveArticleRepository;

    @MockBean
    MemberRepository memberRepository;

//    Declare input & output objects
    User inputUser;
    User outputUser;
    List<User> users;

    Article inputArticle;
    Article outputArticle;
    List<Article> articles;

    Archive inputArchive;
    Article outputArchive;
    List<Article> archives;

    @Before
    public void setUp() throws Exception {
//        Initialize input objects & output objects
    }
}