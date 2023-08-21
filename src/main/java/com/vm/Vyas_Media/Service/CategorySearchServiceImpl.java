package com.vm.Vyas_Media.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.CategorySearch;
import com.vm.Vyas_Media.Repository.CategoryRepository;

@Service
public class CategorySearchServiceImpl implements CategoryServiceSearch {

    private CategoryRepository categoryRepository;

    public CategorySearchServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySearch> searchCategories(String query) {
        List<CategorySearch> cate = categoryRepository.searchCategories(query);
        return cate;
    }

    @Override
    public CategorySearch createCategory(CategorySearch category) {
        return categoryRepository.save(category);
    }

}