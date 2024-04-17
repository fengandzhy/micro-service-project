package org.frank.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.frank.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电商-公司收发货地址表 前端控制器
 * </p>
 *
 * @author frank
 * @since 2024-04-16
 */
@Api(tags = "Delivery Address Module")
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {
    
    private AddressService addressService;
    
    @ApiOperation(value = "Find Address Details by ID")
    @GetMapping("/find/{address_id}")
    public Object detail(@ApiParam(value ="Address Id", required = true) 
                             @PathVariable("address_id") Long addressId){
        return addressService.detail(addressId);
    }
    
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}

