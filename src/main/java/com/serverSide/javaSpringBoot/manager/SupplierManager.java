package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.SupplierDto;
import com.serverSide.javaSpringBoot.model.SupplierModel;
import com.serverSide.javaSpringBoot.services.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierManager {
    private SupplierService supplierService;

    public SupplierDto createSupplier(SupplierDto supplierDto){
        SupplierModel supplierToAdd = toSupplierModel(supplierDto);
        SupplierModel addedSupplier = supplierService.create(supplierToAdd);
        return toSupplierDto(addedSupplier);
    }

    public List<SupplierDto> getAllSupplier() {
        List<SupplierDto>supplierDtoList = new ArrayList<>();
        List<SupplierModel> supplierModelList = supplierService.findAll();
        supplierModelList.forEach(data-> {
            supplierDtoList.add(toSupplierDto(data));
        });
        return supplierDtoList;

    }

    public SupplierDto getSupplierById(long supplierId){
        return toSupplierDto(supplierService.findById(supplierId).get());
    }


    public SupplierDto updateSupplier(SupplierDto supplierDto){
        Optional<SupplierModel> supplierModel =  supplierService.findById(supplierDto.getSupplierId());
        if (supplierModel.isPresent()){
            supplierModel.get().setSupplierCountry(supplierDto.getSupplierCountry());
            supplierModel.get().setCompanyName(supplierDto.getCompanyName());
            supplierModel.get().setContactName(supplierDto.getContactName());
            supplierModel.get().setContactTitle(supplierDto.getContactTitle());
            supplierModel.get().setAddress(supplierDto.getAddress());
            supplierModel.get().setRegion(supplierDto.getRegion());
            supplierModel.get().setPostalCode(supplierDto.getPostalCode());
            supplierModel.get().setPhone(supplierDto.getPhone());
            supplierModel.get().setFax(supplierDto.getFax());
            SupplierModel updatedSupplierModel =  supplierService.update(supplierModel.get());
            return toSupplierDto(updatedSupplierModel);
        }
        return new SupplierDto();

    }

    public void deleteSupplierById(long supplier_id){

        supplierService.delete(supplier_id);
    }

    // ******************* the dto to model data transfer****************
    public SupplierModel toSupplierModel(SupplierDto supplierDto){
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setSupplierCountry(supplierDto.getSupplierCountry());
        supplierModel.setCompanyName(supplierDto.getCompanyName());
        supplierModel.setContactName(supplierDto.getContactName());
        supplierModel.setContactTitle(supplierDto.getContactTitle());
        supplierModel.setAddress(supplierDto.getAddress());
        supplierModel.setRegion(supplierDto.getRegion());
        supplierModel.setPostalCode(supplierDto.getPostalCode());
        supplierModel.setPhone(supplierDto.getPhone());
        supplierModel.setFax(supplierDto.getFax());
        return supplierModel;
    }

    // *******************end the model to dto data transfer****************
    public SupplierDto toSupplierDto(SupplierModel supplierModel){
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierId(supplierModel.getSupplierId());
        supplierDto.setSupplierCountry(supplierModel.getSupplierCountry());
        supplierDto.setCompanyName(supplierModel.getCompanyName());
        supplierDto.setContactName(supplierModel.getContactName());
        supplierDto.setContactTitle(supplierModel.getContactTitle());
        supplierDto.setAddress(supplierModel.getAddress());
        supplierDto.setRegion(supplierModel.getRegion());
        supplierDto.setPostalCode(supplierModel.getPostalCode());
        supplierDto.setPhone(supplierModel.getPhone());
        supplierDto.setFax(supplierModel.getFax());
        return  supplierDto;
    }
}
