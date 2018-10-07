package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
String [] mob=new String[5];

		//2. Add five Strings to your list
		mob[0]="100";
		mob[1]="99";
		mob[2]="98";
		mob[3]="97";
		mob[4]="96";
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < mob.length; i++) {
			//System.out.println(mob[i]);
		}
		
		//4. Print all the Strings using a for-each loop
		for (String string : mob) {
			//System.out.println(string);
		}
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < mob.length; i+=2) {
			//System.out.println(mob[i]);
		}
		//6. Print all the Strings in reverse order.
		for (int i = mob.length-1; i >= 0; i--) {
			System.out.println(mob[i]);
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < mob.length; i++) {
			
			if (mob[i].contains("e")) {
				System.out.println(mob[i]);
			}
			else {
				
			}
		}
	}
}
