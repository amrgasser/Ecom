package org.example.Store.Services;

import lombok.AllArgsConstructor;
import org.example.Store.Models.Category;
import org.example.Store.Repositories.CategoryRepository;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService extends AbstractService<Category, Long>{
    public final CategoryRepository categoryRepository;

    @Override
    public JpaRepository<Category, Long> getRepository(){
        return categoryRepository;
    }
    public List<Category> findAllSubCategories(Long id) {
        Category parent = categoryRepository.findById(id).get();

        return categoryRepository.findAllByParentCategoryId(parent);
    }
    public Category store(Category category){
        // check if one exists
        Category check = categoryRepository.findByName(category.getName());
        if(check != null){
            throw new DuplicateKeyException("Category already exists");
        }

        return categoryRepository.save(category);
    }
}
