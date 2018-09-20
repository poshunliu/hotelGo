package com.hotelgo.config.viewresolver;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

public class EmailConfig {

    @Bean(name="mailSender")
    public JavaMailSenderImpl getEmailSender(){
        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
        emailSender.setHost("smtp.sendgrid.net");
        emailSender.setPort(465);
        emailSender.setProtocol("smtps");
        emailSender.setUsername("");
        emailSender.setPassword("");
        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.smtps.auth","true");
        mailProperties.setProperty("mail.smtp.ssl.enable","true");
        mailProperties.setProperty("mail.transport.protocol","smtps");
        emailSender.setJavaMailProperties(mailProperties);
        return emailSender;
    }






    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerMailConfiguration(){
        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("classpath:/WEB-INF/mail/");
        freeMarkerConfigurationFactoryBean.setPreferFileSystemAccess(false);
        return freeMarkerConfigurationFactoryBean;
    }


}
