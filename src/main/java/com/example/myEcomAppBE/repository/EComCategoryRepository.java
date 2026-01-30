package com.example.myEcomAppBE.repository;

import com.example.myEcomAppBE.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EComCategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
