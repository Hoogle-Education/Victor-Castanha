package question1;

import java.math.BigInteger;
import java.util.Arrays;

public class Q1_A {
  
  public static void main(String[] args) {
    
    BigInteger[] clifford = new BigInteger[50];

    // colocando todas as posições valendo -1
    // -1 pode ser interpretado como estado desconfigurado da sequencia
    Arrays.fill(clifford, new BigInteger("-1"));

    // for (int i=0; i<50; i++) clifford[i] = new BigInteger("-1");

    iterativeClif(clifford);
    int pos = 0;

    for(BigInteger integer : clifford){
      
      // se for -1 quer dizer que esta desconfigurado / nao calculado
      if(integer.equals(new BigInteger("-1"))) break;

      System.out.println("Iterative_Clifford[" + pos++ + "]:" + integer);
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
