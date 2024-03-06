package org.company.planeticketbooking.repository;

import org.company.planeticketbooking.domain.ERole;
import org.company.planeticketbooking.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
