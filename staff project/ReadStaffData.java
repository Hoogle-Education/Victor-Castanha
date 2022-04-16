import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReadStaffData {

	public static void main(String[] args) throws Exception{
		//parsing and reading the CSV file data into the film (object) array
		// provide the path here...
    File directory = new File("");
  	String name = directory.getAbsolutePath() + "\\Staff.csv";
		Scanner sc = new Scanner(new File(name));
		Scanner in = new Scanner(System.in);
		Staff[] staffs = new Staff[10000];

		// this will just print the header in CSV file
		sc.nextLine();

		int i = 0; String st = "";
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		while (sc.hasNextLine())  //returns a boolean value
		{
				st = sc.nextLine();
				String[] data = st.split(",");

				Date birthDate = ft.parse(data[3]);
				String fName = data[1];

				staffs[i++] = new Staff(Integer.parseInt(data[0]), fName, data[2], birthDate, Float.parseFloat(data[4]), ft.parse(data[5]));
		}
		sc.close();  //closes the scanner


		// We can print film details due to overridden toString method in film class
		Staff[] copy = staffs;
		insertionSort(staffs, 10000);
	//Question 2

		long startPrint = System.currentTimeMillis();
		System.out.println(Arrays.toString(staffs));
		Long endPrint = System.currentTimeMillis();

		System.out.println("Time to print: " + (endPrint - startPrint) + "ms");

		staffs = copy;
		long start = System.currentTimeMillis(); // 0.7
		timeToSort(staffs, 10, start);
		staffs = copy;
		timeToSort(staffs, 100, start);
		staffs = copy;
		timeToSort(staffs, 1000, start);
		staffs = copy;
		timeToSort(staffs, 5000, start);
		staffs = copy;
		timeToSort(staffs, 10000, start);
		// we can compare films based on their ID due to overridden CompareTo method in film class

		System.out.print("Enter a second name to search: ");
		String sNameToSearch = in.nextLine();

		Staff[] search = binarySearching(staffs, sNameToSearch);

		if(search == null){
			System.out.println("Not an existing " 
											+ sNameToSearch + "!");
		} else {
			for(Staff finded : search )
				System.out.println(finded);
		}
		

		// adding staffs in list
		String answer;
		System.out.print("You want to add new Staff? Yes or No: ");
		answer = in.nextLine();

		while(!answer.equalsIgnoreCase("No")){

			if(staffs[staffs.length - 1] != null) {
				int emptyPosition = 0;
				for(Staff staff : staffs){
					if(staff == null){
						emptyPosition++;
						break;
					}
				}
				staffs[emptyPosition] = newStaff(emptyPosition, in, ft) ;
			} else {
				addMoreStaffs(staffs, newStaff(staffs.length, in, ft));
			}

			System.out.print("You want to add new Staff? (Y/N) : ");
			answer = in.nextLine();
		}
		
	}



	private static void addMoreStaffs(Staff[] staffs, Staff newStaff) {

		Staff[] copyValues = staffs;
		staffs = new Staff[staffs.length+1];
		for(int i=0; i<staffs.length-1; i++){
			staffs[i] = copyValues[i];
		}

		staffs[staffs.length-1] = newStaff;

	}



	private static void birthDate(SimpleDateFormat ft, Date birthDate) throws ParseException, IOException {
		if(birthDate.after( ft.parse("2022-04-11")) ){
			throw new IOException("below the employment age!");
		}
	}

	private static void timeToSort(Staff[] staffs, int size, long start) {
		insertionSort(staffs, size);
		long end = System.currentTimeMillis(); // 2.8

		System.out.println("Total time to " 
														+ size 
														+ " elements : " 
														+ (end-start) 
														+ "ms");
	}
	
	//INSERTION SORT
	static void insertionSort(Staff[] staffs, int size){
		
		 for(int i=1; i < size; i++){
				Staff aux = staffs[i];
				int j = i-1;
				while(j >= 0 && staffs[j].compareTo(aux) > 0){
						staffs[j+1] = staffs[j]; // em j+1 vai receber o valor que esta em j
						j--;
					}
					staffs[j+1] = aux; // vetor [j+1] recebera o valor q esta no aux
		}

	 }

	public static Staff[] binarySearching(Staff[] staffs, String sNameToFind){

		int begin = 0;
		int finish = staffs.length - 1;
		int start = 0, end = 0; // start and end of finded goals

		while( begin <= finish ){
			int mid = (begin+finish)/2;

			if( staffs[mid].getSName().equalsIgnoreCase(sNameToFind) ){
				 start = mid;
				 end = mid;
				 break;
			} else if (staffs[mid].getSName().compareTo(sNameToFind) >= 1){
				finish = mid-1;
			}else {
				begin = mid+1;
			}
		}

		while( start > 0 ){
				if( ! staffs[start-1].getSName().equalsIgnoreCase(sNameToFind) ) 
				break;
			else start--;
		}
		
		while( end < staffs.length-1 ){
			if( !staffs[end+1].getSName().equalsIgnoreCase(sNameToFind) ) 
				break;
			else end++;
		}

		int total = end - start + 1;
		Staff[] resultFinded = new Staff[total];

		for(int i=start, j=0; i<=end; i++, j++){
			resultFinded[j] = staffs[i];
		}

		return resultFinded;
	}

	public static boolean digitsOnly(String fName){

		boolean onlyDigits = true;

		for(int i=0; i<fName.length(); i++){
			char c = fName.charAt(i);
			if( c != '0' || c != '1'
			|| c != '2' || c != '3'
			|| c != '4' || c != '5'
			|| c != '6' || c != '7'
			|| c != '8' || c != '9'
			){
				onlyDigits = false;
				break;
			}
		}

		return onlyDigits;
	}

 	public static Staff newStaff(int emptyEmployerNumber ,Scanner in, SimpleDateFormat ft) throws ParseException {
		String sName, fName;
		Date birthDate, hireDate;
		float wage;

		System.out.print("Insert First Name: ");
		fName = in.nextLine();
		System.out.print("Insert Sconda Name: ");
		sName = in.nextLine();

		while(fName.isEmpty() || digitsOnly(fName)){
			System.out.println("Employee first_name cannot be empty. It cannot have only digits! Please correct this” ");
			System.out.println("Insert another first name: ");
			fName = in.nextLine();
		}

		System.out.print("Insert a birth date(dd-mm-yyyy) : ");
		birthDate = ft.parse(in.nextLine());

		System.out.print("Insert the wage: ");
		wage = in.nextFloat();
		in.nextLine();

		System.out.print("Insert a birth date(yyyy-mm-dd) : ");
		hireDate = ft.parse(in.nextLine());

		return new Staff(emptyEmployerNumber, fName, sName, birthDate, wage, hireDate);
	}
}
/*
			 int query=1;
				while(query<staffs.length)
				{
						int predecessor = query;
						while(predecessor>0 && staffs[predecessor] < staffs[predecessor-1])
						{
								int temp = staffs[predecessor];
								staffs[predecessor] = staffs[predecessor-1];
								staffs[predecessor-1] = temp;
								predecessor = predecessor-1;
						}
						query = query+1;
				}
*/
/*
//SELECTION SORT
	public static void selectionSort(Staff[] staffs) {
		for (int i = 0; i < staffs.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < staffs.length; j++) {
				if (staffs[j].compareTo(staffs[minIndex]) < 0) {
					minIndex = j;
				}
			}
			Staffs temp = staffs[i];
			staffs[i] = staffs[minIndex];
			staffs[minIndex] = temp;
		}
	}
*/



