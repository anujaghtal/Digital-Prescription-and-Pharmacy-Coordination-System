package com.dpcs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpcs.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,String>{

    boolean existsByName(String name);

    Optional<Medicine> findByName(String name);
    List<Medicine> findByNameContainingIgnoreCase(String name);

    List<Medicine> findByGenericNameContainingIgnoreCase(String genericName);

    List<Medicine> findByManufacturerContainingIgnoreCase(String manufacturer);

    List<Medicine> findByStrengthIgnoreCase(String strength);

    List<Medicine> findByDosageFormIgnoreCase(String dosageForm);

    List<Medicine> findByPrice(Double price);

    List<Medicine> findByPriceLessThanEqual(Double price);

    List<Medicine> findByPriceGreaterThanEqual(Double price);

    List<Medicine> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Medicine> findByStockQuantity(Integer stockQuantity);

    List<Medicine> findByStockQuantityLessThanEqual(Integer stockQuantity);

    List<Medicine> findByStockQuantityGreaterThanEqual(Integer stockQuantity);

    List<Medicine> findByActive(Boolean active);
}