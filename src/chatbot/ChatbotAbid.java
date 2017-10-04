 package chatbot;
//harsh chatbot
public class ChatbotAbid implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotAbid() {
		String [] temp = {"whacky"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "late";
		response = "";
	}
	
          
	public void talk(String response) {
		ChatbotMain.print("");		
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("I'M NOT MAD. STOP TALKING BEFORE I FAIL YOU.");
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("YOU'RE BORING.");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("GET OUT OF MY FACE" + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
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
