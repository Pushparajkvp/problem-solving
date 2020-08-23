package dev.pushparaj.arrays;

import java.util.*;

/*
Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements. Repetitions and different arrangements are allowed.

Examples :

Input : arr = {1, 5, 6}, N = 7
Output : 6

Explanation:- The different ways are:
1+1+1+1+1+1+1
1+1+5
1+5+1
5+1+1
1+6
6+1

Input : arr = {12, 3, 1, 9}, N = 14
Output : 150
*/

public class CombinationSumWithRepetition {
    

    private void findCombination(List<List<Integer>> allPossibleCombinations, List<Integer> temp,int[] candidates,int start, int sum, int target) {
        if(sum == target) {
            allPossibleCombinations.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;

        for(int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            findCombination(allPossibleCombinations, temp, candidates, i, sum + candidates[i], target);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allPossibleCombinations = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        findCombination(allPossibleCombinations, temp, candidates, 0, 0, target);
        return allPossibleCombinations;
    }
}