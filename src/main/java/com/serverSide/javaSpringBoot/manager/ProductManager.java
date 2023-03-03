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


// after creation of dt the prductmanager has been created for handle the message response
@Service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService;

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

}
