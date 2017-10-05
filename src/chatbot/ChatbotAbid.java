 package chatbot;
//harsh chatbot
public class ChatbotAbid implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotAbid() {
		String [] temp = {"late"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "mad";
		response = "";
	}
	
          
	public void talk(String response) {
		ChatbotMain.print("HIII");		
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("dont be late");
				response = ChatbotMain.getInput();
			}
			else if(ChatbotMain.findKeyword(response, "like", 0) >= 0) {
				int likePsn = response.indexOf("like");
				String like = response.substring(likePsn,response.length());
				System.out.print(like);
			}
		}
		//access variables from other classes
		ChatbotMain.print("" + ChatbotMain.chatbot.getUsername() + "!");
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
