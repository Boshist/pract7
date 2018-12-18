package pract7;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class War {
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		
		Stack<Integer> P1 = new Stack<Integer>();
		Stack<Integer> P2 = new Stack<Integer>();
		
		int[] tmparr = new int[5];
		
		for (int i=4;i>-1;i--)
			tmparr[i]=read.nextInt();
		
		for (int i=0;i<tmparr.length;i++)
			P1.push(tmparr[i]);

		for (int i=4;i>-1;i--)
			tmparr[i]=read.nextInt();
		
		for (int i=0;i<tmparr.length;i++)
			P2.push(tmparr[i]);
		
		int i=0;
		
		while(true)
		{
			if (Compare(P1.peek(), P2.peek()))
			{
				
				int[] arr = new int[P1.size()+1];
				
				arr[0] = P2.pop();
				arr[1] = P1.pop();
				
				for (int j=arr.length-1;j>1;j--)
					arr[j] = P1.pop();
				
				for (int j=0;j<arr.length;j++)
					P1.push(arr[j]);
				
			}
			
			else
			{
				
				int[] arr = new int[P2.size()+1];
				
				arr[0] = P2.pop();
				arr[1] = P1.pop();
				
				for (int j=arr.length-1;j>1;j--)
					arr[j] = P2.pop();
				
				for (int j=0;j<arr.length;j++)
					P2.push(arr[j]);
				
			}
			
			if (P1.empty())
			{
				
				System.out.println("second "+(i+1));
				break;
			}
			
			if (P2.empty())
			{
				
				System.out.println("first "+(i+1));
				break;
			}
			
			if (i==106)
			{
				
				System.out.println("botva");
				break;
			}
			
			i++;
		}
		
		read.close();
	}
	
	public static boolean Compare(int first, int second) {
		
		if ((first>second) || !(first==9 && second==0) || (first==0 && second==9))
			return true;
		else
			return false;
	
	}
}
