package com.workandtravel.workandtravelilwl.repository;

import com.workandtravel.workandtravelilwl.model.Favor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorRepository extends JpaRepository<Favor, Long> {
}
