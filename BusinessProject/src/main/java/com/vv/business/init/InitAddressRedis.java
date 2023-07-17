package com.vv.business.init;

import com.vv.business.mapper.AddressMapper;
import com.vv.business.pojo.AddressDTO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

/**
 * @program: WorkProject
 * @description: 初始化地址缓存
 * @author: kangwei
 * @create: 2023-07-11 09:41
 **/
@Component
public class InitAddressRedis {

    // boot3.0不要使用javax下的 @Resource,此注解无法注入，boot3用jakarta包下的 @Resource
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private AddressMapper addressMapper;

    /*** 
     * @description 初始化加载地址信息到redis缓存
     * @author kangwei
     * @date 2023-7-11
     * @param []
     @return void
     */
    @PostConstruct
    public void initGetAddress() {
        // 查询地址
        List<AddressDTO> addressDTOS = addressMapper.selectList(null);
        // 非空判断
        if (Optional.ofNullable(addressDTOS).isPresent()) {
            // 查询成功，将地址存入缓存 ,过期时间暂时不设置
            redisTemplate.opsForValue().set("ADDRESS_", addressDTOS);
        }
    }

}
