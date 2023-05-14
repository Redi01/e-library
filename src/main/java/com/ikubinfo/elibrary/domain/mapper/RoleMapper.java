/*package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.user.RoleDTO;
import com.ikubinfo.elibrary.domain.entity.RoleUI;
import com.ikubinfo.elibrary.repository.RoleRepository;
import com.ikubinfo.elibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private static RoleRepository roleRepository;

    @Autowired
    private RoleMapper(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public static RoleUI toEntity(RoleDTO r){
        return RoleUI.builder()
                .userRole(r.getRole())
                .readStatus(r.isRead())
                .updateStatus(r.isUpdate())
                .build();
    }

    public static RoleDTO toDto(RoleUI r){
        return RoleDTO.builder()
                .role(r.getUserRole())
                .read(r.isReadStatus())
                .update(r.isUpdateStatus())
                .create(r.isCreateStatus())
                .build();
    }

    public static RoleUI buildUpdateUserRole(RoleUI roleUI, RoleDTO roleDTO){
        roleUI.setUserRole(roleDTO.getRole());
        return roleUI;
    }
}*/
