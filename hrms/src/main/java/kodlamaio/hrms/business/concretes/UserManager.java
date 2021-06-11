package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager<T extends User> implements UserService<User>{

	UserDao<User> userDao;
	
	@Autowired
	public UserManager(UserDao<User> userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Result getUserByEmail(String email) {
		var logic = userDao.existsByEmail(email);	
		if (logic) {
			return new ErrorResult("kullanici zaten mevcut");
		}
		else {
			return new SuccessResult();
		}
	}

}
