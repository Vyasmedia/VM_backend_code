package com.vm.Vyas_Media.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.Category;
import com.vm.Vyas_Media.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> searchCategories(String query) {
        List<Category> cate = categoryRepository.searchCategories(query);
        return cate;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

}