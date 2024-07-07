package spring_upload.uploadingfile;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

public class FileUploadController {
	
	private final StorageService storageService;
	
	@Autowired
	private FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@GetMapping("/")
	private String listUploadedFiles(Model model) throws IOException{
		model.addAttribute("file", storageService.loadAll().map(
				path->MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
				"serveFile", path.getFileName().toString()).build().toUri().toString())
		.collect(Collectors.toList()));
		return "upLoadForm";
	}

}
