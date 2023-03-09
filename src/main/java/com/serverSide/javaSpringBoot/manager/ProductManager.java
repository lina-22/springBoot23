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
    private CategoryService categoryService; // importer ou ??
    public ProductDto createProduct(ProductDto productDto){   // createProduct ar return type ProductDto //

        ProductModel  productToAdd= toProductModel(productDto); // ?? and why at 25 no lines there have ProductDto data type but at this line inside bracket no need to give the data type
                                                                            // / because it is a value??
        ProductModel addedProduct =productService.create(productToAdd); // call the create method from product service then (inside pass the product to add)

        return toProductDto(addedProduct); // why toProductDto is return, normally return like 40 no line/
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList = new ArrayList<>();
        List<ProductModel> productModelList = productService.findAll();
        productModelList.forEach(data-> { // data lambda expression ar variable ar name??
            productDtoList.add(toProductDto(data)); // toProductDto refer from line no
        });
        return productDtoList;
    }

    public ProductDto getProductById(long id){
        return toProductDto(productService.findById(id).get());
    }

    public ProductDto updateProduct(ProductDto productDto){
        ProductModel productModel = toProductModel(productDto);
        ProductModel productModel1 =  productService.update(productModel);
        ProductDto productDto1 =  toProductDto(productModel1);
        return productDto1;
        //return toProductDto(productService.update(toProductModel(productDto)));
    }

    public void deleteProductById(long id){
        productService.delete(id);
    }




        public ProductModel toProductModel(ProductDto productDto){
//      System.out.println("test : " + productDto.getMCategories().size() + " pooo" + productDto.getImportCountry());
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setDescription(productDto.getDescription());
        productModel.setDiscount(productDto.getDiscount());
        productModel.set_featured(productDto.is_featured());
        productModel.setPrice(productDto.getPrice());
        productModel.setImportCountry(productDto.getImportCountry());


        Set<CategoryModel> categoryModelSet = new HashSet<>(categoryService.findAllById(productDto.getCategoryIds()));
        productModel.setMCategories(categoryModelSet); // for this line catagories can see with products at data base??

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



// *******************practice the dto to model data transfer****************
//public ProductModel toProductModel(ProductDto productDto){
//        ProductModel productModel = new ProductModel();
//        productModel.setName(productDto.getName());
//
//
//
//}

// *******************practice the dto to model data transfer****************
