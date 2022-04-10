import java.io.File;
import java.util.*;

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
			staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], ft.parse(data[3]), Float.parseFloat(data[4]), ft.parse(data[5]));
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
		

		String answer;
		System.out.print("You want to add new Staff? (S/N) : ");
		answer = in.nextLine();

		while(answer.equalsIgnoreCase("N")){

			// meu codigo

			System.out.print("You want to add new Staff? (S/N) : ");
			answer = in.nextLine();

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
			if( ! staffs[end+1].getSName().equalsIgnoreCase(sNameToFind) ) 
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



