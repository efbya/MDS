package mds;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
//@EnableOAuth2Sso
public class SYWManagement {
	
	@Value("classpath:response.json")
	private Resource jsonFormat;
    @RequestMapping("/syw-details")
    public String getOrderDetails(@RequestParam(value="orderId", defaultValue="1") String orderId) throws IOException {
    	String format = IOUtils.toString(jsonFormat.getInputStream());
    	return String.format(format, orderId);
    }

	public static void main(String[] args) {
		SpringApplication.run(SYWManagement.class, args);
	}

}
