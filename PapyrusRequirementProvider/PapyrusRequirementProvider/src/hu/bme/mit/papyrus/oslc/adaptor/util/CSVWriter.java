package hu.bme.mit.papyrus.oslc.adaptor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.lyo.oslc4j.core.model.Link;

import hu.bme.mit.papyrus.oslc.adaptor.data.Requirements;
import hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement;

public final class CSVWriter {
	
	private static BufferedWriter buffer;
	
	public static void writeToFile(){
		try {
			buffer = new BufferedWriter(new FileWriter(ConfigProperties.getPropertyValue("output_fullpath")));
			
			for(Requirement r: Requirements.getRequirements()){
				buffer.write(r.getIdentifier()+";"+r.getTitle()+";"+ r.getDescription()+ ";");
				if(!r.getDerived().isEmpty()){
					int cnt = 0;
					for(Link l: r.getDerived()){
						//System.out.println(r.getTitle()+":   "+l.getValue());
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getDerived().size()) buffer.write(",");
					}
				}
				buffer.write(";");
				if(!r.getDerivedFrom().isEmpty()){
					int cnt = 0;
					for(Link l: r.getDerivedFrom()){
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getDerivedFrom().size()) buffer.write(",");
					}
				}
				buffer.write(";");
				if(!r.getTracedTo().isEmpty()){
					int cnt = 0;
					for(Link l: r.getTracedTo()){
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getTracedTo().size()) buffer.write(",");
					}
				}
				buffer.write(";");
				if(!r.getVerifiedBy().isEmpty()){
					int cnt = 0;
					for(Link l: r.getVerifiedBy()){
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getVerifiedBy().size()) buffer.write(",");
					}
				}
				buffer.write(";");
				if(!r.getRefinedBy().isEmpty()){
					int cnt = 0;
					for(Link l: r.getRefinedBy()){
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getRefinedBy().size()) buffer.write(",");
					}
				}
				buffer.write(";");
				if(!r.getSatisfiedBy().isEmpty()){
					int cnt = 0;
					for(Link l: r.getSatisfiedBy()){
						cnt++;
						buffer.write(Requirements.getRequirementByAbout(l.getValue()).getTitle());
						if(cnt<r.getSatisfiedBy().size()) buffer.write(",");
					}
				}
				buffer.newLine();
			}
			buffer.flush();
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
