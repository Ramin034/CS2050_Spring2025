/*
 * Stack Example
 * Add comments to explain the code
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackTest {
    public static void main(String[] args) {
    	
    	Stack<String> stack2 = new Stack<>();
    	
    	System.out.println("Pushing String: apple, pear, mango");
    	stack2.push("apple"); // this adds the String to the array
    	stack2.push("pear");
    	stack2.push("mango");
    	
    	System.out.println("stack after pushing: "+ stack2);
    	
    	String pop = stack2.pop(); // this takes out the last element that was added
    	System.out.println("Popped String: " + pop);
    	System.out.println("Stack after popping" + stack2);
    	
    	

    	
        Stack<Integer> stack = new Stack<>();


        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        

        System.out.println("Stack after pushing: " + stack);


        int popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);


        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);


        System.out.println("Is stack empty? " + stack.isEmpty());
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
        
        popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
    }
}



class Stack<T> {
	

    private ArrayList<T> items; 


    public Stack() {
        this.items = new ArrayList<>();
    }


    public boolean isEmpty() {
        return this.items.isEmpty();
    }


    public void push(T item) {
        this.items.add(item);
    }


    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size() - 1);
    }


    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(items.size() - 1);
    }


    public int size() {
        return this.items.size();
    }


    @Override
    public String toString() {
        if (!this.items.isEmpty()) {
            return "bottom ->" + this.items.toString() + "<- top";
        } else {
            return "<<empty stack>>";
        }
    }
}

