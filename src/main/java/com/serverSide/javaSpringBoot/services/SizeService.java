package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.SizeModel;
import java.util.List;
import java.util.Optional;

public interface SizeService {

     SizeModel create(SizeModel sizeModel);
     Optional<SizeModel> findById(long size_id);

     List<SizeModel> findAll();

     SizeModel update(SizeModel sizeModel);

      void delete(long size_id);
}
