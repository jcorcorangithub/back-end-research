package com.company.repository;

import com.company.model.Archive;
import com.company.model.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchiveRepositoryTests {

    @Autowired
    ArchiveRepository archiveRepository;

    private Archive inputArchive;
    private Archive outputArchive;
    private List<Archive> archives;

    //  Setup Tests for Archive Repository
    @Before
    public void setUp() {
        archiveRepository.deleteAll();

    //  Instantiate new Archive objects
        inputArchive = new Archive("Biology");
        outputArchive = new Archive();
        outputArchive.setArchiveId(inputArchive.getArchiveId());
        outputArchive.setArchiveName("Biology");

    //  Instantiate new List of archives
        archives = new ArrayList<>();
        archives.add(inputArchive);
    }

    //    Archive repository test cases
    @Test
    public void shouldInsertArchiveIntoArchiveTable() {

        Archive fromArchiveRepository = archiveRepository.save(inputArchive);
        assertEquals(outputArchive.getArchiveName(), fromArchiveRepository.getArchiveName());
    }

    @Test
    public void shouldFindArchiveByArchiveId() {

        archiveRepository.save(inputArchive);
        Optional<Archive> fromArchiveRepository = archiveRepository.findById(inputArchive.getArchiveId());
        assertEquals(inputArchive.getArchiveId(), fromArchiveRepository.get().getArchiveId());
    }

    @Test
    public void shouldFindAllArchives() {

        archiveRepository.save(inputArchive);
        List<Archive> fromArchiveRepository = archiveRepository.findAll();
        assertEquals(archives.size(), fromArchiveRepository.size());
    }

    


}
