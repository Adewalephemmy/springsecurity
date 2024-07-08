package spring_upload.uploadingfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import storage.StorageProperties;
import storage.StorageService;

@SpringBootApplication
@ComponentScan(basePackages = {"spring_upload.uploadingfile", "storage"})
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingfileApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
