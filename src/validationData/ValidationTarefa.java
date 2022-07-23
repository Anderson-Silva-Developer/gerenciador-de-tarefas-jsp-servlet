package validationData;

public class ValidationTarefa {
	
	public boolean validationTarefa(String title, String ob) {
		if(title!=null && ob!=null) {	
			title=title.trim().length()>0?title:"sem titulo";
			ob=ob.trim().length()>0?ob:"sem observações";
			
			return true;
		}
		return false;			
	}
	public String validationTitle(String title) {
		
		if(title!=null) {			
			title=title.trim().length()>0?title:"sem titulo";
			return title;
		}
		return "sem titulo";			
	}

	public String validationObTarefa(String ob) {
		
		if(ob!=null) {	
			
			ob=ob.trim().length()>0?ob:"sem observações";			
			return ob;
		}
		return "sem observações";			
	}


}
