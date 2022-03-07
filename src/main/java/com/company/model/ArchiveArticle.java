package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "archive_archive")
public class ArchiveArticle {
    private int articleArchiveId;
    private String articleId;
    private int archiveId;

    public ArchiveArticle(int articleArchiveId, String articleId, int archiveId) {
        this.articleArchiveId = articleArchiveId;
        this.articleId = articleId;
        this.archiveId = archiveId;
    }
    public ArchiveArticle(){}

    public int getArticleArchiveId() {
        return articleArchiveId;
    }

    public void setArticleArchiveId(int articleArchiveId) {
        this.articleArchiveId = articleArchiveId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveArticle that = (ArchiveArticle) o;
        return articleArchiveId == that.articleArchiveId && archiveId == that.archiveId && Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleArchiveId, articleId, archiveId);
    }

    @Override
    public String toString() {
        return "ArchiveArticle{" +
                "articleArchiveId=" + articleArchiveId +
                ", articleId='" + articleId + '\'' +
                ", archiveId=" + archiveId +
                '}';
    }
}


