package lucas.com.developer.web.resource;

import lucas.com.developer.web.entities.Category;
import lucas.com.developer.web.repositorie.CategoryRepository;
import lucas.com.developer.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.getAllCategory();
        return ResponseEntity.ok().body(categories);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        var category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

}
