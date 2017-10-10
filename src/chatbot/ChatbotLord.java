package chatbot;

public class ChatbotLord implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotLord() {

		String[] temp = {"test","quiz","tests","quizzes","mean","score","scoring","scored"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "long";
		response = "";
	}
	
	public void talk(String response) {
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, "test", 0) >= 0 || ChatbotMain.findKeyword(response, "tests", 0) >= 0) 
			{
				
				ChatbotMain.print("SOOO you have concerns about assessments. Why? Do you think you can pass???");
				response = ChatbotMain.getInput();
			
				if(ChatbotMain.findKeyword(response, "yes", 0) >= 0 || ChatbotMain.findKeyword(response, "yea", 0) >= 0) 
				{
					ChatbotMain.print("Ha you're funny I doubt it, but do you have any questions on test scoring in the hope of you ever passing? ");
					
					response = ChatbotMain.getInput();
					
					
					if(ChatbotMain.findKeyword(response, "yes", 0) >= 0 || ChatbotMain.findKeyword(response, "yea", 0) >= 0) 
					{
						
						ChatbotMain.print("Test usually have about 15 to 20 questions. 5 Short Answer and the rest Multiple Choice, sometimes I may make a game for you to complete in a limited amount of time. How about we play a little game?");
						response = ChatbotMain.getInput();
						
						if(ChatbotMain.findKeyword(response, "yes", 0) >= 0 || ChatbotMain.findKeyword(response, "yea", 0) >= 0) 
						{
							guessingGame();
						}
						
						ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
					}
				}
			
			else if(ChatbotMain.findKeyword(response, "mean", 0) >= 0) 
			{
				ChatbotMain.print("Why do you think I'm so mean, you're not ready for this class");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
			
			else if((ChatbotMain.findKeyword(response, "score", 0) >= 0 || ChatbotMain.findKeyword(response, "scored", 0) >= 0) && (ChatbotMain.findKeyword(response, "how", 0) >= 0))
			{
				
				ChatbotMain.print("Test usually have about 15 to 20 questions. 5 Short Answer and the rest Multiple Choice, sometimes I may make a game for you to complete in a limited amount of time. How about we play a little game?");
				response = ChatbotMain.getInput();
				
				if(ChatbotMain.findKeyword(response, "yes", 0) >= 0 || ChatbotMain.findKeyword(response, "yea", 0) >= 0) 
				{
					guessingGame();
				}
				
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
			
			//play a guessing game where the chatbot randomly guessing a score they would get, make user guess that number. Also before this ask them some test taking strategies they have
			//tell them that they're strategies (copied) would work if the guessed score is above 65 and say vice versa if below 65
			
			else {
					ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more tell me something else");
					response = ChatbotMain.getInput();
					ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
		}
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
			ChatbotMain.chatbot.startChatting();
		
		}
	}
	
	public void guessingGame()
	{
		int chatGuess = (int) (Math.random() * 100);
		ChatbotMain.print("So based on our interaction, I've come up with a guess of what you'll get on my first test. Guess it!");
		
		response = ChatbotMain.getInput();
		
		
		while(Integer.parseInt(response) != chatGuess) 
		{
			if(Integer.parseInt(response) > chatGuess) {
				ChatbotMain.print("Too high, you really thought you were smarter huh. Guess Again!");
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("Too low, Hey I didn't think you were that incompetent. Guess Again!");
				response = ChatbotMain.getInput();
			}
		}
		
		if(chatGuess < 65) {
		ChatbotMain.print("You are correct, I think you'll get a " + chatGuess + " on the first test!, Yes you're going to fail");
		}
		else {
			ChatbotMain.print("You are correct, I think you'll get a " + chatGuess + " on the first test!, Wow you're going to pass be happy");
		}
	}
	
	public void studying(String response) {
		//will take in the response of what someone does to study
		//then prints thats why you got this score bc of your strategies 
		//stores users reply on how they study
		//or perhaps i could ask what resources do they use to study
		
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
