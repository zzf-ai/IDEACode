package util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/*
 *
 *@author:zzf
 *@time:2021-01-20
 *
 */
public class GenerateCode {
    public static void main(String[] args) {
        //构建代码自动生成器对象
        AutoGenerator mpg=new AutoGenerator();
        //配置策略

        //全局配置
        GlobalConfig gc=new GlobalConfig();
        String projectPath=System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("zzf");
        gc.setOpen(false);
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去掉I前缀
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatisPlus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("plus_test");
        packageConfig.setParent("com.zzf.mybatis_plus");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        mpg.setPackageInfo(packageConfig);
        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setInclude("user");//要映射的表，可传多个参数表示多张表
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);//自动lombok

        strategyConfig.setLogicDeleteFieldName("deleted");//逻辑删除
        //自动填充配置
        TableFill createTime=new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime=new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills=new ArrayList<>();
        tableFills.add(updateTime);
        tableFills.add(createTime);
        strategyConfig.setTableFillList(tableFills);

        //乐观锁
        strategyConfig.setVersionFieldName("version");

        //controller风格
        strategyConfig.setRestControllerStyle(true);

        mpg.setStrategy(strategyConfig);

        mpg.execute();


    }
}
