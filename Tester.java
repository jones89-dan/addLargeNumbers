/**
 * Adds large numbers using Stacks of various lengths
 *
 * @author Daniel Jones
 * @version 10/6/2021
 */
public class Tester
{
    public static void main()
    {
        //first shorter
        //String first = "1";
        //String second = "2147483647";

        //second shorter
        //String first = "2147483647";
        //String second = "1";

        //same length
        String first = "2147483647";
        String second = "2147483647";

        //stacks to be used in the program.
        StackInterface<Integer> firstNum = new LinkedStack<Integer>();
        StackInterface<Integer> secondNum = new LinkedStack<Integer>();
        StackInterface<Integer> resultNum = new LinkedStack<Integer>();

        //instance variables.
        int len1 = first.length();
        int len2 = second.length();
        int result = 0;
        int carryOver = 0;

        //loop through each char in the number string, convert to int and add to the first stack.
        for (int i = 0; i < len1; ++i) {
            int x = (Integer) (first.charAt(i) - '0');
            firstNum.push(x);
        }

        //loop through each char in the number string, convert to int and add to the second stack.
        for (int i = 0; i < len2; ++i) {
            int x = (Integer) (second.charAt(i) - '0');
            secondNum.push(x);
        }

        //loop through each stack if not empty.
        while (!firstNum.isEmpty() || !secondNum.isEmpty()) {

            //calcuate the result by adding number from frist and second stack.
            result = getNum(firstNum) + getNum(secondNum);

            //add carryover if value exists and clears value.
            if(carryOver != 0) {
                result += carryOver;
                carryOver = 0;
            }

            //calculates the carry over and result.
            if (result >= 10) {
                carryOver = result / 10;
                result = result % 10;
            }

            //push result to stack.
            resultNum.push(result);
        }

        //formated outup.
        System.out.print(first + " + " + second + " = ");

        while (!resultNum.isEmpty())
           System.out.print(resultNum.pop());

        System.out.print("\n");
    }

    /**
    * Retreives int from the stack or returns zero if stack is empty.
    * @param s - stack to pop.
    * @return s.pop - popped item from the stack or zero if stack is empty.
    */
    public static int getNum(StackInterface<Integer> s)
    {
        //if stack is empty return 0, else pop the next int.
        if (s.isEmpty()) {
            return 0;
	}
    	else {
            return s.pop();
	}
    }
}
