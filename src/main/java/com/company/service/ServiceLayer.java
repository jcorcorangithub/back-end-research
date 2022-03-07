package com.company.service;

import com.company.model.Archive;
import com.company.model.User;
import com.company.repository.*;
import com.company.viewmodel.ArchiveViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component
public class ServiceLayer {
    private ArchiveRepository archiveRepository;
    private ArticleRepository articleRepository;
    private MemberRepository memberRepository;
    private UserRepository userRepository;

    @Autowired
    public ServiceLayer(
            ArchiveRepository archiveRepository,
            ArticleRepository articleRepository,
            MemberRepository memberRepository,
            UserRepository userRepository) {
        this.archiveRepository = archiveRepository;
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User findUser(String username) {

        User foundUser = userRepository.findByUsername(username);
        return foundUser;
    }
}
