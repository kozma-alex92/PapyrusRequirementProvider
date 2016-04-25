package hu.bme.mit.papyrus.oslc.adaptor.data;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.wink.common.internal.providers.entity.csv.CsvReader;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;

import hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement;
import hu.bme.mit.papyrus.oslc.adaptor.resources.RequirementCollection;
import hu.bme.mit.papyrus.oslc.adaptor.servlet.ServiceProviderCatalogSingleton;
import hu.bme.mit.papyrus.oslc.adaptor.util.CSVReader;

public final class Requirements {

	static List<Requirement> requirements = new ArrayList<Requirement>();
	static List<RequirementCollection> requirementCollections = new ArrayList<RequirementCollection>();
	static int collectionCount = 0;


	private static Requirement getRequirementByName(String name) {
		for (Requirement r : requirements) {
			if (r.getTitle().equals(name)) {
				return r;
			}
		}
		return null;
	}

	private static RequirementCollection getRequirementCollectionByName(String name) {
		for (RequirementCollection r : requirementCollections) {
			if (r.getTitle().equals(name)) {
				return r;
			}
		}
		return null;
	}

	public static void initReqCollections() {

		requirementCollections.clear();
		collectionCount = 0;

		LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> multiMap = CSVReader.getProperties();

		RequirementCollection rc;

		for (String s : multiMap.keySet()) {

			try {
				rc = new RequirementCollection();
				rc.setTitle(s);
				rc.setIdentifier(collectionCount++ + "");
				rc.setAbout(RequirementCollection.constructURI("Provider", rc.getIdentifier()));
				requirementCollections.add(new RequirementCollection(rc));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void init(){
		initReqCollections();
		initReqs();
		initReqRelationships();
		initReqCollectionRelationships();
	}
	

	public static void initReqCollectionRelationships() {
		LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> multiMap = CSVReader.getProperties();
		for (String s : multiMap.keySet()) {
			for (LinkedHashMap<String, ArrayList<String>> req : multiMap.get(s)) {
				
				getRequirementCollectionByName(s)
						.addUses(new Link(getRequirementByName(req.get("name").get(0)).getAbout()));
			}
		}

	}

	public static void initReqs() {

		requirements.clear();

		LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> multiMap = CSVReader.getProperties();

		for (String s : multiMap.keySet()) {
			Requirement temp;
			try {

				for (LinkedHashMap<String, ArrayList<String>> req : multiMap.get(s)) {
					temp = new Requirement();
					if (req.get("id") != null) {
						temp.setIdentifier(req.get("id").get(0));
					}
					if (req.get("name") != null) {
						temp.setTitle(req.get("name").get(0));
					}
					if (req.get("text") != null) {
						temp.setDescription(req.get("text").get(0));
					}

					temp.setAbout(Requirement.constructURI("Provider", temp.getIdentifier()));
					requirements.add(new Requirement(temp));

				}

				// derived, derivedFrom, tracedTo,
				// verifiedBy, refinedBy, satisfiedBy

			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void initReqRelationships() {

		LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> multiMap = CSVReader.getProperties();
		for (String s : multiMap.keySet()) {
			for (LinkedHashMap<String, ArrayList<String>> req : multiMap.get(s)) {
				// if the derived key has values in it
				if (req.keySet().contains("derived")) {
					// for the current derived name
					ArrayList<String> d = req.get("derived");
					for (String derivedName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addDerived(new Link(getRequirementByName(derivedName).getAbout()));
					}
				}
				if (req.keySet().contains("derivedFrom")) {
					// for the current derived name
					ArrayList<String> d = req.get("derivedFrom");
					for (String derivedFromName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addDerivedFrom(new Link(getRequirementByName(derivedFromName).getAbout()));
					}
				}
				if (req.keySet().contains("tracedTo")) {
					// for the current derived name
					ArrayList<String> d = req.get("tracedTo");
					for (String tracedToName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addTracedTo(new Link(getRequirementByName(tracedToName).getAbout()));
					}
				}
				if (req.keySet().contains("verifiedBy")) {
					// for the current derived name
					ArrayList<String> d = req.get("verifiedBy");
					for (String verifiedByName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addVerifiedBy(new Link(getRequirementByName(verifiedByName).getAbout()));
					}
				}
				if (req.keySet().contains("refinedBy")) {
					// for the current derived name
					ArrayList<String> d = req.get("refinedBy");
					for (String refinedByName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addRefinedBy(new Link(getRequirementByName(refinedByName).getAbout()));
					}
				}
				if (req.keySet().contains("satisfiedBy")) {
					// for the current derived name
					ArrayList<String> d = req.get("satisfiedBy");
					for (String satisfiedByName : d) {
						// get the requirement which has this derived key
						getRequirementByName(req.get("name").get(0))
								.addSatisfiedBy(new Link(getRequirementByName(satisfiedByName).getAbout()));
					}
				}

			}
		}

	}

	public static Requirement getRequirementByAbout(URI about) {
		for (Requirement r : requirements) {
			if (r.getAbout().toString().equals(about.toString())) {
				return r;
			}
		}
		return null;
	}
	
	public static List<Requirement> getRequirements() {
		return requirements;
	}

	public static List<RequirementCollection> getRequirementCollections() {
		return requirementCollections;
	}
}
