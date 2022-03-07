package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "archive")
public class Archive {
    private int archiveId;
    private String username;
    private String archiveName;

    public Archive(int archiveId, String username, String archiveName) {
        this.archiveId = archiveId;
        this.username = username;
        this.archiveName = archiveName;
    }
    public Archive(){}

    public int getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(int archiveId) {
        this.archiveId = archiveId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archive archive = (Archive) o;
        return archiveId == archive.archiveId && Objects.equals(username, archive.username) && Objects.equals(archiveName, archive.archiveName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archiveId, username, archiveName);
    }

    @Override
    public String toString() {
        return "Archive{" +
                "archiveId=" + archiveId +
                ", username='" + username + '\'' +
                ", archiveName='" + archiveName + '\'' +
                '}';
    }
    //comment
}
