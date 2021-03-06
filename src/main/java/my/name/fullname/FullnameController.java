package my.name.fullname;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
public class FullnameController {

    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/fullname")
    public String getFullname() {
	String uri = "http://my.firstname.host:8080/firstname";
	Name name = restTemplate.getForObject(uri, Name.class);
	return name.getName();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Name {
	
	private String name;
	
	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	return builder.build();
    }
}    
