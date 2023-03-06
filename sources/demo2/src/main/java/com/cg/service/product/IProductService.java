package com.cg.service.product;

import com.cg.model.Product;
import com.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {

    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameContaining(String firstname, Pageable pageable);

}
