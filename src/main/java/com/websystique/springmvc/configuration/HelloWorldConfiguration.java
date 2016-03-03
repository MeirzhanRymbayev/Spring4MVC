package com.websystique.springmvc.configuration;


import com.websystique.springmvc.model.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;

public class AppConfig extends WebMvcConfigurerAdapter {

    /*
    * Configure ContentNegotiationManager
    */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
    }

    /*
    * Configure ContentNeg
    * */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        //Define all possible view resolvers
        ArrayList<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        resolvers.add();
    }

    /*
    * Configure View resolver to provide XML output Uses JAXB2 marshaller to
    * marshall/unmarshal POJO's (with JAXB annotations) to XML
    */
    @Bean
    public ViewResolver jaxb2MarshallingXmlResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Pizza.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }

    /*
    * Configure View resolver to provide JSON output using JACKSON library to convert object in JSON format.
    */
    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

    /*
    * Configure View Resolver to provide XLS output using Apache POI library to generate
    * XLS output for an object content
    * */
    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }

    /*
    * Configure View resolver to provide HTML output This is default format
    * in absence of any type suffix.
    */
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}