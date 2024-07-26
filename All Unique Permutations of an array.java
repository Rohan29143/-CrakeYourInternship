/*All Unique Permutations of an array

Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9*/
//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[n];
        Integer[] arrArray = arr.toArray(new Integer[0]);
        Arrays.sort(arrArray);
        backtrack(result, tempList, arrArray, used);
        
        ArrayList<ArrayList<Integer>> sortedResult = new ArrayList<>();
        for (List<Integer> list : result) {
            sortedResult.add(new ArrayList<>(list));
        }
        
        return sortedResult;
    }

    private static void backtrack(Set<List<Integer>> result, List<Integer> tempList, Integer[] arr, boolean[] used) {
        if (tempList.size() == arr.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (used[i] || (i > 0 && arr[i].equals(arr[i - 1]) && !used[i - 1])) continue;
                used[i] = true;
                tempList.add(arr[i]);
                backtrack(result, tempList, arr, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
