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
    private AvailableProductService availableProductService;

    private AvailableProductManager availableProductManager;

    public ProductDto createAndUpdateProduct(ProductDto productDto, MultipartFile image){
        try {
            setImage(productDto, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<AvailableProductModel>availableProductModels = new ArrayList<>();
        productDto.getAvailableProductDtoReq().forEach(data->{

            AvailableProductModel availableProductModel = new AvailableProductModel();
            if(data.getId() != 0) {
                System.out.println("test avl p id : " + data.getId());
                availableProductModel.setApId(data.getId());
            }
            Optional<CategoryModel> categoryModel = categoryService.findById(data.getCategoryId());
            if (categoryModel.isPresent()) {
                availableProductModel.setCategoryModel(categoryModel.get());
            }

            Optional<ColourModel> colourModel = colourService.findById(data.getColourId());
            if (colourModel.isPresent()) {
                availableProductModel.setColourModel(colourModel.get());
            }

            Optional<SizeModel> sizeModel = sizeService.findById(data.getSizeId());
            if (sizeModel.isPresent()) {
                availableProductModel.setSizeModel(sizeModel.get());
            }

            Optional<MaterialModel> materialModel = materialService.findById(data.getMaterialId());
            if (materialModel.isPresent()) {
                availableProductModel.setMaterialModel(materialModel.get());
            }

//            Optional<SupplierModel> supplierModel = supplierService.findById('long supplier_id');
//            if (supplierModel.isPresent()) {
//                availableProductModel.setSupplierModel(supplierModel.get());
//            }

            availableProductModel.setSkuReference(data.getSkuReference());
            System.out.println("test here....: " + data.getQty());
            availableProductModel.setApQuantity(data.getQty());

            availableProductModels.add(availableProductModel);

        });



        Set<AvailableProductModel> availableProductModelSet = availableProductService.saveAll(availableProductModels);

        ProductModel productModelToSave = new ProductModel();
        if(productDto.getProductId() != 0) {
            System.out.println("test prd id : " + productDto.getProductId());
            productModelToSave.setProductId(productDto.getProductId());
        }

        productModelToSave.setPrice(productDto.getPrice());
        productModelToSave.setDescription(productDto.getDescription());
        productModelToSave.setDiscount(productDto.getDiscount());
        productModelToSave.setName(productDto.getName());
        productModelToSave.setImage(productDto.getImage());
        productModelToSave.setImportCountry(productDto.getImportCountry());
        productModelToSave.set_featured(productDto.is_featured());
        productModelToSave.setAvailableProductModel(availableProductModelSet);
        Optional<SupplierModel> supplierModel = supplierService.findById(productDto.getSupplierId());
        if (supplierModel.isPresent()) {
            productModelToSave.setSupplierModel(supplierModel.get());
        }

        ProductModel addedProduct = productService.createAndUpdate(productModelToSave);

        return toProductDto(addedProduct);
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
        productDto.setProductId(productModel.getProductId());
        productDto.setName(productModel.getName());
        productDto.setDescription(productModel.getDescription());
        productDto.setPrice(productModel.getPrice());
        productDto.setDiscount(productModel.getDiscount());
        productDto.set_featured(productModel.is_featured());
        productDto.setImage(productModel.getImage());
        productDto.setImportCountry(productModel.getImportCountry());
        productDto.setAvailableProductDtoRes(availableProductManager
                .toDtos(productModel.getAvailableProductModel()));
        return productDto;
    }
}


