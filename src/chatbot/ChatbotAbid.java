 package chatbot;
//harsh chatbot
public class ChatbotAbid implements Topic{
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String response;
	
	
	public ChatbotAbid() {
		String [] temp = {"late","classwork","food",""};
		
		keywords = temp;
		goodbyeKeyword = "bye";
		response = "";
	}
	public void talk(String response) {
		ChatbotMain.print("You're really starting to piss me off");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			//talking to chatbot
			
			ChatbotMain.print("I'm going to kill you. Here's a gun we're dueling");
			
			ChatbotMain.print("Do you know how to play?");
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, "yes", 0) >= 0){
				ChatbotMain.print("Okay good. Type \"0\" to load \"1\" to shoot an \"2\" to guard");
			}
			else {
				ChatbotMain.print("I work at Tech so I don't explain anything");
				ChatbotMain.print("But I will tell you, type \"0\" to load \"1\" to shoot an \"2\" to guard ");
			}
			ChatbotMain.print("You ready?");
			response = ChatbotMain.getInput();
			ChatbotMain.print("That's what I like to hear");
			
			Duel duel = new Duel();
			boolean isMyAlgorithmAmazing = duel.dukeItOut();
			//play duel
			
			if(isMyAlgorithmAmazing) {
				ChatbotMain.print("HAH TAKE THAT L");
			}
			else {
				ChatbotMain.print("I can see why everybody talks about you behind your back.");
			}
			
			ChatbotMain.print("Do you like this class?");
			response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, "yes", 0) >= 0){
					ChatbotMain.print("You better like this class");
					ChatbotMain.print("What else do you like?");
					ChatbotMain.getInput();
				}
				else {
					ChatbotMain.print("*puts 0 into your pupilpath*");
					ChatbotMain.print("Then what do you like?");
					ChatbotMain.getInput();
					
				}
	
					if(ChatbotMain.findKeyword(response, "like", 0) >= 0) {
						int likePsn = response.indexOf("like");
						String like = response.substring(likePsn+5);
						ChatbotMain.print("Oh you like " + like + ", that explains why you're single");
						response = ChatbotMain.getInput();
					}
					else {
						ChatbotMain.print("Alright be like that.");
					}
			
				}
			
			ChatbotMain.print("You're putting me to sleep and I'm not even real. Talk about something else " + ChatbotMain.chatbot.getUsername() + " !");
		
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

