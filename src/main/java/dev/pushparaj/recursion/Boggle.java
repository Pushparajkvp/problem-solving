package dev.pushparaj.recursion;

import java.util.*;

/*
Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.

Output:  Following words of dictionary are present
         GEEKS
         QUIZ
*/
public class Boggle {

    private static TrieNode rootNode = new TrieNode();

    public static void find(char[][] table, String[] dictionary) {
        for(int it = 0; it < dictionary.length; it++)
            insert(dictionary[it]);
        
        int rowCount = table.length;
        int colCount = table[0].length;

        boolean[][] visited = new boolean[rowCount][colCount];
        for(int row = 0; row < rowCount; row++) 
            for(int col = 0; col < colCount; col++) 
                if(rootNode.map.containsKey(table[row][col]))
                    find(table, rootNode.map.get(table[row][col]), table[row][col] + "", visited, row, col);
    }

    public static void find(char[][] table, TrieNode node, String str, boolean[][] visited, int row, int col) {
        if(node.endOfString)
            System.out.println(str);

        int maxRowIndex = table.length - 1;
        int maxColIndex = table[0].length - 1;

        if(row > maxRowIndex || row < 0 || col > maxColIndex || col < 0)
            return;

        visited[row][col] = true;

        //top left
        if(row > 0 && col > 0 && !visited[row - 1][col - 1] && node.map.containsKey(table[row - 1][col - 1])) {
            find(table, node.map.get(table[row - 1][col - 1]), str + table[row - 1][col - 1], visited, row - 1, col - 1);
        }
        //top
        if(row > 0 && !visited[row - 1][col] && node.map.containsKey(table[row - 1][col])) {
            find(table, node.map.get(table[row - 1][col]), str + table[row - 1][col], visited, row - 1, col);
        }
        //top right
        if(row > 0 && col < maxColIndex && !visited[row - 1][col + 1] && node.map.containsKey(table[row - 1][col + 1])) {
            find(table, node.map.get(table[row - 1][col + 1]), str + table[row - 1][col + 1], visited, row - 1, col + 1);
        }

        //right
        if(col < maxColIndex && !visited[row][col + 1] && node.map.containsKey(table[row][col + 1])) {
            find(table, node.map.get(table[row][col + 1]), str + table[row][col + 1], visited, row, col + 1);
        }
        //right bottom
        if(row < maxRowIndex && col < maxColIndex && !visited[row + 1][col + 1] && node.map.containsKey(table[row + 1][col + 1])) {
            find(table, node.map.get(table[row + 1][col + 1]), str + table[row + 1][col + 1], visited, row + 1, col + 1);
        }
        //bottom
        if(row < maxRowIndex && !visited[row + 1][col] && node.map.containsKey(table[row + 1][col])) {
            find(table, node.map.get(table[row + 1][col]), str + table[row + 1][col], visited, row + 1, col );
        }
        //bottom left
        if(row < maxRowIndex && col > 0 && !visited[row + 1][col - 1] && node.map.containsKey(table[row + 1][col - 1])) {
            find(table, node.map.get(table[row + 1][col - 1]), str + table[row + 1][col - 1], visited, row + 1, col - 1);
        }
        //left
        if( col > 0 && !visited[row][col - 1] && node.map.containsKey(table[row][col - 1])) {
            find(table, node.map.get(table[row][col - 1]), str + table[row][col - 1], visited, row, col - 1);
        }
        visited[row][col] = false;
    } 

    private static void insert(String word) {
        TrieNode node = rootNode;
        for(int it = 0; it < word.length(); it++) {
            Character chr = word.charAt(it);
            if(node.map.containsKey(chr)) {
                node = node.map.get(chr);
                node.count++;
            } else {
                TrieNode newNode = new TrieNode();
                node.map.put(chr, newNode);
                node = newNode;
                node.count++;
            }
        }

        node.endOfString = true;
    }

    public static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean endOfString = false;
        int count = 0;
    }
}