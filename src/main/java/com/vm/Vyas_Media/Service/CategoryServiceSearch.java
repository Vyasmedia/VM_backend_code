package com.vm.Vyas_Media.Service;

import java.util.List;

import com.vm.Vyas_Media.Entity.CategorySearch;

public interface CategoryServiceSearch {

	List<CategorySearch> searchCategories(String query);

	CategorySearch createCategory(CategorySearch category);
}