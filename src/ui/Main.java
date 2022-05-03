package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static BufferedReader bf = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			generateDataBase(readNames());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void generateDataBase(ArrayList<String> names) throws IOException {
		// TODO Auto-generated method stub
		String[] cities = { "Cali", "Bogotá", "Bucaramanga", "Cartagena", "Medellín", "Popayán", "Pasto", "Putumayo" };
		int namesLength = names.size() - 1;
		int citiesLength = cities.length - 1;

		BufferedWriter writer = new BufferedWriter(new FileWriter("data/personsDataBase.csv"));
		for (int i = 0; i < 100; i++) {
			int m = (int) (1 + Math.random() * namesLength);
			int c = (int) (1 + Math.random() * citiesLength);
			int x = (int) (1 + Math.random() * 4);
			writer.write(names.get(m) + "," + cities[c] + "," + x + "\n");
		}
		writer.close();
	}
	
	

	public static ArrayList<String> readNames() {
		ArrayList<String> namesDB = new ArrayList<>();

		// Reads the information from a CSV file
		try {
			// Open .csv in buffer's reading mode
			bf = new BufferedReader(new FileReader("data/names.csv"));

			// Read a file line
			String currentLine = bf.readLine();

			// if the line is not empty we keep reading the file
			while (currentLine != null) {
				namesDB.add(currentLine);
				// Read the next file line
				currentLine = bf.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the buffer reader
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return namesDB;
	}
}
