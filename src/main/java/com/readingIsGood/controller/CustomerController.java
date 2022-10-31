package com.readingIsGood.controller;


import com.readingIsGood.entity.Customer;
import com.readingIsGood.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(value = "/create")
    @Operation(summary = "Create a Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Customer Created"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity(customerService.createCustomer(customer), HttpStatus.OK);
    }


    @GetMapping(value = "/getCustomerById/{id}")
    @Operation(summary = "Get a Specific Customer Instance by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Get Customer By ID"),
            @ApiResponse(responseCode = "404", description = "No Customer Found With ID"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping(value = "/getAllCustomer")
    @Operation(summary = "Get All Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Get All Customer"),
            @ApiResponse(responseCode = "404", description = "No Customer IDs Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam int pageIndex, @RequestParam int pageSize) {
        return ResponseEntity.ok(customerService.getAllCustomer(pageIndex, pageSize));
    }
}
