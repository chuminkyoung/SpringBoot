package org.koreait.config;

import org.koreait.commons.CommonInterceptor;
import org.koreait.commons.GuestOnlyInterceptor;
import org.koreait.commons.MemberOnlyInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class MvcConfig implements WebMvcConfigurer {
	
	@Value("${file.uploadPath}")
	private String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/uploads/**")
			.addResourceLocations("file:///" + uploadPath + "/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(memberOnlyInterceptor())
				.addPathPatterns("/mypage/**");
		
		registry.addInterceptor(questOnlyInterceptor())
				.addPathPatterns("/member/login", "/member/join");
		
		registry.addInterceptor(commonInterceptor())
				.addPathPatterns("/**");
	}

	@Bean
	public MemberOnlyInterceptor memberOnlyInterceptor() {
		return new MemberOnlyInterceptor();
	}
	
	@Bean
	public GuestOnlyInterceptor questOnlyInterceptor() {
		return new GuestOnlyInterceptor();
	}
	
	@Bean
	public CommonInterceptor commonInterceptor() {
		return new CommonInterceptor();
	}

	
}
