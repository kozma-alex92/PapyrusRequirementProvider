package hu.bme.mit.papyrus.oslc.adaptor.data;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement;

public final class Requirements {
	
	 static List<Requirement> requirements;
	
	
	 public Requirements() {
		requirements = new ArrayList<Requirement>();
		init();
	}

	 
	private static void init(){
		
		Requirement temp;
		try {
			temp = new Requirement();
			temp.setTitle("ReqTitle1");
			temp.setDescription("ReqDescription1");
			temp.setIdentifier("1");
			temp.setAbout(Requirement.constructURI("1", "1"));
			requirements.add(temp);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	 public static List<Requirement> getRequirements(){
		 return requirements;
	 }
	 

}
