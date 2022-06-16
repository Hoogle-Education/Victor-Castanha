package entities;
import java.util.Comparator;
import java.util.Date;

public class Staff implements Comparable<Staff>{

	// atributos
	private int empNo;
	private String fName;
	private String sName;
	private Date birthDate;
	private float wage;
	private Date hireDate;

	// constructor
	public Staff(int empNo, String fName, String sName, Date birthDate, float wage, Date hireDate) {
		super();
		this.empNo = empNo;
		this.fName= fName;
		this.sName= sName;
		this.birthDate= birthDate;
		this.wage = wage;
		this.hireDate = hireDate;
	}

	// setters and getters
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getWage(){
		return wage;
	}

	public void setWage(float wage){
		this.wage = wage;
	}

		// so the film objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the title of the film
	@Override
	public int compareTo(Staff obj) {

	 	Staff other = (Staff)obj;

		int expression1 = sName.compareToIgnoreCase( other.getSName() );

		if(expression1 >= 1 )
			return 1;
		else	if( expression1 <= -1 )
			return -1;
		else{
			int expression2; //Second Name are the same
			if( this.empNo > other.getEmpNo() )
			expression2 = 1; //sorting by Employee Number if the empNo (first element)
							 //is bigger than the empNo (second element), print out 1
			else if(empNo < other.getEmpNo() )
			expression2 = -1; //sorting by Employee Number if the empNo (first element)
							 //is smaller than the empNo (second element), print out -1
			else expression2 = 0; //if the empNo is the same.

			return expression2;
		}
	}

	@Override
	public String toString() {
		return "Staff [EmpNo= " + empNo + ", first name=" + fName+ ", last Name=" + sName+ ", birth date="
				+ birthDate+  ", wage=" + wage+ ", hire date="
				+ hireDate+ "]" + "\n";
	}

	public String toFile(){
		return empNo + "," + fName + "," + sName + "," + birthDate + "," + wage + "," + hireDate + "\n";
	}


	// nested classes
	// seu objetivo era fornecer diversos modelos de comparação
	// com a Comparator, porém uma classe a principio so poderia
	// implementar a comparator uma univa vez

	public static class SortEmpNo implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return Integer.compare(o1.empNo, o2.empNo);
		}
	}

	public static class SortFirstName implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.fName.compareToIgnoreCase(o2.fName);
		}
	}

	public static class SortSecondName implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.sName.compareToIgnoreCase(o2.sName);
		}
	}

	public static class SortBithDate implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.birthDate.compareTo(o2.birthDate);
		}
	}

	public static class SortWage implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return Float.compare(o1.wage, o2.wage);
		}
	}

	public static class SortHireDate implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.hireDate.compareTo(o2.hireDate);
		}
	}	

}
