package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService<T extends User> {
    public Result getUserByEmail(String email);
}
/*public interface UserService {
	public DataResult<User> getUserByEmail(String email);
}
*/
