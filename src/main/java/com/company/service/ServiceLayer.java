package com.company.service;

import com.company.model.Archive;
import com.company.repository.*;
import com.company.viewmodel.ArchiveViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//@Service
@Component
public class ServiceLayer {
    private ArchiveRepository archiveRepository;
    private ArchiveArticleRepository archiveArticleRepository;
    private ArticleRepository articleRepository;
    private MemberRepository memberRepository;
    private UserRepository userRepository;

    @Autowired
    public ServiceLayer(ArchiveRepository archiveRepository,
                        ArchiveArticleRepository archiveArticleRepository,
                        ArticleRepository articleRepository,
                        MemberRepository memberRepository,
                        UserRepository userRepository) {
        this.archiveRepository = archiveRepository;
        this.archiveArticleRepository = archiveArticleRepository;
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }
    // int id - represents the archives id
    // string title
    // user object associated with it
    // list of article objects associated
    // will have an empty array list for articles
    // will have an empty array list for members
//    @Transactional
//    public ArchiveViewModel createArchive(ArchiveViewModel viewModel){
//        Archive archive = new Archive();
//        archive.setArchiveId(43);
//
//    }
}
