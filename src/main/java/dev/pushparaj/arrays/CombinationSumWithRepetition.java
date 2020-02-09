package dev.pushparaj.arrays;

import java.util.*;

/*
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