package com.sara.security.service;

import com.sara.security.repository.User;
import com.sara.security.repository.UserPrincipal;
import com.sara.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return new User("superuser", "superuser", AuthorityUtils.createAuthorityList("ROLE_USER"));

        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user 404 - not found!");
        }
        //System.out.println("user found" + user.getUsername());
        return new UserPrincipal(user);
    }
}
