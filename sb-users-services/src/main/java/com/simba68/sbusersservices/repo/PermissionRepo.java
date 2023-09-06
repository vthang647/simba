package com.simba68.sbusersservices.repo;

import com.simba68.sbusersservices.entity.Permission;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
}
