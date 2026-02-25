package com.example.myEcomAppBE.repository;

import com.example.myEcomAppBE.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EComProductsRepository extends JpaRepository<ProductEntity, Long> {

//    @Query("SELECT p FROM ProductEntity p WHERE p.price <= :upperLimit")
//    List<ProductEntity> findByPriceLessThanEqual(@Param("upperLimit") int upperLimit);

    @Query(value = "SELECT * FROM product_entity WHERE price <= :upperLimit", nativeQuery = true)
    List<ProductEntity> findByPriceLessThanEqual(@Param("upperLimit") int upperLimit);
}

//Demo query: SELECT * FROM product_entity WHERE match(title, description) AGAINST (:keyword)
//to search for products based on keywords in title and description.
