package com.SpringAngular.controller;

import com.SpringAngular.model.Customer;
import com.SpringAngular.service.CustomerService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("addCustomer")
    public String addCustomerDetails(@RequestBody Customer customer){
         customerService.addCustomerDetails(customer);
         return "Added Successfully";
    }
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerDetails(@PathVariable String id){
        return customerService.getCustomerDetails(id);
    }
    @PutMapping("updateDetails")
    public String updateCustomerDetails(@PathVariable String customerId,@PathVariable String customerPhoneNo,@PathVariable String customerFirstName,@PathVariable String customerLastName,@PathVariable String customerAddress){
        customerService.updateCustomerDetails(customerId,customerPhoneNo,customerFirstName,customerLastName,customerAddress);
        return "updated Successfully";
    }

    @DeleteMapping("/deleteDetails/{id}")
    public String deleteCustomerDetails(@PathVariable String customerId){
      customerService.deleteCustomerDetails(customerId);
      return "Deleted Successfully";
    }

}
