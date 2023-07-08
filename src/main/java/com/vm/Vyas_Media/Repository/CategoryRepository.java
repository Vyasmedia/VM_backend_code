package com.vm.Vyas_Media.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vm.Vyas_Media.Entity.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE " +
            "c.name LIKE CONCAT('%',:query, '%')" +
            "Or c.description LIKE CONCAT('%', :query, '%')")
    List<Category> searchCategories(String query);
}