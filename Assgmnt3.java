package edu.cpp.cs.cs140.assgmnt3;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;

/**
 * Created by ronaldtran on 2/25/17.
 */
public class Assgmnt3 {

    public static void main(String[] args) {

        factor( 7, 49);

        if (prime(8)) {
            System.out.println(8 + " is a prime number");
        } else {
            System.out.println(8 + " is not a prime number");
        }

        gcd(46, 108);

        printPrimeFactors(42);

        isPerfect(6);

        amicable(220, 284);

        isMersennePrime(7);

        int[] arrayNums = {9,8,3,7,9,8,3,4,5,7,8,9};
        int[] arrayNums2 = {2,7,5,3,6,4,7,4,3};
        System.out.println(occr(arrayNums, 9));


        int[] primesArray = primes(arrayNums);
        for (int count = 0; count < primesArray.length; count++){
            System.out.println(primesArray[count]);
        }

        System.out.println(mode(arrayNums));

        System.out.println(indexOfMax(arrayNums));

        //System.out.println(primeFactors(6));
        int[] a = primeFactors(6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        a = reverse(arrayNums);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        a = append(arrayNums, arrayNums2);
        System.out.println(Arrays.toString(a));

        a = subArray(arrayNums, 1,5);
        System.out.println(Arrays.toString(a));

        prettyPrint(arrayNums);

    }

    /**
     * I used an if statement with the condition y mod x. If the remainder is zero than it would print that x is a
     * factor of y
     * @param x is a factor of y if the result form y mod x is 0
     * @param y
     * @return it will return if it is true or false whether x is a factor of y
     */


    private static boolean factor(int x, int y) {
        if (y % x == 0) {
            System.out.println(x + " is a factor of " + y);
            return true;
        } else {
            System.out.println(x + " is not a factor of " + y);
            return false;
        }
    }

    /**
     * I declared i as an integer and then used a for loop. The initial int is 2, the condition i < x, and then I
     * incremented i
     * @param x is an int and if x mod i is equal to 0 than it would return false
     * @return we put return true outside of the for loop so that if the for loop broke it would return true.
     */

    private static boolean prime(int x) {
        int i;
        for (i = 2; i < x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * I used an if statement to check whether x or y is less than the other because we want to use the smaller number
     * to check for the divisors.
     * @param x I checked if either x or y is the GCD of the two numbers first because many times the smaller number
     * can be the GCD. If either number is the GCD it would stop there and print i.
     * @param y if no number is found (if 0 is one of the number) then it would print no GCD could be found.
     * @return It would return i
     */

   private static int gcd(int x, int y)  {
        int i;
        if (x < y) {
            i = x;
        } else {
            i = y;
        }

        for (; i >= 1; --i) {
            if (x % i == 0 && y % i == 0) {
                System.out.println(i);
                return i;
            }
        }
       System.out.println("No GCD could be found.");
        return -1;
   }


    /**
     * I used a for loop withe the initial condition as i = 1, the condition i <= x, and pre incremented i with an if
     * statement to check for factors. I then called back to my prime method to check which factors if x were prime.
     * I would then print out all of i.
     * @param x is an integer
     */

   private static void printPrimeFactors(int x) {
       int i;
       for (i = 1; i <= x; ++i) {
           if (x % i == 0) {
               if (prime(i)) {
                   System.out.println(i);
               }

           }
       }

   }

    /**
     * I first made variable sum = 0. I then used a for loop with the initial condition of 1, condition i <= x/2, and
     * a pre incremented i with an if statement, together these game me the factors of x. I then added i to sum to
     * check if the sum would be equal to x. If so, then it would print x is a perfect number.
     * @param x
     * @return It would return true if the sum is equal to x and it would return false if the sum was not equal to x.
     */

   private static boolean isPerfect(int x) {
        int i;
        int sum = 0;
        for (i = 1; i <= x / 2; ++i) {
            if (x % i == 0) {
                sum = sum + i;
            }
        } if (sum == x) {
           System.out.println(x + " is a perfect number.");
           return true;
       } else {
           System.out.println(x + " is not a perfect number.");
           return false;
       }
   }

    /**
     * I realize now that I could have called my isPerfect method and for this method. I did the same thing as the
     * isPerfect method but instead I set sum equal to y.
     * @param x
     * @param y
     * @return
     */

   private static boolean amicable(int x, int y) {
        int i;
        int sum = 0;
        for (i = 1; i <= x / 2; ++i) {
            if (x % i == 0) {
                sum = sum + i;
            }
        } if (sum == y) {
            System.out.println("These are amicable numbers");
            return true;
       } else {
           System.out.println("These are not amicable numbers");
           return false;
       }
   }

    /**
     * I used a for loop to check all the numbers leading to x and then I created a testing number with type double
     * = to the formula for Mersenne numbers. I then tested if x was equal to it and if it is prime.
     * @param x is an int
     * @return I returned true if x is equal to the testing number and it is prime. If not it would return false
     */
   private static boolean isMersennePrime(int x) {
       int i;
       for (i = 1; i <= x; ++i) {
           double testingNumber = (Math.pow(2,i)) - 1;
           if (x == testingNumber && prime(x)) {
               System.out.println(x + " is a Mersenne Prime");
               return true;
           }
       }
       System.out.println(x + " is not a Mersenne Prime");
       return false;
   }

    /**
     * I used int counter and set it at zero. The for loop will go through the array and if a number is equal
     * to x and the counter will add one.
     * @param numbers
     * @param x
     * @return it will return the counter's number
     */

   private static int occr(int[] numbers, int x) {
       int counter = 0;
        for (int count = 0; count < numbers.length; count++)
           if(numbers[count] == x) {
               counter++;
           }
        return counter;
    }

    /**
     * I took an array, counted the amount of prime numbers, created a new array with only the prime numbers
     * @param numbers
     * @return
     */

    private static int[] primes(int[] numbers) {
        int primeIndex = 0;
        for (int count = 0; count < numbers.length; count++) {
            if(prime(numbers[count])) {
                primeIndex++;
            }
        } if (primeIndex == 0) {
            return null;
        }
        int[] primeArray = new int[primeIndex];
        primeIndex = 0;

        for (int count = 0; count < numbers.length; count++) {
            if(prime(numbers[count])) {
                    primeArray[primeIndex] = numbers[count];
                primeIndex++;
            }
        }
        return primeArray;
    }

    /**
     * I iterated throughout the array, counter will hold the amount of times an element is iterated,
     * and mode will hold the int. The if statement will update the counter and mode as the array is gone
     * through.
     * @param numbers
     * @return
     */

    private static int mode(int[] numbers) {
        int mode = 0;
        int counter = 0; // highest number of occurrences
        int occr = 0;
        for (int i = 0; i < numbers.length; i++) {
            occr = occr(numbers, numbers[i]);
            if(counter < occr) {
                counter = occr;
                mode = numbers[i];
            }

        } return mode;
    }

    /**
     * I found the number of rows that the pyramid will have using the first for loop.
     * The second for loop prints out the spaces.
     * The third for loop prints the numbers next to the spaces.
     * @param numbers
     */


    private static void prettyPrint(int[] numbers) {
        int x = numbers.length;
        int index = 0;
        int rows = 0;

        while(index < x){
            rows++;
            for(int numInRow=0; numInRow<rows; numInRow++){
                index++;
            }
        }

        index = 0;
        for(int i=1; i <= rows && index < x; i++){
            for(int j=0; j < (rows-i) ; j++){
                System.out.print(" ");
            }

            for(int j=0; j<i; j++){
                System.out.print(numbers[index++] + " ");
                if(index >= x){
                    break;
                }
            }
            System.out.println();
        }

    }

    /**
     * I used a for loop that went through the array, if the element inside that index is less
     * than the next index than indexofMax would be replaced by the element from the next index.
     * @param numbers
     * @return
     */

    private static int indexOfMax(int[] numbers) {
        int indexofMax = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[indexofMax] < numbers[i]) {
                indexofMax = numbers[i];
            }
        } return indexofMax;
    }

    /**
     * I figured out the prime factors of x in my first for loop, I used the amount of prime
     * factors to create a new array, and then I implemented them into the new array.
     * @param x
     * @return
     */
    private static int[] primeFactors(int x) {
        int size = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                if (prime(i)) {
                    size++;
                }
            }
        }


