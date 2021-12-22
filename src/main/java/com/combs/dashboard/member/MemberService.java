package com.combs.dashboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public ResponseEntity<List<Member>> getMembers(){
        try{
            return new ResponseEntity<>(new ArrayList<>(memberRepository.findAll()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Member> addMember(Member member) {
        try {
            return new ResponseEntity<>(memberRepository.save(member), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> removeMember(String memberId) {
        try {
            memberRepository.deleteById(memberId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Member> updateMember(Member member) {

        Optional<Member> memberCurrent = memberRepository.findById(member.getMemberId());

        if(memberCurrent.isPresent()){
            try {
                Member memberNew = memberCurrent.get();
                memberNew.setFirstName(member.getFirstName());
                memberNew.setLastName(member.getLastName());
                return new ResponseEntity<>(memberRepository.save(memberNew), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
