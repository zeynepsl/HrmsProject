package kodlamaio.hrms.core.utilities.adapters;

import java.time.LocalDate;

public interface CheckService {
	boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate yearOfBirth);
}
