package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {

		//Scanner
		Scanner input = new Scanner(System.in);

		//Global variables
		double stringToNumber;

		//Prompt the user for input/store input
		System.out.println("Enter a series of Earth weights (space-separated):");
		String userInputAsString = input.nextLine();
		String[] stringArray = userInputAsString.split(" ");	//make a String array and add user input into that array
		double[] integerArray = new double[stringArray.length]; //create an Integer array of length equal to the String array

		//Perform the conversions
		//go through each item in the string array;
		//parse each item in the string as an integer
		//perform conversion on integer and store temporarily in an integer variable (stringToNumber)
		//add stringToVariable to integer array

		for(int i=0; i<stringArray.length; i++) {
			stringToNumber = Double.parseDouble(stringArray[i]);
			stringToNumber *= (double).378; // Converts integer stored in stringToNumber to martian weight
			integerArray[i] = stringToNumber;
			System.out.println(stringArray[i] + " lbs. on Earth, is " + integerArray[i] + " lbs. on Mars."); //print out statement String array[i] + "lbs.on Earth, is " + integer array[i] + " lbs.on Mars."

		}

	}

}
