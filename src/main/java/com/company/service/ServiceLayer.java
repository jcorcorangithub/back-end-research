package com.company.service;

import com.company.model.Archive;
import com.company.model.Article;
import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {
    private ArchiveRepository archiveRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public ServiceLayer( ArchiveRepository archiveRepository, ArticleRepository articleRepository) {
        this.archiveRepository = archiveRepository;
        this.articleRepository = articleRepository;
    }

    //    Archive ServiceLayer Tests
    public Archive saveArchive(Archive archive) {
        return archiveRepository.save(archive);
    }

    public Archive findArchive(Archive archive) {

        Archive foundArchive = archiveRepository.findById(archive.getArchiveId()).get();

        if(foundArchive.getArchiveName() == null) {
            throw new IllegalArgumentException("Archive does not exist in the database.");
        }

        return foundArchive;
    }

    public List<Archive> findAllArchives() {
        return archiveRepository.findAll();
    }

    public Archive updateArchive(Archive archive) {
        // look for archive in db
        Archive foundArchive = archiveRepository.findById(archive.getArchiveId()).get();

        if(foundArchive.getArchiveName() == null) {
            throw new IllegalArgumentException("The archive does not exist in the database.");
        }

        foundArchive.setArchiveId(archive.getArchiveId());
        foundArchive.setArchiveName(archive.getArchiveName());
        foundArchive.setArticles(archive.getArticles());
        return archiveRepository.save(foundArchive);
    }

    public void deleteArchive(Archive archive) {

        Archive foundArchive = archiveRepository.findById(archive.getArchiveId()).get();

        if(foundArchive.getArchiveName() == null) {
            throw new IllegalArgumentException("Archive does not exist in the database.");
        }

        archiveRepository.delete(archive);
        System.out.println("Deleted the archive " + archive.getArchiveName());
    }

    public Article saveArticle(Article article) {

        return articleRepository.save(article);
    }

    public Article findArticle(int id) {

        Article foundArticle = articleRepository.findById(id).get();
        return foundArticle;
    }

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> findArchiveArticles(int archiveId) {

        Archive foundArchive = archiveRepository.findById(archiveId).get();

        if (foundArchive.getArchiveName() == null) {
            throw new IllegalArgumentException("Archive does not exist in the database");
        }

        List<Article> articleList = articleRepository.findAllArticlesByArchive(archiveId);

        return articleList;
    }

    public void deleteArticle(Article article) {

        Article foundArticle = articleRepository.findById(article.getArticleId()).get();

        if (foundArticle.getTitle() == null) {
            throw new IllegalArgumentException("Cannot delete, article does not exist in database.");
        }

        articleRepository.delete(foundArticle);
    }
}
