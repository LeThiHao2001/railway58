package vti.com.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configModelmapper {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
