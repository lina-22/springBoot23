package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.SizeModel;
import java.util.List;
import java.util.Optional;

public interface SizeService {

    public SizeModel create(SizeModel sizeModel);
    public Optional<SizeModel> findById(long size_id);

    public List<SizeModel> findAll();

    public SizeModel update(SizeModel sizeModel);

    public  void delete(long size_id);
}
