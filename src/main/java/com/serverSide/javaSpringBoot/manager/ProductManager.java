package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


// after creation of dto the prductmanager has been created for handle the message response
@Service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService;
    public ProductDto createProduct(ProductDto productDto){

        ProductModel  productToAdd= toProductModel(productDto);
        ProductModel addedProduct =productService.create(productToAdd);

        return toProductDto(addedProduct);
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList = new ArrayList<>();
        List<ProductModel> productModelList = productService.findAll();
        productModelList.forEach(data-> {
            productDtoList.add(toProductDto(data));
        });
        return productDtoList;
    }

    public ProductDto getProductById(long product_id){
        return toProductDto(productService.findById(product_id).get());
    }

    public ProductDto updateProduct(ProductDto productDto){
       Optional<ProductModel> productModel =  productService.findById(productDto.getProduct_id());
       // Set<CategoryModel> categoryModelSet = new HashSet<>(categoryService.findAllById(productDto.getCategoryIds()));


        if (productModel.isPresent()){
            productModel.get().setName(productDto.getName());
            productModel.get().setDescription(productDto.getDescription());
            productModel.get().setDiscount(productDto.getDiscount());
            productModel.get().set_featured(productDto.is_featured());
            productModel.get().setPrice(productDto.getPrice());
            productModel.get().setImportCountry(productDto.getImportCountry());
         //   productModel.get().setMCategories(categoryModelSet);

            ProductModel updatedProductModel =  productService.update(productModel.get());
            return toProductDto(updatedProductModel);
        }
        return new ProductDto();

    }

    public void deleteProductById(long product_id){

        productService.delete(product_id);
    }


    // ******************* dto to model data transfer****************
        public ProductModel toProductModel(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setDescription(productDto.getDescription());
        productModel.setPrice(productDto.getPrice());
        productModel.setDiscount(productDto.getDiscount());
        productModel.set_featured(productDto.is_featured());
        productModel.setImportCountry(productDto.getImportCountry());
//        Set<CategoryModel> categoryModelSet = new HashSet<>(categoryService.findAllById(productDto.getCategoryIds()));
//        productModel.setMCategories(categoryModelSet); // for this line catagories can see with products at data base??
        return productModel;

    }

    // *******************get the dto with id ****************
        public ProductDto toProductDto(ProductModel productModel){
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(productModel.getProduct_id());
        productDto.setName(productModel.getName());
        productDto.setDescription(productModel.getDescription());
        productDto.setPrice(productModel.getPrice());
        productDto.setDiscount(productModel.getDiscount());
        productDto.set_featured(productModel.is_featured());
        productDto.setImage(productModel.getImage());
        productDto.setImportCountry(productModel.getImportCountry());

//        productDto.setMCategories(productModel.getMCategories());
        return productDto;
    }
}


