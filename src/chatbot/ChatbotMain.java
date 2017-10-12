package chatbot;

import java.util.Scanner;

public class ChatbotMain{

	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);
	
	public static void main(String[] args) {
		chatbot.startChatting();
	}
	
	//Copied from class notes Utility class

	/**
	 * return the index of the keyword after startPsn that is isolated and has no negotiations or -1 otherwise
	 */
	////Created by Abed 
	public static boolean yesInterpreter(String s) {
<<<<<<< HEAD
		String [] yessir = {"yes","sure","okay","yeet","yeah","yea","good", };
=======
		String [] yessir = {"yes","sure","okay","yeet","yeah","yea","good","ok"};
>>>>>>> branch 'master' of https://github.com/jsingh6619/jasRobot.git
		String yes = s.toLowerCase();
		for(int i = 0; i < yessir.length;i++) {
			if(yes.equals(yessir[i])) {
				
				return true;
				
			}
		}
		
		return false;
		
	}
	///// created by abed 
    public static boolean noInterpreter(String s) {
		String [] nosir = {"no","naw","nada","bad"};
		String no = s.toLowerCase();
		for(int i = 0; i < nosir.length;i++) {
			if(no.equals(nosir[i])) {

				return true;
				
			}
		}
		return false;
		
	}
	public static int findKeyword(String searchString, String keyword, int startPsn) {
		//make lowercase
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		
		int psn = searchString.indexOf(keyword, startPsn);
		
		while(psn >= 0) {
			if(keywordIsIsolated(psn,keyword,searchString) && noNegations(searchString, psn)) {
				return psn;
			}
			else {
				psn = searchString.indexOf(keyword, psn + 1);
				//returns the index of the Next keyword
			}
		}
		return -1;
	}

	public static boolean keywordIsIsolated(int psn, String keyword, String s) {   
        
		char letterBefore;
        char letterAfter;
        try
        {
             letterBefore = s.charAt(psn-1);
        }
        catch(Exception e)
        {
             letterBefore = ' ';
        }
        
        try
        {    
             letterAfter = s.charAt(psn + keyword.length());
        }
        catch(Exception e)
        {
             letterAfter = ' ';
        }
        
        if(isLetter(letterBefore) || isLetter(letterAfter))
        {   
            return false;
        }
        else
        {
            return true;
        }
    }
	public static boolean isLetter(char letter) {
	      
		int ascii = (int) letter;
	        
	    if(ascii >= 97 && ascii <= 122) {
	    	
	        return true;
	    
	    }else{
	    	
	    	return false;
	    }
	}
	public static boolean noNegations(String s, int psn){
		try 	
		{    
			if(s.substring(psn-5,psn).equals(" not ")) {
				return false;
		    
			}
			if(s.substring(psn-4,psn).equals(" no ")) {	
				return false;
			}
	    }catch(StringIndexOutOfBoundsException e) {
	   		return true;
	    
		}
		return true;
	}
	public static String getInput(){
		return inputSource.nextLine();
	}

	public static void print(String s){
		multiLinePrint(s);
	}

	public static void multiLinePrint(String s){
		String printString = "";
		int cutoff = 25;
		//this while loop last as long as there are words left in the original String
		while(s.length() > 0){

			String currentCut = "";
			String nextWord = "";

			//while the current cut is still less than the line length 
			//AND there are still words left to add
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

				//add the next word
				currentCut += nextWord;

				//remove the word that was added from the original String
				s = s.substring(nextWord.length());

				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				//if there are no more spaces, this is the last word, so add the whole thing
				if(endOfWord == -1) {
					endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				}

				//the next word should include the space
				nextWord = s.substring(0,endOfWord+1);
			}

			printString +=currentCut+"\n";

		}
		System.out.print(printString);
	}

	public static int getIntegerInput() {
		print("Please enter an integer.");
		String integerString = getInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			}catch(NumberFormatException e){
				print("You must enter an integer. You better try again.");
				integerString = getInput();
			}
		}
		return value;
	}
}
