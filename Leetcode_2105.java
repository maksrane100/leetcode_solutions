package com.exercises.general;


/**
 * Problem Statement:
 * 
 * 
 */
public class Leetcode_2105 {

	public Leetcode_2105() {

	}

	public int minimumRefill(int[] plant, int capacityA, int capacityB) {
		
		int lineLength = plant.length;
		
		int refill = 0;
		
		int a = capacityA;
		
		int b = capacityB;
		
		int i = 0;
		
		int j = lineLength - 1;
		
		while (i <= j) {
			
			//if both  Alice and Bob reached a same plant
			if (i == j) {
				
				//who ever has more water available, will try to water the plant
				if (a < b) {
					if (b < plant[j]) {
						b = capacityB;
						refill++;
					}
					b -= plant[j];
				} else {
					if (a < plant[i]) {
						a = capacityA;
						refill++;
					}
					a -= plant[i];
				}
			} else {
			
				if (a < plant[i]) {
					a = capacityA;
					refill++;
				}
				
				//amount "a" will decrease  by the amount of water you have given to the plant i
				a -= plant[i];
				
				if (b < plant[j]) {
					b = capacityB;
					refill++;
				}
				//amount "b" will decrease  by the amount of water you have given to the plant j
				b -= plant[j];
			}
			
			//simulating that Alice is going from Left to Right
			i++;
			//simulating that Bob is going from Right to Left
			j--;
		}
		
		return refill;
	}

	public static void main(String[] args) {
		Leetcode_2105 obj = new Leetcode_2105();

		int[] plant = { 2, 2, 3, 3 };
		
		int capacityA = 3;
		
		int capacityB = 4;

		int result = obj.minimumRefill(plant, capacityA, capacityB);

		System.out.println(result);
	}

}
