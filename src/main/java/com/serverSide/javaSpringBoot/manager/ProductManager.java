package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import com.serverSide.javaSpringBoot.response.MessageResponse;
import com.serverSide.javaSpringBoot.services.CategoryService;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// after creation of dto the prductmanager has been created for handle the message response
@Service // ? for use the service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService; // constructor ??
    private CategoryService categoryService;
    public ProductDto createProduct(ProductDto productDto){

        ProductModel  productToAdd= toProductModel(productDto);
        ProductModel addedProduct =productService.create(productToAdd);

        return toProductDto(addedProduct);
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList = new ArrayList<>();
        List<ProductModel> productModelList = productService.findAll();
        productModelList.forEach(data-> { // data lambda expression ar variable ar name??
            productDtoList.add(toProductDto(data));
        });
        return productDtoList;
    }

    //public ProductDto getOneProduct() {
      //  ProductDto productDto = new ProductDto;
       //ProductModel productModel = productService.findById(long id);
        //productModel.forEach(data-> {
          //  productDto.setId(data.getId());
            //productDto.add(productDto);

        //});
        //return productDto;
    //}




    public ProductModel toProductModel(ProductDto productDto){
        System.out.println("test : " + productDto.getMCategories().size() + " pooo" + productDto.getImportCountry());
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setDescription(productDto.getDescription());
        productModel.setDiscount(productDto.getDiscount());
        productModel.set_featured(productDto.is_featured());
        productModel.setPrice(productDto.getPrice());
        productModel.setImportCountry(productDto.getImportCountry());


        Set<CategoryModel> categoryModelSet = new HashSet<>(categoryService.findAllById(productDto.getCategoryIds()));
        productModel.setMCategories(categoryModelSet);
        return productModel;

    }

    public ProductDto toProductDto(ProductModel productModel){
        ProductDto productDto = new ProductDto();
        productDto.setId(productModel.getId());
        productDto.setDescription(productModel.getDescription());
        productDto.setDiscount(productModel.getDiscount());
        productDto.setImage(productModel.getImage());
        productDto.setName(productModel.getName());
        productDto.setPrice(productModel.getPrice());
        productDto.set_featured(productModel.is_featured());
        productDto.setMCategories(productModel.getMCategories());
        return productDto;
    }

}
