package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.business.abstracts.CandidateCoverLetterCVService;
import kodlamaio.hrms.business.abstracts.CandidateEducationCVService;
import kodlamaio.hrms.business.abstracts.CandidateExperienceCVService;
import kodlamaio.hrms.business.abstracts.CandidateImageCVService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageCVService;
import kodlamaio.hrms.business.abstracts.CandidateLinkCVService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateSkillCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCVDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCV;
import kodlamaio.hrms.entities.dtos.CandidateCVDto;

@Service
public class CandidateCVManager implements CandidateCVService{

	CandidateService candidateService;
	CandidateCVDao candidateCVDao;
	CandidateEducationCVService educationCVService;
	CandidateExperienceCVService experienceCVService;
	CandidateImageCVService imageCVService;
	CandidateLanguageCVService languageCVService;
	CandidateLinkCVService linkCVService;
	CandidateSkillCVService skillCVService;
	CandidateCoverLetterCVService coverLetterCVService;
	
	@Autowired
	public CandidateCVManager
	       (CandidateService candidateService, CandidateCVDao candidateCVDao, CandidateEducationCVService educationCVService, 
			CandidateExperienceCVService experienceCVService, CandidateImageCVService imageCVService, 
			CandidateLanguageCVService languageCVService, CandidateLinkCVService linkCVService, CandidateSkillCVService skillCVService,
			CandidateCoverLetterCVService coverLetterCVService) {
		this.candidateService = candidateService;
		this.candidateCVDao = candidateCVDao;
		this.educationCVService = educationCVService;
		this.experienceCVService = experienceCVService;
		this.imageCVService = imageCVService;
		this.languageCVService = languageCVService;
		this.linkCVService = linkCVService;
		this.skillCVService = skillCVService;
		this.coverLetterCVService = coverLetterCVService;
	}
	
	@Override
	public Result add(CandidateCV entity) {
		candidateCVDao.save(entity);
		return new SuccessResult("cv eklendi");
	}

	@Override
	public Result delete(CandidateCV entity) {
		candidateCVDao.delete(entity);
		return new SuccessResult("cv silindi");
	}

	@Override
	public Result update(CandidateCV entity) {
		candidateCVDao.save(entity);
		return new SuccessResult("cv guncellendi");
	}
	
	@Override
	public DataResult<List<CandidateCV>> getAll() {
		return new SuccessDataResult<List<CandidateCV>>(candidateCVDao.findAll(), "cv'ler listelendi");
	}
	
	@Override
	public DataResult<CandidateCV> getById(int candidateCVId) {
		return new SuccessDataResult<CandidateCV>(candidateCVDao.getById(candidateCVId), "belirtilen Id'ye ait CV getirildi");
	}
	
	@Override
	public DataResult<List<CandidateCV>> getAllByCandidateId(int candidateId) {
		
		List<CandidateCV> candidateCVs = candidateCVDao.getAllByCandidate_Id(candidateId);
		
		if(candidateCVs.isEmpty()) {
			return new ErrorDataResult<List<CandidateCV>>("bu adaya ait CV bulunamadi");
		}
		
		return new SuccessDataResult<List<CandidateCV>>(candidateCVs, "bu adaya ait CV'ler listelendi");

	}
	
	@Override
	public DataResult<CandidateCVDto> getCandidateCVWithDetailsByCandidateId(int candidateId) {
		Candidate candidate = candidateService.getById(candidateId).getData();
		CandidateCVDto candidateCVDto = new CandidateCVDto();
		
		candidateCVDto.setCandidate(candidate);
		candidateCVDto.setImageCVs(imageCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setEducationCVs(educationCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setExperienceCVs(experienceCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setLanguageCVs(languageCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setLinkCVs(linkCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setSkillCVs(skillCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		candidateCVDto.setCoverLetterCVs(coverLetterCVService.getAllByCandidateCV_Candidate_Id(candidateId).getData());
		
		return new SuccessDataResult<CandidateCVDto>(candidateCVDto, "aday CV'si detaylariyla listelendi");
	}
	

}
