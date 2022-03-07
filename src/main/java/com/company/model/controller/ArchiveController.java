package com.company.model.controller;

import com.company.model.Archive;
import com.company.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArchiveController {

    @Autowired
    private ArchiveRepository archiveRepository;

    @PostMapping("/archive") // create new archive
    public Archive createArchive(@RequestBody Archive archive) {
        archiveRepository.save(archive);
        return archive;
    }

    @GetMapping("/archive") // find all archives
    public List<Archive> getAllArchives() {
        return archiveRepository.findAll();
    }

    @GetMapping("/archive/{archiveId}") // find archive by id
    public Archive getArchive(@PathVariable int archiveId) {
        Optional<Archive> archive = archiveRepository.findById(archiveId);

        if(!archive.isPresent()) {
            return null;
        }
        return archive.get();
        }


    @PutMapping("/archive/{archiveId}") // update archive by id
    public Archive updateArchiveById(@RequestBody Archive archive, @PathVariable int archiveId) {
        Optional<Archive> foundArchive = archiveRepository.findById(archive.getArchiveId());

        if (archive.getArchiveId() != foundArchive.get().getArchiveId()) {
            throw new IllegalArgumentException("Archive ID must match parameter given!");
        }
        foundArchive.get().setArchiveId(archive.getArchiveId());
        foundArchive.get().setUsername(archive.getUsername());
        foundArchive.get().setArchiveName(archive.getArchiveName());
        return archiveRepository.save(foundArchive.get());
    }

    @DeleteMapping("/archive/{id}")
    public void deleteArchive(@PathVariable int archiveID) {
        archiveRepository.deleteById(archiveID);
    }
}
