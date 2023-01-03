package com.example.backend.REPO;

import com.example.backend.entity.Employment;
import com.example.backend.mapping.WithoutContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<WithoutContent> findAllBy();
    List<WithoutContent> findAllByCompany_NameLike(String keyword);

    List<WithoutContent> findAllByStackLike(String keyword);

}
