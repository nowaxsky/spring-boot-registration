package org.cpm.zwl.dao.persistence;

import org.cpm.zwl.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
