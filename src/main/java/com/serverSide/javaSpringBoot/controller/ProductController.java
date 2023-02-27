package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ProductManager;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;

import com.serverSide.javaSpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    ProductService mProductService;

    @PostMapping("create")
    ResponseEntity<?> create(@RequestBody ProductDto dto) {
        MessageResponse validation = ProductManager.validation(dto);
        if (!validation.isSuccess()) {
            return ResponseEntity.badRequest().body(validation);
        } else {
            ProductModel productModel = new ProductModel();
            productModel.setName(dto.getName());
            productModel.setIs_featured(dto.isIs_featured());
            productModel.setPrice(dto.getPrice());
            productModel.setDiscount(dto.getDiscount());
            productModel.setDescription(dto.getDescription());
            if (!dto.getImage().isEmpty()) {
                productModel.setImage(dto.getImage());
            }
            Optional<CategoryModel> isValidCategory = mProductService.isValidCategory(dto.getCategoryId());

            isValidCategory.ifPresent((categoryModel -> {
                productModel.addCategory(categoryModel);
            }));
            if(isValidCategory.isPresent()){
                ProductModel isSaved = mProductService.insert(productModel);
                return ResponseEntity.ok(isSaved);
            }else{
                validation.setSuccess(false);
                validation.setMessage("Category Id not found.");
                return  ResponseEntity.badRequest().body(validation);
            }
        }
    }

    @GetMapping("showOne")
//url/showOne?id=1
    ResponseEntity<?> showOne(@RequestParam Long id) {
        MessageResponse validation = ProductManager.readValidation(String.valueOf(id));
        if (!validation.isSuccess()) {
            return ResponseEntity.badRequest().body(validation);
        }
        return ResponseEntity.ok(mProductService.findById(id));
    }

    @GetMapping("showAll")
    ResponseEntity<?> showAll() {
        return ResponseEntity.ok(mProductService.findAll());//[]
    }


    @PutMapping("update")
    ResponseEntity<?> update(@RequestBody ProductDto dto) {


        MessageResponse validation = ProductManager.updatedValidation(dto);
        if (!validation.isSuccess()) {
            return ResponseEntity.badRequest().body(validation);
        } else {
            ProductModel productModel = new ProductModel();
            Optional<ProductModel> productData = mProductService.findById(dto.getId());
            productData.ifPresentOrElse((model) -> {
                //(model)
                productModel.addModel(model.getId(), model.getName(), model.isIs_featured(), model.getPrice(),
                        model.getDiscount(), model.getImage(), model.getDescription(), "");

                // for update every field have to be checked, eitgher there have value or not?
                if (!dto.getName().isEmpty()) {
                    productModel.setName(dto.getName());
                }
                if (!dto.isIs_featured()) {
                    productModel.setIs_featured(dto.isIs_featured());
                }
                if (dto.getPrice() > 0.0) {
                    productModel.setPrice(dto.getPrice());
                }
                if (dto.getDiscount() > 0.0) {
                    productModel.setDiscount(dto.getDiscount());
                }
                if (!dto.getImage().isEmpty()) {
                    productModel.setImage(dto.getImage());
                }
                if (!dto.getDescription().isEmpty()) {
                    productModel.setDescription(dto.getDescription());
                }

                if (!dto.getCategoryId().isEmpty()) {
                    mProductService.isValidCategory(dto.getCategoryId()).ifPresent(productModel::addCategory);
                }

                ProductModel isSaved = mProductService.update(productModel);

            }, () -> { // if there don't have any value then it will be empty
                validation.setSuccess(true); // true.....
                validation.setMessage("Product id not found");
            });

            if (productData.isPresent()) {
                return ResponseEntity.ok(productModel);
            } else {
                return ResponseEntity.badRequest().body(validation);
            }
        }
    }

    @DeleteMapping("delete")
    ResponseEntity<?> delete(@RequestParam Long id) {
        MessageResponse validation = ProductManager.deleteValidation(id);
        if (!validation.isSuccess()) {
            return ResponseEntity.badRequest().body(validation);
        } else {
            //Optional<ProductModel> productModel = mProductService.findById(id);

            mProductService.delete(id);
            return ResponseEntity.ok(new MessageResponse("Successfully Deleted")); //{"success = true, message=""}
        }
    }
}