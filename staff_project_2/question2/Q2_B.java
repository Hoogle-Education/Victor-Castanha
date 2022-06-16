package question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Staff;
import utilities.InsertionSort;

public class Q2_B {

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

      int option;
      do{

        menu();
        option = sc.nextInt();

        Staff[] copy = staffs;
        InsertionSort sortedCopy = null;

        if(option == 1) sortedCopy = new InsertionSort(staffs, new Staff.SortEmpNo());
        else if (option == 2) sortedCopy = new InsertionSort(staffs, new Staff.SortFirstName());
        else if (option == 3) sortedCopy = new InsertionSort(staffs, new Staff.SortSecondName());
        else if (option == 4) sortedCopy = new InsertionSort(staffs, new Staff.SortBithDate());
        else if (option == 5) sortedCopy = new InsertionSort(staffs, new Staff.SortWage());
        else if (option == 6) sortedCopy = new InsertionSort(staffs, new Staff.SortHireDate());

        sortedCopy.sort();
        copy = sortedCopy.getStaffs();

        int pos = 0;
        for(Staff staff : copy){
          if( pos++ > 10) break;
          System.out.println(staff);
        }

      } while(option != 0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

  public static void menu (){
    System.out.println("1 - sort staffs by Employer Number");
    System.out.println("2 - sort staffs by First Name");
    System.out.println("3 - sort staffs by Second Name");
    System.out.println("4 - sort staffs by Birth Date");
    System.out.println("5 - sort staffs by Wage");
    System.out.println("6 - sort staffs by Hire Date");
    System.out.println("0 - to close the App");
    System.out.print("Choose your action: ");
  }

}