package com.javaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//@Component không cho phép 
@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper() ; 
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return  modelMapper ;  
	}
}
