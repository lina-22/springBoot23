package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import com.serverSide.javaSpringBoot.services.UsersService;
import com.serverSide.javaSpringBoot.services.securityService.UsersSecurityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
//class UsersManagerTest {
//
//    @Mock
//    private UsersService usersService;
//    @Mock
//    private UsersSecurityService usersSecurityService;
//    @Mock
//    private RolesService rolesService;
//    @Mock
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UsersManager underTest;
//
//
//    @Test
//    void shouldRegisterUser() {
//        //given -
//        UserDto userDtoToRegister = new UserDto(1L, "test name", "test name", "test@mail.com", "password", "ADMIN");
//        RolesModel rolesModel = new RolesModel(1L, "ADMIN", null);
//
//        BaseResponseDto baseResponseDto = new BaseResponseDto("201", "Created");
//
//
//
//        when(rolesService.findByName("ADMIN")).thenReturn(rolesModel);
//        UserModel userModel = new UserModel(1L, "test name", "test name", "test@mail.com", "password", rolesModel);
//        when(underTest.toUserModel(userDtoToRegister)).thenReturn(userModel);
//        when(usersSecurityService.register(userModel)).thenReturn(baseResponseDto);
//
//        //when -
//        underTest.registerUser(userDtoToRegister);
//
//        //then -
//        assertThat(baseResponseDto).isNotNull();
//        assertEquals(baseResponseDto.getCode(), "201");
//    }
//
//    @Test
//    void createUser() {
//    }
//
//    @Test
//    void shouldGetUsersById() {
//        //give -
//        long id = 1;
//        UserDto userDto = new UserDto(1L, "test name", "test name", "test@mail.com", "password", "ADMIN");
//        RolesModel rolesModel = new RolesModel(1L, "ADMIN", null);
//        Optional<UserModel> userModel = Optional.of(new UserModel(1L, "test name", "test name", "test@mail.com", "password", rolesModel));
//        //when -
//        when(usersService.findById(1)).thenReturn(userModel);
//        when(underTest.getUsersById(1)).thenReturn(userDto);
//
//        //then -
//        assertThat(userDto).isNotNull();
//        assertEquals(userDto.getRole(), "ADMIN");
//    }
//
//    @Test
//    void updateUsers() {
//    }
//
//    @Test
//    void toUserModel() {
//    }
//
//    @Test
//    void toUsersDto() {
//    }
//}