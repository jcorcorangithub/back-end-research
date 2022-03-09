//package com.company.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Objects;
//
//@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
<<<<<<< HEAD
//@Table(name = "member")
//
=======
////@Table(name = "member")
>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
//public class Member extends User {
//
//    @Id@GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "member_id")
//    private Integer id;
//    private User user;
//    private int archiveId;
//
//    public Member() { }
//
//    public Member(User user, int archiveId) {
//        this.user = user;
//        this.archiveId = archiveId;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public int getArchiveId() {
//        return archiveId;
//    }
//
//    public void setArchiveId(int archiveId) {
//        this.archiveId = archiveId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Member member = (Member) o;
//        return archiveId == member.archiveId && Objects.equals(id, member.id) && Objects.equals(user, member.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), id, user, archiveId);
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", user=" + user +
//                ", archiveId=" + archiveId +
//                '}';
//    }
//}
