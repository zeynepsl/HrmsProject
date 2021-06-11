package kodlamaio.hrms.core.utilities.adapters;

import java.rmi.RemoteException;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CheckService{

	@Override
	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate yearOfBirth) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();    
	    boolean result=false;
	    
		try 
		{
			result = kpsPublicSoapProxy.TCKimlikNoDogrula
					(
					nationalityId , 
					firstName.toUpperCase(), 
					lastName.toUpperCase(), 
					Integer.parseInt(yearOfBirth.toString())
					);
		} 
		catch (RemoteException e)
		{
			System.out.println("mernis calismiyor");
		}

		return result;
	}
	
}
