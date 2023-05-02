package com.ikubinfo.elibrary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleUI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userRole;
    private boolean readStatus;
    private boolean createStatus;
    private boolean updateStatus;

}
