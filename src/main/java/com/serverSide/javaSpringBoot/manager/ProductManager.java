package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import com.serverSide.javaSpringBoot.response.MessageResponse;
import com.serverSide.javaSpringBoot.services.CategoryService;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


// after creation of dto the prductmanager has been created for handle the message response
@Service // ? for use the service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService; // constructor ??
    private CategoryService categoryService; // importer ou ??
   /* public ProductDto createProduct(ProductDto productDto){   // createProduct ar return type ProductDto //

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
       Optional<ProductModel> productModel =  productService.findById(productDto.getId());
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

    public void deleteProductById(long id){
        productService.delete(id);
    }

*/


     /*   public ProductModel toProductModel(ProductDto productDto){
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
    }*/

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
