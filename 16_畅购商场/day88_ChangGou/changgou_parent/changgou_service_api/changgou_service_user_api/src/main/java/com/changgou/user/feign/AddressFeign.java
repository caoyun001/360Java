package com.changgou.user.feign;

import com.changgou.user.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 */
@FeignClient(name = "user")
public interface AddressFeign {

    /**
     * 根据当前登录用户的用户名, 获取收货地址列表
     * @return
     */
    @GetMapping("/address/list")
    public List<Address> findAddressListByUserName();
}
