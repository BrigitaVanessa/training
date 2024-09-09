package com.training.product.controller;

import com.training.product.dto.ApiResponse;
import com.training.product.dto.CustomerRequest;
import com.training.product.dto.UpdateCustomerDataRequest;
import com.training.product.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody CustomerRequest request) {
        return customerService.addCustomer(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequest request) {
        return customerService.editCustomer(id,request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateCustomer(@RequestBody UpdateCustomerDataRequest request) {
        return customerService.updateCustomerData(request);
    }
}
