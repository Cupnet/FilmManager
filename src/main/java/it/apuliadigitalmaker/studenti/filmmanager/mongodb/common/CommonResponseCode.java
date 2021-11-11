package it.apuliadigitalmaker.studenti.filmmanager.mongodb.common;

import java.util.HashMap;
import java.util.Map;

public enum CommonResponseCode {

		OK("000","Success"),
		NOT_FOUND("001","Not found"),
		UNEXPECTED_ERROR("002","Error Unexpected");
	    
	 
	    private String responseCode;
	    private String message;
	 
	    CommonResponseCode(String code, String message) {
	        this.responseCode = code;
	        this.message = message;
	    }
	 
	    public String getResponseCode() {
	        return responseCode;
	    }
	    
	    public String getMessage() {
	    	return message;
	    }
	     
	    //****** Reverse Lookup Implementation************//
	 
	    //Lookup table
	    private static final Map<String, CommonResponseCode> lookup = new HashMap<>();
	  
	    //Populate the lookup table on loading time
	    static
	    {
	        for(CommonResponseCode code : CommonResponseCode.values())
	        {
	            lookup.put(code.getResponseCode(), code);
	        }
	    }
	  
	    //This method can be used for reverse lookup purpose
	    public static CommonResponseCode get(String code) 
	    {
	        return lookup.get(code);
	    }	
	
}
