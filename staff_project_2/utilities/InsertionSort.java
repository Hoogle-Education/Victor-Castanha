package utilities;

import java.util.Comparator;

import entities.Staff;

public class InsertionSort {
  
  private Staff[] staffs;
  Comparator<Staff> comparator;

  public InsertionSort(Staff[] staffs, Comparator<Staff> comparator) {
    this.staffs = staffs;
    this.comparator = comparator;
  }

  public InsertionSort(Staff[] staffs) {
    this.staffs = staffs;
  }

  public void insertionSort() {
		for (int i = 1; i < staffs.length ; i++) {
			Staff aux = staffs[i];
			int j = i - 1;
			while (j >= 0 && staffs[j].compareTo(aux) > 0) {
				staffs[j + 1] = staffs[j];
				j--;
			}
			staffs[j + 1] = aux; 
		}
	}

  public synchronized void sort() {
		for (int i = 1; i < staffs.length ; i++) {
			Staff aux = staffs[i];
			int j = i - 1;
			while (j >= 0 && comparator.compare(staffs[j], aux) > 0) {
				staffs[j + 1] = staffs[j];
				j--;
			}
			staffs[j + 1] = aux; 
		}
	}

  public Staff[] getStaffs() {
    return staffs;
  }

}
