package com.example.camplex.domain.camp.repository;

import com.example.camplex.domain.camp.entity.Camp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {

}
