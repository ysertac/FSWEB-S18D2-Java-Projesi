package com.workintech.repository;

import com.workintech.entity.Fruit;
import com.workintech.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM s18d2.vegetable AS v " +
            "ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM s18d2.vegetable AS v " +
            "ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.isGrownOnTree=:isGrownOnTree AND v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
