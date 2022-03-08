package com.company.repository;

import com.company.model.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchiveRepositoryTests {

    @Autowired
    ArchiveRepository archiveRepository;

    private Archive archive;
    private Archive archive2;


    @Before
    public void setUp() {
        archiveRepository.deleteAll();

        archive.setArchiveName("Test");
        archive.setUsername("Tester");

        archive2.setArchiveName("Mock");
        archive2.setUsername("Mocker");
    }

    @Test
    public void shouldAddAndGetArchiveByArchiveIdFromDatabase() {

        archive = archiveRepository.save(archive);

        Archive fromRepo = archiveRepository.findById(archive.getArchiveId()).get();
        assertEquals(archive, fromRepo);
    }

    @Test
    public void shouldUpdateArchive() {
        archiveRepository.save(archive2);
        archive.setArchiveId(1);
        archive2.setArchiveName("Mock update");
        archive2.setUsername("Mocker update");
        archive = archiveRepository.save(archive2);
    }

    @Test
    public void shouldDeleteArchive() {
    }
}