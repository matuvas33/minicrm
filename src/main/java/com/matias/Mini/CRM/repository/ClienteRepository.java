package com.matias.Mini.CRM.repository;

import com.matias.Mini.CRM.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
        boolean existsByEmail (String email);
        List<Cliente> findByActivoTrue();
}
