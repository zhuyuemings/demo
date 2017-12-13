package com.demo.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBatisGeneratorUtil {

    public static void main(String[] args) throws Exception {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            //加载配置文件
            File configFile = new File("/Users/ymzhu/Documents/idea_projects/demo/out/production/resources/generator-config.xml");
            System.out.println("读取配置文件：" + configFile.getName());
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("逆向生成结束...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
