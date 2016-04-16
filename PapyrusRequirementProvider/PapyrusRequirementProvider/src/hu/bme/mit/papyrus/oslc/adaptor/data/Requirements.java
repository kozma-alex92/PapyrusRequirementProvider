package hu.bme.mit.papyrus.oslc.adaptor.data;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.wink.common.internal.providers.entity.csv.CsvReader;
import org.eclipse.lyo.oslc4j.core.model.Link;

import hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement;
import hu.bme.mit.papyrus.oslc.adaptor.servlet.ServiceProviderCatalogSingleton;
import hu.bme.mit.papyrus.oslc.adaptor.util.CSVReader;

public final class Requirements {
	
	 static List<Requirement> requirements = new ArrayList<Requirement>();
	
	

	public static void init(){
		
		requirements.clear();
		
		List<HashMap<String, ArrayList<String>>> multiMap = CSVReader.getProperties();

		
		Requirement temp;
		try {
			temp = new Requirement();
		
		for(HashMap<String, ArrayList<String>> s: multiMap){
			if(s.get("id")!=null){
				temp.setIdentifier(s.get("id").get(0));
			}
			if(s.get("name")!=null){
				temp.setTitle(s.get("name").get(0));
			}
			if(s.get("text")!=null){
				temp.setDescription(s.get("text").get(0));
			}

			temp.setAbout(Requirement.constructURI("RequirementServiceProvider", temp.getIdentifier()));
			requirements.add(new Requirement(temp));
		}
		
		Link link;
		for(HashMap<String, ArrayList<String>> s: multiMap){
			
			temp = new Requirement();
		
		


		
		}
		}
	
	 catch (URISyntaxException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}
	 public static List<Requirement> getRequirements(){
		 return requirements;
	 }
	 

}
