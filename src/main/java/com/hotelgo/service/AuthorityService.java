package com.hotelgo.service;


import com.hotelgo.domain.Authority;
import com.hotelgo.domain.User;
import com.hotelgo.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class AuthorityService {
    @Autowired
    public AuthorityRepository authorityRepository;
//    @Transactional
//    public List<Authority> findAll(){
//        List<Authority> list = Lists.newArrayList(authorityRepository.findAll());
//        return list;
//    }
//
//
//    public Authority findById(Long id){
//        Optional<Authority> option = authorityRepository.findById(id);
//        Authority authority = option.get();
//        return authority;
//    }

    @Transactional
    public List<Authority> findByUserId(Long id) {

        List<Authority> authorities = authorityRepository.findByUserId(id);

        return authorities;

    }



    public Authority addAuthority(User user, Authority authority){


        authority.setUser(user);
        authority = authorityRepository.save(authority);


        return  authority;

    }






}
