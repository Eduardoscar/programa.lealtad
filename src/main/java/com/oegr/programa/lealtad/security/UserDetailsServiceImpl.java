package com.oegr.programa.lealtad.security;

import com.oegr.programa.lealtad.entity.User;
import com.oegr.programa.lealtad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("entre?");
        User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El correo no se encontro"));
        System.out.println("loadUSerBYUSERNAME"+user);
        return new UserDetailsImpl(user);
    }
}
