package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "member")
public class Member {
    private String memberId;
    private int archiveId;
    private String memberFname;
    private String memberLname;

    public Member(String memberId, int archiveId, String memberFname, String memberLname) {
        this.memberId = memberId;
        this.archiveId = archiveId;
        this.memberFname = memberFname;
        this.memberLname = memberLname;
    }
    public Member(){}

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

    public String getMemberFname() {
        return memberFname;
    }

    public void setMemberFname(String memberFname) {
        this.memberFname = memberFname;
    }

    public String getMemberLname() {
        return memberLname;
    }

    public void setMemberLname(String memberLname) {
        this.memberLname = memberLname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return archiveId == member.archiveId && Objects.equals(memberId, member.memberId) && Objects.equals(memberFname, member.memberFname) && Objects.equals(memberLname, member.memberLname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, archiveId, memberFname, memberLname);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", archiveId=" + archiveId +
                ", memberFname='" + memberFname + '\'' +
                ", memberLname='" + memberLname + '\'' +
                '}';
    }
}
