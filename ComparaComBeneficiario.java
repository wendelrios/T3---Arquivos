package t3;

import java.util.Comparator;

public class ComparaComBeneficiario implements Comparator<Beneficiario>{
		
	    
	    @Override
	    public int compare(Beneficiario b1, Beneficiario b2) 
	    {
	        return b1.nis.compareTo(b2.nis);  
	    }
	}
