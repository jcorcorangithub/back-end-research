//package com.company.controller;
//
//
<<<<<<< HEAD
////import com.company.model.Member;
////import com.company.repository.MemberRepository;
=======
//import com.company.model.Member;
//import com.company.repository.MemberRepository;
>>>>>>> b8bce71aa09de58212bfb6a6735dfb3c67186678
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class MemberController {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @PostMapping("/member")
//    public Member createMember (@RequestBody Member member) {
//        memberRepository.save(member);
//        return member;
//    }
//
//    @GetMapping("/member")
//    public List<Member> getAllMember() {
//        return memberRepository.findAll();
//    }
//
//    @GetMapping("/member/{id}")
//    public Member getMemberById(@PathVariable int id) {
//        Optional<Member> member = memberRepository.findById(id);
//
//        return member.orElse(null);
//    }
//
//    @DeleteMapping("/member/{id}")
//    public void deleteMember(@PathVariable int id) {
//        memberRepository.deleteById(id);
//    }
//}
