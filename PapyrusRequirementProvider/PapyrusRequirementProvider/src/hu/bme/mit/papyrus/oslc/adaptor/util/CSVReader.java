package hu.bme.mit.papyrus.oslc.adaptor.util;

import java.io.BufferedReader;

import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import hu.bme.mit.papyrus.oslc.adaptor.data.Requirements;

public class CSVReader implements Runnable {

	private static BufferedReader buffer;

	// Reading order: id, name, text, derived, derivedFrom, tracedTo,
	// verifiedBy, refinedBy, satisfiedBy

	private static LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> multiMap = new LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>>();
	private static String modelName;

	static WatchService watcher;

	public void init() throws IOException, InterruptedException {
		watcher = FileSystems.getDefault().newWatchService();

		Path dir = Paths.get(ConfigProperties.getPropertyValue("input_folder"));
		try {
			WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

			while (true) {
				final WatchKey wk = watcher.take();
				for (WatchEvent<?> event : wk.pollEvents()) {
					final Path changed = (Path) event.context();
					if (changed.endsWith(ConfigProperties.getPropertyValue("input_file"))) {
						refreshRequirements();
					}
				}
				// reset the key
				boolean valid = wk.reset();
				if (!valid) {
					System.out.println("Key has been unregistered");
				}
			}

		} catch (IOException x) {
			System.err.println(x);
		}
	}

	public static void print() {

		for (String s : multiMap.keySet()) {
			System.out.println("modelName: " + s + "  : " + multiMap.get(s));
		}

	}

	public static LinkedHashMap<String, ArrayList<LinkedHashMap<String, ArrayList<String>>>> getProperties() {
		return multiMap;
	}

	public static String getRequirementCollectionName() {
		return modelName;
	}

	public static void refreshRequirements() {

		multiMap.clear();

		try {
			String row;
			buffer = new BufferedReader(new FileReader(ConfigProperties.getPropertyValue("input_fullpath")));
			while ((row = buffer.readLine()) != null) {
				splitRows(row);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null)
					buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Requirements.init();

	}

	private static void splitRows(String row) {

		LinkedHashMap<String, ArrayList<String>> hashMap = new LinkedHashMap<String, ArrayList<String>>();

		if (row != null && !row.contains("modelName:")) {
			String[] splitData = row.split(";");
			String[] secondSplit;

			ArrayList<String> properties = new ArrayList<String>();
			for (int i = 0; i < splitData.length; i++) {
				switch (i) {
				// id
				case 0:
					properties.add(splitData[i]);
					hashMap.put("id", new ArrayList<String>(properties));
					properties.clear();
					break;
				// name
				case 1:
					properties.add(splitData[i]);
					hashMap.put("name", new ArrayList<String>(properties));
					properties.clear();
					break;
				// text
				case 2:
					properties.add(splitData[i]);
					hashMap.put("text", new ArrayList<String>(properties));
					properties.clear();
					break;
				// master
				case 3:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("master", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				// derived
				case 4:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("derived", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				// derivedFrom
				case 5:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("derivedFrom", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				// tracedTo
				case 6:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("tracedTo", new ArrayList<String>(properties));
						properties.clear();
					}

					break;
				// verifiedBy
				case 7:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("verifiedBy", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				// refinedBy
				case 8:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("refinedBy", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				// satisfiedBy
				case 9:
					if (!splitData[i].isEmpty()) {
						secondSplit = splitData[i].split(",");
						for (int j = 0; j < secondSplit.length; j++) {
							properties.add(secondSplit[j].trim());
						}
						hashMap.put("satisfiedBy", new ArrayList<String>(properties));
						properties.clear();
					}
					break;
				}

			}
			multiMap.get(modelName).add(hashMap);
		} else if (row.contains("modelName:")) {
			modelName = row.split(": ")[1];
			multiMap.put(new String(modelName), new ArrayList<LinkedHashMap<String, ArrayList<String>>>());
		}

	}

	@Override
	public void run() {
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
