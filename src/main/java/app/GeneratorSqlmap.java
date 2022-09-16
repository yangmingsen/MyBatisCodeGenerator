package app;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class GeneratorSqlmap {

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        
        File configFile = new File(MyCommentGenerator.class.getClassLoader().getResource("generatorConfig2.xml").getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        String curDir = System.getProperty("user.dir");
        System.out.println("你当前的工作目录为 :" + curDir);
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}