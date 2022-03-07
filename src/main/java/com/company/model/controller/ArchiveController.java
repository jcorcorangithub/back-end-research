package com.company.model.controller;

import com.company.model.Archive;
import com.company.model.ArchiveArticle;
import com.company.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveController {

    @Autowired
    private ArchiveRepository archiveRepository;

    @PostMapping("/archive") // create new archive
    public Archive createArchive(@RequestBody Archive archive) {
        archiveRepository.save(archive);
        return archive;
    }

    @GetMapping("/archive")
    public List<Archive> getAllArchives() {
        return archiveRepository.findAll();
    }
}
