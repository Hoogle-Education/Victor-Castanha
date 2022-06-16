package question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Staff;
import utilities.InsertionController;

public class Q2_C {

	public static void main(String[] args) throws Exception {
		// parsing and reading the CSV file data into the film (object) array
		// provide the path here...
		File directory = new File("");
		String path = directory.getAbsolutePath() + "\\Staff.csv";
		File file = new File(path);
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

		Staff[] staffs = new Staff[10000];
    Scanner sc = new Scanner(System.in);
		int i = 0;

		// this will just print the header in CSV file
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;

			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], ft.parse(data[3]),
						Float.parseFloat(data[4]), ft.parse(data[5]));
			}

      List<InsertionController> threadPool = new ArrayList<>();

      for(i = 0; i < 6; i++){
        threadPool.add(new InsertionController(i, staffs));
        threadPool.get(i).start();
        
        try {
          Thread.sleep(2000);
        } catch (InterruptedException exception){
        }
      }
      
      System.out.println("-----------------");

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}