package com.company.service;

import com.company.model.Archive;
import com.company.model.Article;
import com.company.model.Member;
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
    Archive outputArchive;
    List<Archive> archives;

    Member inputMember;
    Member outputMember;
    List<Member> members;

    @Before
    public void setUp() throws Exception {
        //  Initialize input objects & output objects

        //  User
        inputUser = new User("@johndoe123", "John", "Doe", "johndoe@gmail.com", "password1");
        outputUser = new User();
        outputUser.setUsername("@johndoe123");
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
        articles.add(outputArticle);

        //   Archive
        inputArchive = new Archive("@johndoe123", "Biology");
        outputArchive = new Archive();
        outputArchive.setArchiveId(1);
        archives.add(outputArchive);

        //   Member
        inputMember = new Member("@johndoe123", 1, "John", "Doe");
        outputMember = new Member();
        outputMember.setMemberId("@johndoe123");
        members.add(outputMember);
    }
}