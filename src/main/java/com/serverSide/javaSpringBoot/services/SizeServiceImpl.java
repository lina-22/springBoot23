package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.repository.CategoryRepository;
import com.serverSide.javaSpringBoot.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SizeServiceImpl implements SizeService{

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public SizeModel create(SizeModel sizeModel){

        return  sizeRepository.save(sizeModel);
    }
    @Override
    public Optional<SizeModel> findById(Long category_id){

        return sizeRepository.findById(category_id);
    }

    @Override
    public List<SizeModel> findAll(){

        return sizeRepository.findAll();
    }

    @Override
    public SizeModel update(SizeModel sizeModel){
        return  sizeRepository.save(sizeModel);
    }

    @Override
    public void delete(long category_id) {
        sizeRepository.deleteById(category_id);
    }
}
