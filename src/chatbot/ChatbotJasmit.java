
//create a public static method in which it searches for keywords
//implement findKeyword instead of indexOf
package chatbot;

public class ChatbotJasmit implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String[] repeated;

	public ChatbotJasmit() {
		String[] temp = {"policy", "learn", "about", "teacher", "class", "course"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "informative";
		String[] pear = {"I have no means of clarifying it further. Please ask about something else.", "We already discussed that. So what else do you want to know more about?", "I think you just learned copy and paste. Lets try typing something else.", "Stop wasting our time. I have work to grade.", "This is the last straw. If you dont stop, say goodbye to your grade."};
		repeated = pear;
	}

	@Override
	public void talk(String response) {
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Thanks! I like to be informative and explain to you more about this class and me. What else do you want to talk about?");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
			else if(ChatbotMain.findKeyword(response, "policy", 0) >= 0) {
				ChatbotMain.print("My policy is that every student has their own way of learning, so I do not have any standards set right now. However, at the end of the year, a final will be given in which the student has to create a program on a specific prompt. If a student fails to complete the program with all the requirements, then they will have to repeat this course. Do my policies sound fair?");
				if(ChatbotMain.findKeyword(ChatbotMain.getInput().toLowerCase(), "yes", 0) >= 0){
					ChatbotMain.print("Excellent! What else do you want to know about?");
					ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
				}
				else {
					ChatbotMain.chatbot.restartChat("bye");
				}
			}
			else if(ChatbotMain.findKeyword(response, "learn", 0) >= 0 || ChatbotMain.findKeyword(response, "about", 0) >= 0 || ChatbotMain.findKeyword(response, "class", 0) >= 0 || ChatbotMain.findKeyword(response, "course", 0) >= 0 ) {
				ChatbotMain.print("In this class, I will be teaching the students Computer Science. What else do you want to know?");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
			else if(ChatbotMain.findKeyword(response, "teacher", 0) >= 0) {
				ChatbotMain.print("My name is Mr. Binoculars. I have been teaching this class for the past 2 days. I am a very nice teacher concerning homework, but dont take my kindness for granted. In case you do bad on a quiz or a quiz, get ready to be riducled and mocked. Under any circumstance, do not mess up classwork. I will get so furious, I will hold you back for a couple of years. What else do you want to know? ");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
			else {
				ChatbotMain.print("Uhhhhh, I'm not sure how to respond to that right now. Lets talk about something else. Do you have any questions about the homework, classwork, tests/quizzes, of the class?");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
		}
		ChatbotMain.print("It was nice talking with you " + ChatbotMain.chatbot.getUsername() + "!");
		//access variables from other classes
	}

	@Override
	public boolean isTriggered(String response) {
		for (int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	public void repeated(String response, int repetition) {
		//4 is the length of the array - 1
		if(repetition < 4) {
			ChatbotMain.print(repeated[repetition]);
			ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
		}
		else {
			ChatbotMain.print("Well it was nice talking to you " + ChatbotMain.chatbot.getUsername());
			System.exit(0);
		}
	}
}