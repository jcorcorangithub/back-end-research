package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String articleId;
    private String username;
    private String title;
    private String link;
    private String snippet;
    private String summary;

    public Article(String articleId, String username, String title, String link, String snippet, String summary) {
        this.articleId = articleId;
        this.username = username;
        this.title = title;
        this.link = link;
        this.snippet = snippet;
        this.summary = summary;
    }
    public Article(){};

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleId, article.articleId) && Objects.equals(username, article.username) && Objects.equals(title, article.title) && Objects.equals(link, article.link) && Objects.equals(snippet, article.snippet) && Objects.equals(summary, article.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, username, title, link, snippet, summary);
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", snippet='" + snippet + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
