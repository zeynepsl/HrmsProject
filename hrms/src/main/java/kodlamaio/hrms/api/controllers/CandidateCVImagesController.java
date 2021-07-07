package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.business.abstracts.CandidateImageCVService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCV;
import kodlamaio.hrms.entities.concretes.CandidateImageCV;

@RestController
@RequestMapping("/api/images")
public class CandidateCVImagesController {
	CandidateImageCVService imageCVService;
	CandidateService candidateService;
	CandidateCVService candidateCVService;

	@Autowired
	public CandidateCVImagesController(CandidateImageCVService imageCVService, CandidateService candidateService, CandidateCVService candidateCVService) {
		super();
		this.imageCVService = imageCVService;
		this.candidateService = candidateService;
		this.candidateCVService = candidateCVService;
	}
	
	//resim eklemek icin ilk secenek:
	//Builder, ToString, EqualsAndHashCode --> Image Class'ina eklenmeli
	/*@PostMapping("/upload")
	public ResponseEntity<Result> upload(@RequestParam int candidateCVId, @RequestBody MultipartFile imageFile) {
		final Result result = imageCVService.upload(CandidateImageCV.builder().candidateCV(CandidateCV.builder().id(candidateCVId).build()).build(),
				imageFile);

		return ResponseEntity.ok(result);
	}*/
	
	
	//resim eklemek icin diger secenek:
	@PostMapping("/upload")
	public Result upload(@RequestParam(value = "candidateId") int candidateId, @RequestParam(value = "candidateCVId") int candidateCVId,
			@RequestParam(value = "imageFile") MultipartFile imageFile) throws IOException {

		Candidate candidate = candidateService.getById(candidateId).getData();
		CandidateCV toUploadCV = candidateCVService.getById(candidateCVId).getData();		
		CandidateImageCV candidateImageCV = new CandidateImageCV();	
		
		toUploadCV.setCandidate(candidate);
		candidateImageCV.setCandidateCV(toUploadCV);
	
		return imageCVService.upload(candidateImageCV, imageFile);
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateImageCV>> getAll() {
		return imageCVService.getAll();
	} 
	
	@GetMapping("getAllByCandidateCV_Candidate_Id")
	public DataResult<List<CandidateImageCV>> getAllByCandidateCV_Candidate_Id(int candidateId){
		return imageCVService.getAllByCandidateCV_Candidate_Id(candidateId);
	}
}
