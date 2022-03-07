package com.company.service;

import com.company.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
}
