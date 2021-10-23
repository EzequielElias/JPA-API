package com.edev.jpaapi.JPAAPI.Repositories;

import com.edev.jpaapi.JPAAPI.Entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
