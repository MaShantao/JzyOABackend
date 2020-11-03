package com.marico.ncovreportsystem.service;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ApplicationInitService  implements ApplicationListener<ContextRefreshedEvent> {
	
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {//保证只执行一次
            //1.将工程war包中的核酸检测的模板文件拷贝出去
        	ClassPathResource ncovTemplate = new ClassPathResource("ncov_template.pdf");
        	ClassPathResource antibodyTemplate = new ClassPathResource("antibody_template.pdf");
        	ClassPathResource ncovAntibodyTemplate = new ClassPathResource("ncov&antibody_template.pdf");
            String projectPath = System.getProperty("user.dir");    //获取当前项目所在路径
            //创建一个临时模板，放在系统上（这步很无奈）
            File ncovFile = new File(projectPath+"/ncov_template.pdf");
            File antibodyFile = new File(projectPath+"/antibody_template.pdf");
            File ncovAntibodyFile = new File(projectPath+"/ncov&antibody_template.pdf");
            InputStream ncovtemplateInputStream;
            InputStream antibodyInputStream;
            InputStream ncovAntibodyInputStream;
			try {
				ncovtemplateInputStream = ncovTemplate.getInputStream();
				antibodyInputStream = antibodyTemplate.getInputStream();
				ncovAntibodyInputStream = ncovAntibodyTemplate.getInputStream();
				FileUtils.copyInputStreamToFile(ncovtemplateInputStream,ncovFile);
				FileUtils.copyInputStreamToFile(antibodyInputStream,antibodyFile);
				FileUtils.copyInputStreamToFile(ncovAntibodyInputStream,ncovAntibodyFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }
}
