package kodlamaio.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryImageManager implements ImageService{

	private Cloudinary cloudinary;
	
	public CloudinaryImageManager() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "df27kkeid",
				"api_key", "685317151961499",
				"api_secret", "a_oojDY8FjyewynzFMZ8dFEh8zg"));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataResult<Map> upload(MultipartFile imageFile) {
			Map<String, String> resultMap = null;
			try {
				resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new SuccessDataResult<Map>(resultMap);
	}

	
	

}
