package com.dpcs.service;

import java.util.List;

import com.dpcs.dto.MedicineRequest;
import com.dpcs.entity.Medicine;

public interface MedicineService {

    Medicine save(MedicineRequest request);

    List<Medicine> getAll();

    Medicine getById(String id);

    void delete(String id);
    // Search

    List<Medicine> searchByName(String name);

    List<Medicine> searchByGenericName(String genericName);

    List<Medicine> searchByManufacturer(String manufacturer);

    List<Medicine> searchByStrength(String strength);

    List<Medicine> searchByDosageForm(String dosageForm);

    List<Medicine> searchByExactPrice(Double price);

    List<Medicine> searchByMaxPrice(Double price);

    List<Medicine> searchByMinPrice(Double price);

    List<Medicine> searchByPriceRange(Double minPrice, Double maxPrice);

    List<Medicine> searchByExactStock(Integer stock);

    List<Medicine> searchByMinStock(Integer stock);

    List<Medicine> searchByMaxStock(Integer stock);

    List<Medicine> searchActive(Boolean active);

}