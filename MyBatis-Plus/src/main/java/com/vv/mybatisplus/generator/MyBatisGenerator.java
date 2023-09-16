package com.vv.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

import static com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder.*;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 09 - 16 11:08
 **/
public class MyBatisGenerator {
    public static void main(String[] args) {
        autoGenerator();
        //   System.out.println(System.getProperty("user.dir"));
    }

    /**
     * 数据源配置
     */

    public static void autoGenerator() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder("jdbc:mysql://120.48.53.93:3306/vv_work?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8",
                "root", "kmg681")
                .schema("baomidou")
                .build();
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);

        GlobalConfig.Builder globalConfigBuilder = globalConfigBuilder();
        globalConfigBuilder.author("kangwei");
        globalConfigBuilder.outputDir(System.getProperty("user.dir") + "\\MyBatis-Plus\\src\\main\\java");
        globalConfigBuilder.enableSwagger();

        autoGenerator.global(globalConfigBuilder.build());
        PackageConfig.Builder packageConfigBuilder = packageConfigBuilder();
        packageConfigBuilder.parent("com.vv.mybatisplus");
        packageConfigBuilder.xml(System.getProperty("user.dir") + "\\MyBatis-Plus\\src\\main\\resources\\mapper");
        autoGenerator.packageInfo(packageConfigBuilder.build());
        StrategyConfig.Builder strategyConfig = strategyConfigBuilder()
                .addInclude("t_coupon", "t_coupon_template");
        autoGenerator.strategy(strategyConfig.build());
        autoGenerator.template(templateConfig());
        autoGenerator.execute();
    }

    public static void fastAutoGenerator() {

        FastAutoGenerator.create("jdbc:mysql://120.48.53.93:3306/vv_work?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8",
                        "root", "kmg681")
                .globalConfig(builder -> {
                    builder.author("kangwei") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.vv.mybatisplus") // 设置父包名
                            // .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    System.getProperty("user.dir") + "/src/main/java/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_coupon", "t_coupon_template") // 设置需要生成的表名
                            .addTablePrefix("t_", "t_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
