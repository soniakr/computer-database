package com.excilys.formation.cbd.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.excilys.formation.cbd.controllers" })
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("home");
	   }
	 
	 @Bean
	   public ViewResolver getViewLocation() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	 
	      viewResolver.setViewClass(JstlView.class);
	      viewResolver.setPrefix("/WEB-INF/views/");
	      viewResolver.setSuffix(".jsp");
	 
	      return viewResolver;
	   }
	   
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/"); 
	    }
	   
	    @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("/languages/message");
	        messageSource.setDefaultEncoding("ISO-8859-1"); // or UTF8 ?
	        return messageSource;
	    }

	    @Bean
	    public LocaleResolver localeResolver(){
		    CookieLocaleResolver resolver = new CookieLocaleResolver();
		    resolver.setDefaultLocale(new Locale("fr"));
		    return resolver;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	        interceptor.setParamName("lang");
	        registry.addInterceptor(interceptor);
	    }

}