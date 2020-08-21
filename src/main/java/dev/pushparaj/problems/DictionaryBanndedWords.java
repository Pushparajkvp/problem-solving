package dev.pushparaj.problems;

import java.util.*;


class DictionaryBannedWords {
    
    public String mostCommonWord(String paragraph, String[] banned) {
        
        
        HashSet<String> dictionary = new HashSet<>();
        HashMap<String, Integer> occurenceMap = new HashMap<String, Integer>();
        
        for(int it = 0; it < banned.length; it++)
            dictionary.add(banned[it]);
        
        StringBuilder sb = new StringBuilder();
        int wordStart = 0;
        
        String currentMaxString = "";
        int currentMaxOccurence = Integer.MIN_VALUE;
        
        for(int it = 0; it <= paragraph.length(); it++) {
            Character ch = it == paragraph.length() ? '-' : paragraph.charAt(it);
            if(!Character.isLetter(ch)) {
                String word = sb.toString();
                
                if(!dictionary.contains(word) && !word.isEmpty()) {
                    int count = occurenceMap.getOrDefault(word, 0) + 1;
                    if(count > currentMaxOccurence) {
                        currentMaxOccurence = count;
                        currentMaxString = word;
                    }
                    occurenceMap.put(word, count);
                }
                wordStart = it + 1;
                sb = new StringBuilder();
            } else{
                sb.append(Character.toLowerCase(ch));
            }
        }
        return currentMaxString;
    }
}