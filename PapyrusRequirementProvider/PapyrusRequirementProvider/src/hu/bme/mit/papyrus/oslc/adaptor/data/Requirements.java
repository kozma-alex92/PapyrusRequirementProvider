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

	public static void print() {

		for (Requirement r : requirements) {
			for(Link l:r.getDerived()){
				System.out.println(l.getValue());
			}
		}

	}

	private static Requirement getRequirementByName(String name) {
		for (Requirement r : requirements) {
			if (r.getTitle().equals(name)) {
				return r;
			}
		}
		return null;
	}

	public static void initProp() {

		requirements.clear();

		List<HashMap<String, ArrayList<String>>> multiMap = CSVReader.getProperties();

		Requirement temp;
		try {
			temp = new Requirement();

			for (HashMap<String, ArrayList<String>> s : multiMap) {
				if (s.get("id") != null) {
					temp.setIdentifier(s.get("id").get(0));
				}
				if (s.get("name") != null) {
					temp.setTitle(s.get("name").get(0));
				}
				if (s.get("text") != null) {
					temp.setDescription(s.get("text").get(0));
				}

				temp.setAbout(Requirement.constructURI("RequirementServiceProvider", temp.getIdentifier()));
				requirements.add(new Requirement(temp));
			}

			// derived, derivedFrom, tracedTo,
			// verifiedBy, refinedBy, satisfiedBy

		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		initRel();
		print();
	}

	public static void initRel() {

		List<HashMap<String, ArrayList<String>>> multiMap = CSVReader.getProperties();
		
		for (HashMap<String, ArrayList<String>> s : multiMap) {
			//if the derived key has values in it
			if (s.keySet().contains("derived")) {
				//for the current derived name
				ArrayList<String> d = s.get("derived");
				for (String derivedName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addDerived(new Link(getRequirementByName(derivedName).getAbout()));
				}
			}
			if (s.keySet().contains("derivedFrom")) {
				//for the current derived name
				ArrayList<String> d = s.get("derivedFrom");
				for (String derivedFromName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addDerivedFrom(new Link(getRequirementByName(derivedFromName).getAbout()));
				}
			}
			if (s.keySet().contains("tracedTo")) {
				//for the current derived name
				ArrayList<String> d = s.get("tracedTo");
				for (String tracedToName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addTracedTo(new Link(getRequirementByName(tracedToName).getAbout()));
				}
			}
			if (s.keySet().contains("verifiedBy")) {
				//for the current derived name
				ArrayList<String> d = s.get("verifiedBy");
				for (String verifiedByName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addVerifiedBy(new Link(getRequirementByName(verifiedByName).getAbout()));
				}
			}
			if (s.keySet().contains("refinedBy")) {
				//for the current derived name
				ArrayList<String> d = s.get("refinedBy");
				for (String refinedByName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addRefinedBy(new Link(getRequirementByName(refinedByName).getAbout()));
				}
			}
			if (s.keySet().contains("satisfiedBy")) {
				//for the current derived name
				ArrayList<String> d = s.get("satisfiedBy");
				for (String satisfiedByName : d) {
					//get the requirement which has this derived key
					getRequirementByName(s.get("name").get(0))
							.addSatisfiedBy(new Link(getRequirementByName(satisfiedByName).getAbout()));
				}
			}

		}
	

	}

	public static List<Requirement> getRequirements() {
		return requirements;
	}

}
