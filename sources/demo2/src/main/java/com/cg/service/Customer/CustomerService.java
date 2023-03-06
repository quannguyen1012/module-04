package com.cg.service.Customer;

import com.cg.model.Customer;
import com.cg.model.Province;
import com.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);

}
