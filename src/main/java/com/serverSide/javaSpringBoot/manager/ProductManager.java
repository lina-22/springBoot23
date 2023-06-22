package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.*;
import com.serverSide.javaSpringBoot.services.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class ProductManager {
    private ProductService productService;
    private CategoryService categoryService;
    private ColourService colourService;
    private MaterialService materialService;
    private SizeService sizeService;
    private SupplierService supplierService;
    private ProductForSaleService productForSaleService;

    private ProductForSaleManager productForSaleManager;

    public ProductDto createAndUpdateProduct(ProductDto productDto, MultipartFile image){

        ProductModel productModelToSave = new ProductModel();
        if(productDto.getProductId() != 0) {
            System.out.println("test prd id : " + productDto.getProductId());
            productModelToSave.setProductId(productDto.getProductId());
        }
        try {
            setImage(productDto, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productModelToSave.setPrice(productDto.getPrice());
        productModelToSave.setDescription(productDto.getDescription());
        productModelToSave.setDiscount(productDto.getDiscount());
        productModelToSave.setName(productDto.getName());
        productModelToSave.setImage(productDto.getImage());
        Optional<SupplierModel> supplierModel = supplierService.findById(productDto.getSupplierId());
        if (supplierModel.isPresent()) {
            productModelToSave.setSupplierModel(supplierModel.get());
        }

        ProductModel addedProduct = productService.createAndUpdate(productModelToSave);



        List<ProductForSale> productForSales = new ArrayList<>();
        productDto.getProductForSaleReqDto().forEach(data->{

            ProductForSale productForSale = new ProductForSale();
            if(data.getId() != 0) {
                System.out.println("test avl p id : " + data.getId());
                productForSale.setId(data.getId());
            }
            Optional<CategoryModel> categoryModel = categoryService.findById(data.getCategoryId());
            if (categoryModel.isPresent()) {
                productForSale.setCategoryModel(categoryModel.get());
            }

            Optional<ColourModel> colourModel = colourService.findById(data.getColourId());
            if (colourModel.isPresent()) {
                productForSale.setColourModel(colourModel.get());
            }

            Optional<SizeModel> sizeModel = sizeService.findById(data.getSizeId());
            if (sizeModel.isPresent()) {
                productForSale.setSizeModel(sizeModel.get());
            }

            Optional<MaterialModel> materialModel = materialService.findById(data.getMaterialId());
            if (materialModel.isPresent()) {
                productForSale.setMaterialModel(materialModel.get());
            }

            productForSale.setProductModel(addedProduct);

            productForSale.setSkuReference(data.getSkuReference());
            System.out.println("test here....: " + data.getQty());
            productForSale.setQuantity(data.getQty());

            productForSales.add(productForSale);

        });



        Set<ProductForSale> productForSaleSet = productForSaleService.saveAll(productForSales);

       ProductModel productModel =  productService.findById(addedProduct.getProductId()).get();
        return toProductDto(productModel);
    }

    private ProductDto setImage(ProductDto productDto, MultipartFile image) throws IOException {
        productDto.setImage(image.getBytes());
        return productDto;
    }

    public List<ProductDto> getAllProduct() {
        List<ProductDto>productDtoList = new ArrayList<>();
        List<ProductModel> productModelList = productService.findAll();
        productModelList.forEach(data-> {
            productDtoList.add(toProductDto(data));
        });
        return productDtoList;
    }

    public Page getAllProductPaginated(int pageNumber, int size){
        return productService.findAllPaginated(pageNumber, size);
    }

    public ProductDto getProductById(long product_id){
        return toProductDto(productService.findById(product_id).get());
    }

    public ProductDto updateProduct(ProductDto productDto){
       Optional<ProductModel> productModel =  productService.findById(productDto.getProductId());
        if (productModel.isPresent()){
            productModel.get().setName(productDto.getName());
            productModel.get().setDescription(productDto.getDescription());
            productModel.get().setDiscount(productDto.getDiscount());
            productModel.get().setPrice(productDto.getPrice());
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
        return productModel;

    }

    // *******************get the dto with id ****************
        public ProductDto toProductDto(ProductModel productModel){

        ProductDto productDto = new ProductDto();
        productDto.setProductId(productModel.getProductId());
        productDto.setName(productModel.getName());
        productDto.setDescription(productModel.getDescription());
        productDto.setPrice(productModel.getPrice());
        productDto.setDiscount(productModel.getDiscount());
        productDto.setImage(productModel.getImage());
        productDto.setProductForSaleResDtos(productForSaleManager
                .toDtos(productModel.getProductForSale()));
        return productDto;
    }
}


