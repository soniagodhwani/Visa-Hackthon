package com.visa.hackathon.virtualQueueAndOffers.Model.Api;

import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Configuration
public class ApiClient {

	 @Value("${apiClient.keyStorePassword}")
	 private String keystorePassword;
	 @Value("${apiClient.keyStorePath}")
	 private String keystorePath;
	 @Value("${apiClient.privateKeyPassword}")
	 private String privateKeyPassword;
	 @Value("${apiClient.username}")
	 private String username;
	 @Value("${apiClient.password}")
	 private String password;
	  
}
