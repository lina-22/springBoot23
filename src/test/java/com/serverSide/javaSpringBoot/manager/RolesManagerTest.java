package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class RolesManagerTest {

    @Mock
    private RolesService rolesService;

    @Mock
    private RolesManager rolesManager;

    @InjectMocks
    private RolesManager underTest;

    @Test
    void createRoles() {
        //given -
        RolesDto rolesDto = new RolesDto(1, "ADMIN");
        RolesModel rolesModel = new RolesModel(1, "ADMIN", null);

        given(rolesManager.toRolesDto(rolesModel)).willReturn(rolesDto);
        given(rolesManager.toRolesModel(rolesDto)).willReturn(rolesModel);

        given(rolesService.create(rolesModel)).willReturn(rolesModel);

        //when -
        RolesDto newRolesDto = underTest.createRoles(rolesDto);

        //then -
        assertThat(newRolesDto).isNotNull();
        assertEquals(newRolesDto.getName(), "ADMIN");
    }

    @Test
    void getAllRoles() {
    }

    @Test
    void getRoleById() {


        //then -
    }

    @Test
    void updateRoles() {
    }

    @Test
    void deleteRoleById() {
    }

    @Test
    void toRolesModel() {
    }

    @Test
    void toRolesDto() {
    }
}