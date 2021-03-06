package com.moises;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
/*Bool IsUnique(String iu) -> Implement an algorithm to determine if a string has all Unique characters.
  do not use any predefined data structures
  1
  */

    public static String stringInput="";
    public static ArrayList<Character> repeatedChars = new ArrayList<>();
    public static void main(String[] args) {
	// write your code here
        Scanner userInput = new Scanner(System.in);
        System.out.println("Write something: ");
        stringInput = userInput.nextLine();
        stringInput.trim();
        if(isUnique(stringInput)){
            System.out.println("True: The string has all unique characters");
        }else{
            System.out.println("False: There are "+repeatedChars.size() +" repeated characters: ");
           for (Character ch:repeatedChars) {
                System.out.print(ch+" ");
            }
        }
    }

    public static boolean isUnique(String input){
        ArrayList<Character> e = convertString(input);

        int currIndex=0, nextIndex=currIndex+1,count=0;
        for(int i=0; i<e.size();i++){
            currIndex = i;
            nextIndex = i+1;
            try{
                if(e.get(currIndex) == e.get(nextIndex)){
                   char tempChar = e.get(currIndex);
                    if(!repeatedChars.contains(tempChar)){
                        count++;
                        repeatedChars.add(tempChar);
                    }
                }
            }catch (Exception x) {
                nextIndex = e.size();
            }
        }

       if(count > 0){
           return false;
       }else{
           return true;
       }
    }
    public static @NotNull
    ArrayList<Character> convertString(String in){

        ArrayList<Character> c = new ArrayList<>();
        for(int a=0;a<in.length();a++){
            if(in.charAt(a) != ' '){
                c.add(in.charAt(a));
            }
        }
        Collections.sort(c);
        for (Character val:c) {
            System.out.print(val);
        }
        System.out.println("");
        return c;
    }
}
