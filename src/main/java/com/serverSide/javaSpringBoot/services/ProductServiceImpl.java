package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
//@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository mProductRepository;
    @Override
    public ProductModel createAndUpdate(ProductModel productModel){
        return  mProductRepository.saveAndFlush(productModel); //saveAndFlush ?
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

}

// autowired dependency injection but autowired will effect for the testing purpose, it will create the database field if i keep autowired again it will
// crete data at datbase so after test it will be nessesary to delete the testing data but instand of @Autiwirded if i use @AllArgumentConstructor
// and @NonArgumentConstructor it will not create such kind of problem during test
// / productServiceIml class is depend on the productRepository
// so i no need to do create object by new for the productRepository class
//@Override
//public Optional<CategoryModel> isValidCategory(long id) { // <CategoryModal> or Optional data type?

//  return mCategoryRepository.findById(Long.valueOf(id)); // valueOf ??
//}