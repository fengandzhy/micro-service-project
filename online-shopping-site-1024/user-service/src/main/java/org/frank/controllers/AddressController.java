package org.frank.controllers;


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
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {
    
    private AddressService addressService;
    
    @GetMapping("/detail/{address_id}")
    public Object detail(@PathVariable("address_id") Long addressId){
        return addressService.detail(addressId);
    }
    
    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
}

