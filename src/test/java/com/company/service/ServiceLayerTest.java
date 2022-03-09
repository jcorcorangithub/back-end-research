package com.company.service;

import com.company.model.Archive;
import com.company.model.Article;
//import com.company.model.Member;
import com.company.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    //    Instantiate ServiceLayer when needed
    @Autowired
    ServiceLayer service;

    //    Declare mockbeans of repositories
    @MockBean
    ArticleRepository articleRepository;

    @MockBean
    ArchiveRepository archiveRepository;



    Article inputArticle;
    Article outputArticle;
    List<Article> articles;

    Archive inputArchive;
    Archive outputArchive;
    List<Archive> archives;

//    Member inputMember;
//    Member outputMember;
//    List<Member> members;

    @Before
    public void setUp() throws Exception {
        //  Initialize input objects & output objects

        //   Article
        inputArticle = new Article(
                1,
                "Population biology of plants.",
                "https://www.cabdirect.org/cabdirect/abstract/19782321379",
                "The first chapter is concerned with experiments, analogies and models.",
                "JL Harper - Population biology of plants., 1977 - cabdirect.org"
        );
        outputArticle = new Article();
        outputArticle.setArticleId(1);
        articles = new ArrayList<>();
        articles.add(outputArticle);

        // Article set
        Set<Article> archiveArticles = new HashSet<>();
        archiveArticles.add(inputArticle);

        //   Archive
        inputArchive = new Archive("Biology");
        inputArchive.setArticles(archiveArticles);

        outputArchive = new Archive();
        outputArchive.setArchiveId(1);
        outputArchive.setArchiveName("Biology");
        outputArchive.setArticles(archiveArticles);

        archives = new ArrayList<>();
        archives.add(outputArchive);
    }

    @Test
    public void shouldCreateANewArchiveToDatabase() {

        when(archiveRepository.save(inputArchive)).thenReturn(outputArchive);

        Archive fromServiceArchive = service.saveArchive(inputArchive);
        assertEquals(fromServiceArchive.getArchiveId(), outputArticle.getArticleId());
    }

    @Test
    public void shouldFindAnArchiveByArchiveIdInTheDatabase() {

        when(archiveRepository.findById(inputArchive.getArchiveId())).thenReturn(Optional.ofNullable(outputArchive));

        Archive fromServiceArchive = service.findArchive(inputArchive);
        assertEquals(fromServiceArchive.getArchiveId(), outputArchive.getArchiveId());
    }

    @Test
    public void shouldReturnAllArchivesInTheDatabase() {

        when(archiveRepository.findAll()).thenReturn(archives);

        List<Archive> fromServiceArchives = archiveRepository.findAll();
        assertEquals(fromServiceArchives.size(), archives.size());
    }

    @Test
    public void shouldUpdateAnArchiveNameInDatabase() {

        Archive updatedArchive = new Archive();
        updatedArchive.setArchiveId(outputArchive.getArchiveId());
        updatedArchive.setArchiveName("Psychology");
        updatedArchive.setArticles(inputArchive.getArticles());

        when(archiveRepository.findById(outputArchive.getArchiveId())).thenReturn(Optional.ofNullable(outputArchive));
        when(archiveRepository.save(updatedArchive)).thenReturn(updatedArchive);

        Archive foundArchive = archiveRepository.findById(outputArchive.getArchiveId()).get();

        Archive fromServiceUpdatedArchive = service.updateArchive(updatedArchive);

        assertEquals(fromServiceUpdatedArchive.getArchiveId(), foundArchive.getArchiveId());
        assertEquals(fromServiceUpdatedArchive.getArticles().size(), foundArchive.getArticles().size());
    }

    @Test
    public void shouldDeleteAnArchiveInTheDatabase() {

        when(archiveRepository.findById(outputArchive.getArchiveId())).thenReturn(Optional.ofNullable(outputArchive));
        doNothing().when(archiveRepository).delete(outputArchive);
        service.deleteArticle(outputArticle);
    }

    @Test
    public void shouldSaveAnArticleToAnArchiveInDatabase() {

        when(articleRepository.findById(inputArticle.getArticleId())).thenReturn(Optional.ofNullable(outputArticle));
        when(articleRepository.save(inputArticle)).thenReturn(outputArticle);

        Article saveArticle = service.saveArticle(inputArticle);
        Article fromServiceArticle = service.findArticle(inputArticle.getArticleId());
        assertEquals(fromServiceArticle.getArticleId(), saveArticle.getArticleId());
    }

    @Test
    public void shouldReturnAnArticleFromTheDatabase() {

        when(articleRepository.findById(inputArticle.getArticleId())).thenReturn(Optional.ofNullable(outputArticle));

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
    public void shouldReturnAllArticlesBelongingToAnArchive() {

        List<Article> archiveArticlesList = new ArrayList<>(Arrays.asList(inputArticle));
        when(articleRepository.findAll()).thenReturn(archiveArticlesList);
        when(archiveRepository.findById(inputArchive.getArchiveId())).thenReturn(Optional.ofNullable(outputArchive));

        List<Article> fromServiceUserArticles = service.findArchiveArticles(outputArchive.getArchiveId());
        assertEquals(fromServiceUserArticles.get(0).getArticleId(), outputArticle.getArticleId());
    }

    @Test
    public void shouldDeleteAnArticleFromTheDatabase() {

        Article articleToDelete = new Article(
                1,
                "Population biology of plants.",
                "https://www.cabdirect.org/cabdirect/abstract/19782321379",
                "The first chapter is concerned with experiments, analogies and models.",
                "JL Harper - Population biology of plants., 1977 - cabdirect.org"
        );

        when(articleRepository.findById(inputArticle.getArticleId())).thenReturn(Optional.ofNullable(articleToDelete));
        doNothing().when(articleRepository).delete(articleToDelete);
        service.deleteArticle(articleToDelete);
    }
}