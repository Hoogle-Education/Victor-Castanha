import java.util.Arrays;
import java.util.List;

public class Test {  
  public static void main(String[] args) {

    Integer[] array = {2, 3, 4, 5, 7};

    List<Integer> list = Arrays.asList(array);

    list.forEach(System.out::println);

  }
}