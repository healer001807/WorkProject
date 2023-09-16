package com.vv.mybatisflex.generateConfig;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.*;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author kw
 * @program WorkProject
 * @description MyBatis-Flex 自动生成代码
 * @create 2023 - 09 - 07 22:08
 **/
public class AutoGeneratorConfig {

    public static void main(String[] args) {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:mysql://120.48.53.93:3306/vv_work?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("kmg681");

        GlobalConfig globalConfig = myselfGenerator();
        //createGlobalConfigUseStyle2();
        //globalConfig();
        Generator generator = new Generator(hikariDataSource, globalConfig);
        generator.generate();

    }

    public static GlobalConfig globalConfig() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setAuthor("kangwei");
        globalConfig.setMapperTemplatePath("");
        //设置根包
        globalConfig.setBasePackage("com\\vv\\mybatisflex");

        //设置表前缀和只生成哪些表
        globalConfig.setTablePrefix("t_");
        globalConfig.setGenerateTable("t_coupon");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);

        //设置生成 mapper
        globalConfig.setMapperGenerateEnable(true);

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.vv.mybatisflex");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("t_")
                .setGenerateTable("t_coupon");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.enableMapper();

        //可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.getStrategyConfig()
//                .setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

    public static GlobalConfig myselfGenerator() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.setSourceDir("D:\\java\\idea\\wk\\WorkProject\\MyBatis-Flex\\src\\main\\java\\");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("t_")
                .setGenerateTable("t_coupon","t_coupon_template");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.enableMapper();

        // 可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("coupon_seq");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.getStrategyConfig()
//                .setColumnConfig("t_coupon", columnConfig);

//        TableDefConfig tableDefConfig1 = globalConfig.enableTableDef();// tableDefConfig
//        System.out.println(tableDefConfig1);

        globalConfig.enableTableDef().setOverwriteEnable(true)
                .setPropertiesNameStyle(TableDefConfig.NameStyle.LOWER_CAMEL_CASE);

        // 不理解为啥下面的不能生成TableDef todo
       globalConfig.getTableDefConfig()
                .setOverwriteEnable(true)
              //  .setInstanceSuffix("Def")
                .setPropertiesNameStyle(TableDefConfig.NameStyle.LOWER_CAMEL_CASE);


        return globalConfig;
    }
}
