package com.matias.Mini.CRM.repository;

import com.matias.Mini.CRM.model.NotaSeguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaSeguimientoRepository extends JpaRepository<NotaSeguimiento,Long> {

}
