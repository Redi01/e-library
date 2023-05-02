package com.ikubinfo.elibrary.repository;

import com.ikubinfo.elibrary.domain.entity.RoleUI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleUI, Long> {
}
