package spring_upload.uploadingfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import storage.StorageService;

@SpringBootApplication
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
