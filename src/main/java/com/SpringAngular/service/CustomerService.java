package com.SpringAngular.service;

import com.SpringAngular.controller.CustomerController;
import com.SpringAngular.model.Customer;
import com.SpringAngular.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomerDetails(Customer customer){
               customerRepository.saveAndFlush(customer);
               return  "Details Added Successfully";
    }
    public Customer getCustomerDetails(String customerId){
       Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
       Customer customer = optionalCustomer.get();
       return customer;
    }
    public String updateCustomerDetails(String customerId,String customerPhoneNo,String customerFirstName,String customerLastName,String customerAddress){
     Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
     if(!optionalCustomer.isEmpty()) {
         Customer customer = optionalCustomer.get();
         customer.setCustomerPhoneNo(customerPhoneNo);
         customer.setCustomerFirstName(customerFirstName);
         customerRepository.saveAndFlush(customer);
     }
     else{

     }
     return "Updated Successfully";
    }

    public String deleteCustomerDetails(String customerId){
        Optional<Customer> optional=customerRepository.findById(customerId);
        if(!optional.isEmpty()){
            Customer customer = optional.get();
            customerRepository.deleteById(customer.getCustomerId());
            customerRepository.deleteById(customer.getCustomerFirstName());
            customerRepository.deleteById(customer.getCustomerAddress());
            customerRepository.deleteById(customer.getCustomerLastName());
            customerRepository.deleteById(customer.getCustomerPhoneNo());
        }
        else{

        }
        return "deleted";
    }

}
