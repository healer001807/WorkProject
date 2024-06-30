package com.vv.study1.excel.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kw
 * @program WorkProject
 * @description 晒图活动
 * @create 2024 - 01 - 08 22:09
 **/
@Setter
@Getter
@Accessors(chain = true)
public class PrintActivityDto implements Serializable {

    private String printActivityName;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imagePath;

}
