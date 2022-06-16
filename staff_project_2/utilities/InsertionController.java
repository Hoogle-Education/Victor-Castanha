package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import entities.Staff;

public class InsertionController extends Thread {

  private int threadID;
  private Staff[] list;

  public InsertionController(int threadID, Staff[] staffs) {
    this.threadID = threadID;
    this.list = staffs;
  }

  @Override
  public void run() {

    InsertionSort sortMachine = null;

    if (threadID == 0)
        sortMachine = new InsertionSort(list, new Staff.SortEmpNo());
    else if (threadID == 1)
        sortMachine = new InsertionSort(list, new Staff.SortFirstName());
      else if (threadID == 2)
        sortMachine = new InsertionSort(list, new Staff.SortSecondName());
      else if (threadID == 3)
        sortMachine = new InsertionSort(list, new Staff.SortBithDate());
      else if (threadID == 4)
        sortMachine = new InsertionSort(list, new Staff.SortWage());
      else if (threadID == 5)
        sortMachine = new InsertionSort(list, new Staff.SortHireDate());
        
      try {
        synchronized (this) {
          sortMachine.sort();
          System.out.println("Printing " + threadID);
          saveAndWrite(sortMachine.getStaffs());
        }
        Thread.sleep(3000);
      } catch (InterruptedException exception) {  }
  }

  private synchronized void saveAndWrite(Staff[] sortedList) {

    System.out.println("Hello i'm " + threadID);
    File file = new File("SortedStaffs_C" + (threadID + 1) + ".csv");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

      writer.write("emp_no,first_name,second_name,birth_date,wage,hire_date\n");

      for (Staff staff : sortedList) {
        writer.write(staff.toFile());
      }

    } catch (IOException iox) {
      iox.printStackTrace();
    }

  }

}
