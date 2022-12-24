package com.example.bankaccservice.mappers;

import com.example.bankaccservice.dto.ResponseCustomerDTO;
import com.example.bankaccservice.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public ResponseCustomerDTO fromCustomer(Customer customer){
        ResponseCustomerDTO customerDTO = ResponseCustomerDTO.builder().build();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }
}
