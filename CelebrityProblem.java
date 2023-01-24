// In a party of N people, only one person is known to everyone. Such a person may be present at the party, 
// if yes, (s)he doesn’t know anyone at the party. We can only ask questions like “does A know B? “. 
// Find the stranger (celebrity) in the minimum number of questions. We can describe the problem input 
// as an array of numbers/characters representing persons in the party. We also have a hypothetical 
// function HaveAcquaintance(A, B) which returns true if A knows B, and false otherwise. How can we 
// solve the problem? 
// Input:MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} }
// Output: id = 2

import java.io.*;

class CelebrityProblem {
	public static void main(String[] args) {
		int[][] M = { { 0, 0, 1, 0 },
					{ 0, 0, 1, 0 },
					{ 0, 0, 0, 0 },
					{ 0, 0, 1, 0 } };

		int celebIdx = celebrity(M, 4);

		if (celebIdx == -1)
			System.out.println("No Celebrity");
		else {
			System.out.println("Celebrity ID " + celebIdx);
		}
	}
	public static int celebrity(int M[][], int n) {
		int i = 0, j = n - 1;
		while (i < j) {
			if (M[j][i] == 1) 
				j--;
			else
				i++;
		}
		int candidate = i;

		for (i = 0; i < n; i++) {
			if (i != candidate) {
				if (M[i][candidate] == 0
					|| M[candidate][i] == 1)
					return -1;
			}
		}
		return candidate;
	}
}
