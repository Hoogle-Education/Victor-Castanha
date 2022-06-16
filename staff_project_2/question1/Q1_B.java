package question1;

import java.math.BigInteger;
import java.util.Arrays;

public class Q1_B {
  
  public static void main(String[] args) {
    
    BigInteger[] clifford = new BigInteger[45];
    Arrays.fill(clifford, new BigInteger("-1"));

    recursiveClif(clifford, 40);
    int pos = 0;

    for(BigInteger integer : clifford){
      if(integer.equals(new BigInteger("-1"))) break;
      System.out.println("Recursive_Clifford[" + pos++ + "]:" + integer);
    }

  }

  private static BigInteger recursiveClif(BigInteger[] clifford, int number) {
    // top down solution

    // dinamic case
    // reduz complexidade da arvore de recursao
    // evita chamadas repetidas dos valores ja anotados
    if(!clifford[number].equals(new BigInteger("-1"))) return clifford[number];

    // base case
    if(number == 0) return clifford[number] = new BigInteger("0");
    if(number == 1) return clifford[number] = new BigInteger("1");

    // recursive cases - down case
    // "clifford[number] =" : serve para salvarmos além de retornar o resultado
    return clifford[number] = (number%2==0) ?
            (recursiveClif(clifford, number-1).add(
                            recursiveClif(clifford, number-2)
                                  .multiply(new BigInteger("2")))) 
            : (recursiveClif(clifford, number-1))
                            .multiply(recursiveClif(clifford, number-2));

  }

}
