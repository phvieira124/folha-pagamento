package com.nttdata.hreurekaaserver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;

@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServerApplication {

	private static final Log LOGGER = LogFactory.getLog(HrEurekaServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
		LOGGER.info("hr-eureka exemplo");
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(
			@Value("${spring.application.name}") String applicationName) {
		return (registry) -> registry.config().commonTags("application", applicationName);
	}

}
