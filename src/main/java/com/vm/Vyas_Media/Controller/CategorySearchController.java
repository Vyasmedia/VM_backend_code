package com.vm.Vyas_Media.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.vm.Vyas_Media.Entity.CategorySearch;
import com.vm.Vyas_Media.Entity.JsonRequest;
import com.vm.Vyas_Media.Service.CategoryServiceSearch;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class CategorySearchController {

    private CategoryServiceSearch categoryService;

    public CategorySearchController(CategoryServiceSearch categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/search")
    public ResponseEntity<List<CategorySearch>> searchCategories(@RequestParam("query") String query){
        return ResponseEntity.ok(categoryService.searchCategories(query));
    }

    @PostMapping("/categories")
    public CategorySearch createCategory(@RequestBody CategorySearch category){
        return categoryService.createCategory(category);
    }
	
    
    /*
	 * @PostMapping("/uploadFile") public ResponseEntity<String>
	 * handleFileUpload(@RequestParam("file") MultipartFile file){ return
	 * ResponseEntity.ok().body("file received successfully"); }
	 * 
	 * @PostMapping("/uploadJson") public ResponseEntity<String>
	 * handleJsonInput(@RequestBody JsonRequest json){ return
	 * ResponseEntity.ok().body(json.getId()+json.getName()); }
	 * 
	 * @PostMapping("/uploadJsonAndMultipartData") public ResponseEntity<String>
	 * handleJsonAndMultipartInput(@RequestPart("data") JsonRequest
	 * json, @RequestPart("file") MultipartFile file) { return ResponseEntity.ok()
	 * .body(json.getId() + json.getName()); }
	 */
    
}