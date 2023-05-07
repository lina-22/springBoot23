package com.serverSide.javaSpringBoot.services.securityService;

import com.serverSide.javaSpringBoot.exception.BaseException;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUserDetails userDetails = getUserDetails(email);
        if (ObjectUtils.isEmpty(userDetails)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid username or password");
        }
        return userDetails;
    }

    private AppUserDetails getUserDetails(String email){
        UserModel user = usersRepository.findByEmail(email);

        if (ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid username or password.");
        }
        List<RolesModel> rolesModels = Arrays.asList(user.getRolesModel());
        return new AppUserDetails(
                user.getEmail(),
                user.getPassword(),
                rolesModels.stream().map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList())
        );
    }
}
