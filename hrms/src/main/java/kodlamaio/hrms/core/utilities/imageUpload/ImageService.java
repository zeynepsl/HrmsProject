package kodlamaio.hrms.core.utilities.imageUpload;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<?> upload(MultipartFile file);
}
