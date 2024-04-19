package org.frank.biz;

import lombok.extern.slf4j.Slf4j;
import org.frank.UserApplication;
import org.frank.models.AddressDO;
import org.frank.services.AddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class AddressTest {
    
    @Autowired
    private AddressService addressService;
    
    @Test
    public void testAddressDetail(){
        AddressDO addressDO = addressService.detail(1L);
        log.info(addressDO.toString());
        Assert.assertNull(addressDO);
    }
}
