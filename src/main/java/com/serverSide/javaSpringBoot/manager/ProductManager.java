package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import com.serverSide.javaSpringBoot.response.MessageResponse;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// after creation of dto the prductmanager has been created for handle the message response
@Service // ? for use the service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService; // constructor ??
    public ProductDto createProduct(ProductDto productDto){
        ProductModel productModel = new ProductModel(); // new na koira autowired or all constructor dia product model use kora jaitho nayni??
        productModel.setName(productDto.getName());
        productModel.setDescription(productModel.getDescription());
        productModel.setDiscount(productModel.getDiscount());
        productModel.set_featured(productModel.is_featured());
        productModel.setPrice(productModel.getPrice());
        productModel.setMCategories(productDto.getMCategories());
        productModel.setImportCountry(productModel.getImportCountry());

        ProductModel product = productService.create(productModel);

        ProductDto addedProduct = new ProductDto();
        addedProduct.setId(product.getId());
        addedProduct.setDescription(product.getDescription());
        addedProduct.setDiscount(product.getDiscount());
        addedProduct.setImage(product.getImage());
        addedProduct.setName(product.getName());
        addedProduct.setPrice(product.getPrice());
        addedProduct.set_featured(product.is_featured());
        addedProduct.setMCategories(product.getMCategories());

        return addedProduct;
    }
    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList = new ArrayList<>();
        List<ProductModel> productModelList = productService.findAll();
        productModelList.forEach(data-> {
            ProductDto productDto = new ProductDto();
            productDto.setId(data.getId());
            productDto.setDescription(data.getDescription());
            productDto.setDiscount(data.getDiscount());
            productDto.setImage(data.getImage());
            productDto.setName(data.getName());
            productDto.setPrice(data.getPrice());
            productDto.set_featured(data.is_featured());
            productDto.setMCategories(data.getMCategories());

            productDtoList.add(productDto);

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

}
