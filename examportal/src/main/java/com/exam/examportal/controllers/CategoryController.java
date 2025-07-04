package com.exam.examportal.controllers;


import com.exam.examportal.models.exam.Category;
import com.exam.examportal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add Category
    @PostMapping(path = "/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){

        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //Get Single Category

    @GetMapping(path = "/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }


    //get all categories

    @GetMapping(path = "/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }


    //update category
    @PutMapping(path = "/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping(path = "/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

}