        int[] array = new int[size];
        int j = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                if (prime(i)) {
                    array[j] = i;
                    j++;
                }
            }
        }
        return array;


    }

    /**
     * I made an array, I used a for loop to go through the numbers array from the last index
     * and I put the elements into reverseNumbers array from the beginning.
     * @param numbers
     * @return
     */

    private static int[] reverse(int[] numbers) {
        int[] reverseNumbers = new int[numbers.length];
        int j = 0;
        for (int i = numbers.length - 1; i >= 0; --i) {
            reverseNumbers[j] = numbers[i];
            j++;
        } return reverseNumbers;
    }


    /**
     * I made an array called appendedArray. I used a for loop to go through the array xs and then I put those
     * elements in appendedArray. I did the same thing with ys.
     * @param xs
     * @param ys
     * @return
     */

    private static int[] append(int[] xs, int[] ys) {
        int[] appendedArray = new int[xs.length + ys.length];
        int j = 0;
        for (int i = 0; i < xs.length; i++) {
            appendedArray[j] = xs[i];
            j++;
        }
        for (int i = 0; i < ys.length; i++) {
            appendedArray[j] = ys[i];
            j++;
        }
        return appendedArray;
    }

    /**
     * I created a new array, then I used a for loop to go through everything between first and last.
     * I put those elements into subArray.
     * @param numbers
     * @param first
     * @param last
     * @return subArray
     */

    private static int[] subArray(int[] numbers, int first, int last) {
        int[] subArray = new int[last - first + 1];
        int j = 0;
        for (int i = first; i <= last; i++) {
            subArray[j] = numbers[i];
            j++;
        } return subArray;
    }

}

