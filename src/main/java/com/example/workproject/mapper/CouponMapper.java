package com.example.workproject.mapper;

import com.example.workproject.pojo.dto.UserBoundCouponDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券数据操作
 * @create 2023 - 05 - 20 17:49
 **/
@Mapper
public interface CouponMapper {

    /***
     * @description 批量绑定优惠券
     * @param couponBatch
     * @return java.lang.Integer
     * @author
     * @date 2023/5/21
     **/

    Integer insertCouponBatch(List<Map<String, Object>> couponBatch);

    /***
     * @description 查询用户绑定券总数
     * @param
     * @return int
     * @author
     * @date 2023/5/23
     **/

    int selectTotal();

    /***
     * @description 分页查询用户绑券
     * @param startPageNo, pageSize
     * @return java.util.List<com.example.workproject.pojo.UserBoundCouponDTO>
     * @author
     * @date 2023/5/23
     **/

    List<UserBoundCouponDTO> selectCouponList(int startPageNo, int pageSize);


}
