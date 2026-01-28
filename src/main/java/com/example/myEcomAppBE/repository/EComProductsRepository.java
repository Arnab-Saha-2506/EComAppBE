package com.example.myEcomAppBE.repository;

import com.example.myEcomAppBE.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EComProductsRepository extends JpaRepository<ProductEntity, Long> {

}
