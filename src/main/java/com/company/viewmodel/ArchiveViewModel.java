package com.company.viewmodel;

import com.company.model.Article;
//import com.company.model.Member;
import com.company.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArchiveViewModel {

    private int id;
    private String title;
    private User user;
    private List<Article> articles = new ArrayList<>();
//    private List<Member> members = new ArrayList<>();

    public ArchiveViewModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveViewModel that = (ArchiveViewModel) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(user, that.user) && Objects.equals(articles, that.articles) ; // && Objects.equals(members, that.members)
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, user, articles);
    }

    @Override
    public String toString() {
        return "ArchiveViewModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", articles=" + articles +
              //  ", members=" + members +
                '}';
    }
}
