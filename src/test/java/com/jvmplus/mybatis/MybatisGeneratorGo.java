package com.jvmplus.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2/21/15.
 */
public class MybatisGeneratorGo {

    public static void main(String ...s){
        try{
            List<String> warnings = new ArrayList<>();
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration configuration = parser.parseConfiguration(new File("/Users/andy/git/jvmplus/src/generatorConfig.xml"));
            MyBatisGenerator g = new MyBatisGenerator(configuration,null,warnings);
            g.generate(null);
            for(String as : warnings)
                System.out.println(as);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("done");
    }
}
