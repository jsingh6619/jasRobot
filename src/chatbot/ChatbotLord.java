package chatbot;

public class ChatbotLord implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private boolean isPassed;
	
	public ChatbotLord() {

		String[] temp = {"test","quiz","tests","quizzes"};
		
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "long";
		response = "";
	}
	
	public void talk(String response) {
		ChatbotMain.print("SOOOOO you have questions or concerns about assessments. Why? Do you think you can pass???");
			response = ChatbotMain.getInput();
			
			//doesn't work yet
			
			isPassed = false;
			int answerpsn = ChatbotMain.findKeyword(response, "yes", 0);
			
			if(answerpsn >= 0) {
				isPassed = true;
			}
			
			if(isPassed) {
				ChatbotMain.print("ha jokes you imbecile");
			}
			
			
			while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
				if(ChatbotMain.chatbot.getAbed().isTriggered(response)) {
					ChatbotMain.chatbot.getAbed().talk(response);
					break;
				}
				if(ChatbotMain.chatbot.getJasmit().isTriggered(response)) {
					ChatbotMain.chatbot.getJasmit().talk(response);
					break;
				}
				if(ChatbotMain.chatbot.getAbid().isTriggered(response)) {
					ChatbotMain.chatbot.getAbid().talk(response);
					break;
				}
				/*if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
					ChatbotMain.print("I can't even. I love pugs so much. Wow you are so cool.");
					response = ChatbotMain.getInput();
				}
				*/
				else {
					ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more tell me something else");
					response = ChatbotMain.getInput();
				}
				if(ChatbotMain.chatbot.getAbed().isTriggered(response)) {
					ChatbotMain.chatbot.getAbed().talk(response);
					break;
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
