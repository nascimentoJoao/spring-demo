package com.example.demo.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.joda.time.DateTime;

import com.example.demo.entities.taxi.PontoTaxi;

public final class PontosTaxiSingletonDataset {

	private static PontosTaxiSingletonDataset INSTANCE;
	
	private static LinkedHashMap<Integer, PontoTaxi> DATASET;
	
	private static Integer ID_COUNT;
	
	private PontosTaxiSingletonDataset() {
		DATASET = new LinkedHashMap<>();
		createFile();
		readFile();
	}
	
	public static PontosTaxiSingletonDataset getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new PontosTaxiSingletonDataset();
		}
		
		return INSTANCE;
	}
	
	public LinkedHashMap<Integer, PontoTaxi> getDataset() {
		return DATASET;
	}
	
	public void writeDataToFile(String data) {
		File file = new File("PONTOS_TAXI");
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			writer.write(data);
			writer.close();
			
			ID_COUNT++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createFile() {
		File file = new File("PONTOS_TAXI");
		if (file.exists()) return;
		try {
			file.createNewFile();
		} catch (IOException e) {
			// Couldn't create file.
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		FileReader reader;
		Integer occurrences = 1;
		try {
			reader = new FileReader("PONTOS_TAXI");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			try {
				while((line = bufferedReader.readLine()) != null) {
					String[] parts = line.split("#");
					PontoTaxi instance = constructInstanceFromStringParts(parts);
					DATASET.put(occurrences, instance);
					occurrences++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// File not found!
			e.printStackTrace();
		}
		
		ID_COUNT = occurrences;
	}
	
	private PontoTaxi constructInstanceFromStringParts(String[] parts) {
		DateTime timeParsed = new DateTime(parts[3]);
		return new PontoTaxi(parts[0], parts[1], parts[2], timeParsed);
	} 
	
	public Integer getId() {
		return ID_COUNT;
	}
	
}
