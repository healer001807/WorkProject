package com.vv.service;

import com.vv.utils.ResUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author kw
 * @program WrokProject
 * @description 优惠券业务接口
 * @create 2023 - 05 - 20 14:31
 **/
public interface CouponService {
    /***
     * @description 批量给客户发券
     * @param multipartFile
     * @return java.lang.String
     * @author
     * @date 2023/5/20
     **/

    ResUtils sendCoupon(MultipartFile multipartFile);

    /***
     * @description 导出用户发券数据
     * @author kangwei
     * @date 2023-5-22
     * @param []
     @return void
     */
    ResUtils exportCoupon();

    /**
     * 执行数据导出操作
     *
     * @return
     */
    ResUtils doExportCoupon() throws IOException;

    /***
     * @description 上传excel
     * @param fileName
     * @return java.lang.String
     * @author
     * @date 2023/5/25
     **/

    ResUtils uploadExcel(String fileName);
}