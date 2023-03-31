package com.serverSide.javaSpringBoot.services;
import com.serverSide.javaSpringBoot.model.ProductModel;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

// here method are initialized not declare, at the productserviceimpl method where dereclare for the security purpose
public interface ProductService {
    // at Java always need to mention method datatype **ProductModel create ** and also variable datatype (ProductModel productModel)
     ProductModel create(ProductModel productModel);
     Optional<ProductModel> findById(long product_id); // here i use optional because maybe find by id or not

     List<ProductModel> findAll();

    Page findAllPaginated(int pageNumber, int size);

     ProductModel update(ProductModel productModel);

      void delete(long product_id);

    //public Optional<CategoryModel> isValidCategory(long id); // get the category type??
}
