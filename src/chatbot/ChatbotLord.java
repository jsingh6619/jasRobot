package chatbot;

public class ChatbotLord implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotLord() {
		String[] temp = {"stuff","things","whatever","nothing"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
	}
	
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that.So tell me something");
			response = ChatbotMain.getInput();
			while(ChatbotMain.findKeyword(response, secretKeyword, 0) == -1) {
				if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("I can't even. I love pugs so much. Wow you are so cool.");
					response = ChatbotMain.getInput();
				}
				else {
					ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more tell me something else");
					response = ChatbotMain.getInput();
				}
			}
			
			//way to access variables from other classes
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
			ChatbotMain.chatbot.startChatting();
		}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			if(ChatbotMain.findKeyword(response,keywords[i],0) >= 0 ) {
				return true;
			}
		}
		return false;
	}
	
}
