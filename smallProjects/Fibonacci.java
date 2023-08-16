package smallProjects;

public class Fibonacci {
    // Function to print the fibonacci series
    static int fib(int n){
        // Base Case
        if (n <= 1)
           return 1;
 
        // Recursive call
        return fib(n - 2) + fib(n - 1);    
    }

    // Function to print N Fibonacci Number
    public static int fibonacci(int N)
    {
        int num1 = 0, num2 = 1, num3 = 0;
        int counter = 0;
 
        // Iterate till counter is N
        while (counter < N) {
            // Swap
            num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }

        return num3;
    }
 
    // Driver Code
    public static void main(String args[])
    {
        // Given Number N
        int N = 10;
 
        // Print 
        System.out.println("The number is " + fib(N) + ".");    
        System.out.println("The number is " + fibonacci(N) + ".");   
    }
}
