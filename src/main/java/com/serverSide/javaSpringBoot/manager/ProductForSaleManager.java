package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.ProductForSaleResDto;
import com.serverSide.javaSpringBoot.model.ProductForSale;
import com.serverSide.javaSpringBoot.services.ProductForSaleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
public class ProductForSaleManager {
    private ProductForSaleService productForSaleService;

    // *******************the dto to model data transfer****************
    public ProductForSaleResDto toDto(ProductForSale productForSale){

        ProductForSaleResDto productForSaleResDto = new ProductForSaleResDto();
        productForSaleResDto.setId(productForSale.getId());
        productForSaleResDto.setQty(productForSale.getQuantity());
        productForSaleResDto.setSkuReference(productForSale.getSkuReference());

        productForSaleResDto.setSize(productForSale.getSizeModel().getSizeValue());

        productForSaleResDto.setCategory(productForSale.getCategoryModel().getCategoryValue());

        productForSaleResDto.setColour(productForSale.getColourModel().getColourValue());
        productForSaleResDto.setMaterial(productForSale.getMaterialModel().getMaterialValue());
        return productForSaleResDto;
    }

    public List<ProductForSaleResDto> toDtos(List<ProductForSale> productForSales){
        List<ProductForSaleResDto> productForSaleResDtos = new ArrayList<>();
        productForSales.forEach(data->{
            productForSaleResDtos.add(toDto(data));
        });
        return productForSaleResDtos;
    }
}
