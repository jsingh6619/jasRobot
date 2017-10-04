//create a public static method in which it searches for keywords
//implement findKeyword instead of indexOf
package chatbot;

public class ChatbotJasmit implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

	public ChatbotJasmit() {
		String [] temp = {"policy", "learn", "about", "teacher", "class", "course"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "informative";
		response = "";
	}

	@Override
	public void talk(String response) {
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Thanks! I like to be informative and explain to you more about this class and me. What else do you want to talk about?");
				response = 
						//lord has this wait for the push
			}
			else if(response.equals("policy")) {
				ChatbotMain.print("I don't have any policies set right now. What else do you want to know?");
				break;
			}
			else if(response.equals("learn")||response.equals("about")||response.equals("class")||response.equals("course")) {
				ChatbotMain.print("In this class, I will be teaching the students Computer Science. What else do you want to know?");
				break;
			}
			else if(response.equals("teacher")) {
				ChatbotMain.print("My name is Mr. Mister. I have been teaching this class for the past 2 days. I am a very nice teacher concerning homework, but dont take my kindness for granted. In case you do bad on a quiz or a quiz, get ready to be riducled and mocked. Under any circumstance, do not mess up classwork. I will get so furious, I will hold you back for a couple of years. What else do you want to know? ");
				break;
			}
		}
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
}