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
		ChatbotMain.print("Hey! So you want to learn more about this class, huh? I'd love to tell you more about this course. What do you want to know?");		
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Thanks! I like to be informative and explain to you more about this class and me.");
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("Probably, but I'm not sure. What else do you want to know about this class or me? ");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Hope you learned everything you wanted to! It was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
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
