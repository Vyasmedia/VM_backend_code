package com.vm.Vyas_Media.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vm.Vyas_Media.Entity.CategorySearch;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategorySearch, Integer> {

    @Query("SELECT c FROM CategorySearch c WHERE " +
            "c.headline LIKE CONCAT('%',:query, '%')" +
            "Or c.description LIKE CONCAT('%', :query, '%')")
    List<CategorySearch> searchCategories(String query);
}