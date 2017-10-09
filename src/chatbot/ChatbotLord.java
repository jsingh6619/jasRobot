package chatbot;

public class ChatbotLord implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotLord() {

		String[] temp = {"test","quiz","tests","quizzes"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "long";
		response = "";
	}
	
	public void talk(String response) {
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, "test", 0) >= 0) 
			{
				ChatbotMain.print("SOOOOO you have questions or concerns about assessments. Why? Do you think you can pass???");
				response = ChatbotMain.getInput();
			
				int answerpsn = ChatbotMain.findKeyword(response, "yes", 0);
				
				if(answerpsn >= 0) {
					ChatbotMain.print("Ha jokes you imbecile");
					ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
				}
			}
			else 
			{
					ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more tell me something else");
					response = ChatbotMain.getInput();
			}
		}
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
