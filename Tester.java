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
        
        //you must write all of your code here
        
        StackInterface<Integer> firstNum = new LinkedStack<Integer>();
        StackInterface<Integer> secondNum = new LinkedStack<Integer>();
        StackInterface<Integer> resultNum = new LinkedStack<Integer>();
        
        int len1 = first.length();
        int len2 = second.length();
        int extraLen= 0;
        int lenAdd = 0;
        int result = 0;
        int carryOver = 0;
       
        
        
        for (int i = 0; i < len1; ++i) {
            int x = (Integer) (first.charAt(i) - '0');
            firstNum.push(x);
        }
    
        for (int i = 0; i < len2; ++i) {
            int x = (Integer) (second.charAt(i) - '0');
            secondNum.push(x);
        }
        
        while (!firstNum.isEmpty() || !secondNum.isEmpty()) {
            
            for (int i = 0; i < len1; ++i) {
                
                result = getNum(firstNum) + getNum(secondNum);
                
                if(carryOver != 0) {
                     result += carryOver;
                     carryOver = 0;
                }
                
                if (result >= 10) {
                    carryOver = result / 10;
                    result = result % 10;
                }
                
                resultNum.push(result);
            }
        }
                
        while (!resultNum.isEmpty())    
           System.out.print(resultNum.pop()); 
    }
    
    public static int getNum(StackInterface<Integer> s) 
    {
        if (s.isEmpty()) {
            return 0;
	} 
    	else {
            return s.pop();
	}
    }
}
