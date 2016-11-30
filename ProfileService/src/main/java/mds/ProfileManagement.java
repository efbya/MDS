package mds;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
//@EnableOAuth2Sso
public class ProfileManagement {
	
	@Value("classpath:response.json")
	private Resource jsonFormat;
	
    @RequestMapping("/profile-details")
    public String getOrderDetails(@RequestParam(value="id", defaultValue="1") String orderId) throws IOException {
    	String format = IOUtils.toString(jsonFormat.getInputStream());
    	return String.format(format, orderId);
    }

	public static void main(String[] args) {
		SpringApplication.run(ProfileManagement.class, args);
	}

}
