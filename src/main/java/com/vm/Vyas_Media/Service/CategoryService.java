package com.vm.Vyas_Media.Service;

import java.util.List;

import com.vm.Vyas_Media.Entity.Category;

public interface CategoryService {

	List<Category> searchCategories(String query);

	Category createCategory(Category category);
}