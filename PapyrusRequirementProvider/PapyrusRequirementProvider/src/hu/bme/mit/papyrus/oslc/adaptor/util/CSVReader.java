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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openjena.atlas.lib.MultiMap;

import hu.bme.mit.papyrus.oslc.adaptor.data.Requirements;

public class CSVReader implements Runnable{

	private static BufferedReader buffer;

	// Reading order: id, name, text, derived, derivedFrom, tracedTo,
	// verifiedBy, refinedBy, satisfiedBy
	private static List<HashMap<String, ArrayList<String>>> multiMap = new ArrayList<HashMap<String, ArrayList<String>>>();

	static WatchService watcher;

	
	public void init() throws IOException, InterruptedException {
		watcher = FileSystems.getDefault().newWatchService();
		Path dir = Paths.get("C:\\Users\\Y\\Desktop");
		try {
			WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

			while (true) {
				final WatchKey wk = watcher.take();
				for (WatchEvent<?> event : wk.pollEvents()) {
					final Path changed = (Path) event.context();
					if (changed.endsWith("table_export.csv")) {
						System.out.println("My file has changed");
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
		for (HashMap<String, ArrayList<String>> s : multiMap) {
			System.out.println(s);
		}
	}

	public static List<HashMap<String, ArrayList<String>>> getProperties() {
		return multiMap;
	}

	public static void refreshRequirements() {

		multiMap.clear();
		
		try {
			String row;
			buffer = new BufferedReader(new FileReader("C:\\Users\\Y\\Desktop\\table_export.csv"));
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
		
		
		Requirements.initProp();
		System.out.println("Requirements init done");
		print();
		System.out.println("Print done");
		
	}

	private static void splitRows(String row) {

		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

		if (row != null) {
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
				// derived
				case 3:
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
				case 4:
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
				case 5:
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
				case 6:
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
				case 7:
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
				case 8:
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
		}
		multiMap.add(new HashMap<String, ArrayList<String>>(hashMap));
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
