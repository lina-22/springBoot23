package com.serverSide.javaSpringBoot.services;
import com.serverSide.javaSpringBoot.model.MaterialModel;
import com.serverSide.javaSpringBoot.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    MaterialRepository materialRepository;

    @Override
    public MaterialModel create(MaterialModel materialModel){

        return  materialRepository.save(materialModel);
    }
    @Override
    public Optional<MaterialModel> findById(long material_id){

        return materialRepository.findById(material_id);
    }

    @Override
    public List<MaterialModel> findAll(){

        return materialRepository.findAll();
    }

    @Override
    public MaterialModel update(MaterialModel materialModel){
        return  materialRepository.save(materialModel);
    }

    @Override
    public void delete(long material_id) {
        materialRepository.deleteById(material_id);
    }
}
