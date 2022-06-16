package question1;

import java.math.BigInteger;
import java.util.Arrays;

public class Q1_D {
  
  public static void main(String[] args) {
    
    BigInteger[] clifford = new BigInteger[42];
    Arrays.fill(clifford, new BigInteger("-1"));
    
    BigInteger[] fibonacci = new BigInteger[1001];
    Arrays.fill(fibonacci, new BigInteger("-1"));

    iterativeClif(clifford);
    iterativeFib(fibonacci);

    for(int i=0; i<fibonacci.length; i++){
      if(clifford[i].equals(new BigInteger("-1"))) break;

      if(clifford[i].equals(fibonacci[i])){
        System.out.println("Fib[" + i + "] == Clif [" + i + "] == " + clifford[i]);
      }
    }

  }

  private static void iterativeFib(BigInteger[] fibonacci){

    // base cases
    fibonacci[0] = new BigInteger("0");
    fibonacci[1] = new BigInteger("1");

    for(int i=2; i<fibonacci.length; i++){
      fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
    }

  }

  private static void iterativeClif(BigInteger[] clifford) {
    // bottom up solution

    // base cases
    clifford[0] = new BigInteger("0");
    clifford[1] = new BigInteger("1");

    for(int i=2; i < 40 ; i++ ){
      BigInteger op;
      
      if(i%2 == 0){
        op = clifford[i-1].add(clifford[i-2].multiply(new BigInteger("2")));
      } else {
        op = clifford[i-1].multiply(clifford[i-2]);
      }
    
      clifford[i] = op;
    }

  }

}
