package com.serverSide.javaSpringBoot.config.filter;

import com.serverSide.javaSpringBoot.exception.BaseException;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Start actual authentication");
        final String email = authentication.getName();

        final String password = authentication.getCredentials().toString();

        UserModel userModel;
        try {
            userModel = usersRepository.findByEmail(email);
        }catch (Exception e){
            throw new BaseException(String.valueOf(HttpStatus.UNAUTHORIZED.value()), "User's not found");
        }
        //List<RolesModel>rolesModels = Arrays.asList(userModel.getRolesModel());
        List<RolesModel> rolesModels = new ArrayList<>(userModel.getRolesModelSet());
        final List<GrantedAuthority> authorities = getAuthorities(rolesModels.stream().toList());
        System.out.println("test here ***********:" + authorities);
        final Authentication auth = new UsernamePasswordAuthenticationToken(email, password, authorities);

        log.info("End actual authentication");
        return auth;
    }

    private List<GrantedAuthority> getAuthorities(List<RolesModel> roles) {
        List<GrantedAuthority> result = new ArrayList<>();
        Set<String> permissions = new HashSet<>();

        if(!ObjectUtils.isEmpty(roles)){
            roles.forEach( r-> {
                permissions.add(r.getName());
            });
        }

        permissions.forEach(p->{
            result.add(new SimpleGrantedAuthority(p));
        });
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}