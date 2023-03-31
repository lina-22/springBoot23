package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    // autowired dependency injection
    // / productServiceIml class is depend on the productRepository
    // so i no need to do create object by new for the productRepository class

    @Autowired
    ProductRepository mProductRepository;

    @Override
    public ProductModel create(ProductModel productModel){
        return  mProductRepository.save(productModel); //saveAndFlush ?
    }
    @Override
    public Optional<ProductModel> findById(long product_id) {
        return mProductRepository.findById(product_id);
    }
    @Override
    public List<ProductModel> findAll() {
        return mProductRepository.findAll();
    }

    @Override
    public Page findAllPaginated(int pageNumber, int size) {
        Pageable pageAble = PageRequest.of(pageNumber, size);
        Page page = mProductRepository.findAll(pageAble);
        return page;
    }

    @Override
    public ProductModel update(ProductModel productModel){
        return  mProductRepository.save(productModel);
    }

    @Override
    public void delete(long product_id) {
        mProductRepository.deleteById(product_id);
    }


    //@Override
    //public Optional<CategoryModel> isValidCategory(long id) { // <CategoryModal> or Optional data type?

      //  return mCategoryRepository.findById(Long.valueOf(id)); // valueOf ??
    //}



}
