package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "member")
public class Member extends User {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private User user;
    private int archiveId;


    public Member(String username, String firstName, String lastName, String email, String password, Integer id, User user, int archiveId) {
        super(username, firstName, lastName, email, password);
        this.id = id;
        this.user = user;
        this.archiveId = archiveId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!super.equals(o)) return false;
        Member member = (Member) o;
        return archiveId == member.archiveId && Objects.equals(id, member.id) && Objects.equals(user, member.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, user, archiveId);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", user=" + user +
                ", archiveId=" + archiveId +
                '}';
    }
}
