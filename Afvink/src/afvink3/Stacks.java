/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package afvink3;
import java.util.*;
/**
 *
 * @author danis
 */
public class Stacks {
    
    public static void main(String[] args){
        System.out.println(CheckParentesis("(())[](([][]))"));
        System.out.println(CheckParentesis("(())[](([][))"));
    }
    
    public static boolean CheckParentesis(String str)
{
    if (str.isEmpty())
        return true;

    Deque<Character> stack = new LinkedList<Character>();
    for (int i = 0; i < str.length(); i++)
    {
        char current = str.charAt(i);
        if (current == '{' || current == '(' || current == '[')
        {
            stack.push(current);
        }


        if (current == '}' || current == ')' || current == ']')
        {
            if (stack.isEmpty())
                return false;

            char last = stack.peek();
            if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                stack.pop();
            else 
                return false;
        }

    }

    return stack.isEmpty();
}
    
}
