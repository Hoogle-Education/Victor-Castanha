import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Staff implements Comparable<Staff>{

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

		int expression1 = sName.toUpperCase().compareTo(
													other.getSName().toUpperCase()
											);

		if(expression1 >= 1 )
			return 1;
		else	if( expression1 <= -1 )
			return -1;
		else{
			int expression2; //Second Name are the same
			if( empNo > other.getEmpNo() )
			expression2 = 1; //sorting by Employee Number if the empNo (first element)
							 //is bigger than the empNo (second element), print out 1
			else if(empNo < other.getEmpNo() )
			expression2 = -1; //sorting by Employee Number if the empNo (first element)
							 //is smaller than the empNo (second element), print out -1
			else expression2 = 0; //if the empNo is the same.

			return expression2;
		}

	}
/*
	 public static void main(String[] args) {
	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	try {
	 		Staff s1 = new Staff(2, "Hugo", "Rafa", dateFormat.parse("1985-11-01") , 2.0f, dateFormat.parse("1992-04-03") );
	 		Staff s2 = new Staff(2, "Victor", "Rafa", dateFormat.parse("1985-11-01") , 2.0f, dateFormat.parse("1992-04-03") );

	 		System.out.println(s1.compareTo(s2));
	 		System.out.println(s2.compareTo(s1));
	 	} catch (ParseException e) {
	 		e.printStackTrace();
	 	}
	 }
*/


// GUSTAVO WAY
/*
		if(this.sName.antes(obj.getSName())){
			return -1;
		} else if (this.sName.depois(obj.getSName())){
			return 1;
		}
		return 0;
*/
		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/


		//Staff sff = (Staff)obj;
		//return empNo - (sff.getEmpNo());


	@Override
	public String toString() {
		return "Staff [EmpNo= " + empNo + ", first name=" + fName+ ", last Name=" + sName+ ", birth date="
				+ birthDate+  ", wage=" + wage+ ", hire date="
				+ hireDate+ "]" + "\n";
	}
}
