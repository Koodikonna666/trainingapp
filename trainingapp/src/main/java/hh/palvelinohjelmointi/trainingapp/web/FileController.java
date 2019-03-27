package hh.palvelinohjelmointi.trainingapp.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hh.palvelinohjelmointi.trainingapp.domain.File;
import hh.palvelinohjelmointi.trainingapp.domain.FileRepository;

@Controller
public class FileController {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Value("${upload.path}")
	private String uploadFolder;
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file, Principal principal) {
		if (file.isEmpty()) {
			return "uploadstatus";
		}
		
		try {
			File fileModel = new File(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(fileModel);
            
            return "redirect:/files";
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return "uploadstatus";
		
	}
	
	
	@GetMapping("/harjoitusohjelmat")
	public String fileList(Model model) {
		model.addAttribute("file", fileRepository.findAll());
		return "trainingfiles";
	}
	
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id){
		Optional<File> fileOptional = fileRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			File file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
					.body(file.getFile());	
			
		}
		
		
		return ResponseEntity.status(404).body(null);
		
	}
	

}
