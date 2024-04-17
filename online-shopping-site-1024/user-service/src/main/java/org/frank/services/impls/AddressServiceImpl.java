package org.frank.services.impls;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.frank.mapppers.AddressMapper;
import org.frank.models.AddressDO;
import org.frank.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    
    private AddressMapper addressMapper;
    
    
    @Override
    public AddressDO detail(Long id) {
        AddressDO addressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id", id));
        return addressDO;
    }

    @Autowired
    public void setAddressMapper(AddressMapper addressMapper) {        
        this.addressMapper = addressMapper;
    }
}
