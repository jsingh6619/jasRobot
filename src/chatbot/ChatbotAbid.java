 package chatbot;
//harsh chatbot
public class ChatbotAbid implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotAbid() {
		String [] temp = {"late","classwork","food","like"};
		
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "grade";
		response = "";
	}
	public void talk(String response) {
		ChatbotMain.print("You're really starting to piss me off");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			//talking to chatbot
			
			
			
			//interconnectivity
			ChatbotMain.print("Do you like this class?");
			response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "yes", 0) >= 0){
					ChatbotMain.print("Thanks. You better like this class");
					ChatbotMain.print("What else do you like?");
					ChatbotMain.getInput();
				}
				else {
					ChatbotMain.print("Then what do you like?");
					ChatbotMain.getInput();
				}
				if(ChatbotMain.findKeyword(response, "like", 0) >= 0) {
					int likePsn = response.indexOf("like");
					String like = response.substring(likePsn+5);
					ChatbotMain.print("Oh you like " + like + ", that explains why you're single");
					response = ChatbotMain.getInput();
				}
			
			
		ChatbotMain.print("Talk about something else" + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
		}
	}
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
