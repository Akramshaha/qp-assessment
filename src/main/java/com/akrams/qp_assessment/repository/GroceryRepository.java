package com.akrams.qp_assessment.repository;

import com.akrams.qp_assessment.model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

    Optional<Grocery> findById(Integer id);
    void deleteById(Integer id);
}
