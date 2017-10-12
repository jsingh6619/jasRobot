package chatbot;

public class ChatbotLord implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String response;
	private String study;
	
	public ChatbotLord() 
	{

		String[] temp = {"test","quiz","tests","quizzes","mean","score","scored"};
		keywords = temp;
		goodbyeKeyword = "bye";
		response = "";
		study = "";
	}
	
	public void talk(String response) {
		
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
		
			if(ChatbotMain.findKeyword(response, "test", 0) >= 0 || ChatbotMain.findKeyword(response, "tests", 0) >= 0 
					|| ChatbotMain.findKeyword(response, "quiz", 0) >= 0 || ChatbotMain.findKeyword(response, "quizzes", 0) >= 0) 
			{
				
				ChatbotMain.print("SOOO you have concerns about assessments. Why? Do you think you can pass???");
				response = ChatbotMain.getInput();
			
				if(ChatbotMain.yesInterpreter(response)) 
				{
					ChatbotMain.print("Ha you're funny I doubt it, but do you have any questions on test scoring in the hope of you ever passing? ");
					
					response = ChatbotMain.getInput();
					
					
					if(ChatbotMain.yesInterpreter(response)) 
					{
						
						ChatbotMain.print("Test usually have about 15 to 20 questions. 5 Short Answer and the rest Multiple Choice,"
								+ " sometimes I may make a game for you to complete in a limited amount of time. How about we play a little game?");
						response = ChatbotMain.getInput();
						
						if(ChatbotMain.yesInterpreter(response)) 
						{
							guessingGame();
						}
						
						ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
					}
					else 
					{
						ChatbotMain.print("Ooooo you think you smart huh");
						guessingGame();
						
						ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
					}
				}
				else {
					ChatbotMain.print("How do you study for exams?");
					study = ChatbotMain.getInput();
					
					studying(study);
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
			
			else {
					ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more tell me something else");
					response = ChatbotMain.getInput();
					ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
		}
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
			ChatbotMain.chatbot.startChatting();
		
		}

	
	public void guessingGame()
	{
		int chatGuess = (int) (Math.random() * 100);
		ChatbotMain.print("So based on our interaction, I've come up with a guess of what you'll get on my first test. Guess it!");
		
		response = ChatbotMain.getInput();
		
		
		while(Integer.parseInt(response) != chatGuess) 
		{
			if(Integer.parseInt(response) > chatGuess) {
				ChatbotMain.print("Too high, you really thought you were smart huh. Guess Again!");
				response = ChatbotMain.getInput();
			}
			else {
				ChatbotMain.print("Too low, Hey I didn't think you were that incompetent. Guess Again!");
				response = ChatbotMain.getInput();
			}
		}
		
		if(chatGuess < 65) {
		ChatbotMain.print("You are correct, I think you'll get a " + chatGuess + " on the first test!, Yes you're going to fail");
		
		ChatbotMain.print("How do you even study for exams?");
		study = ChatbotMain.getInput();
		
		studying(study);
		}
		
		else {
			ChatbotMain.print("You are correct, I think you'll get a " + chatGuess + " on the first test!, Wow you're going to pass be happy \\ What other boring stuff do you want to talk about" );
		}
	}
	
	
	public void studying(String response) {
		
		if(ChatbotMain.findKeyword(response, "study", 0) >= 0) {
			
			int studyPsn = response.indexOf("study");
			String study = response.substring(studyPsn + 6);
			ChatbotMain.print("The reason why you're going to fail is because you are currently " + study + ", and there are smarter strategies to increase your grade \\What other boring stuff do you want to talk about");
		}
		else if(ChatbotMain.findKeyword(response, "study by", 0) >= 0) {
			int studyPsn = response.indexOf("study by");
			String study = response.substring(studyPsn + 9);
			ChatbotMain.print("The reason why you're going to fail is because you are currently " + study + ", and there are smarter strategies to increase your grade \\What other boring stuff do you want to talk about");
		}
		else if(ChatbotMain.findKeyword(response, "i", 0) >= 0) {
			int studyPsn = response.indexOf("i");
			String study = response.substring(studyPsn + 2);
			ChatbotMain.print("The reason why you're going to fail is because you " + study + ", and there are smarter strategies to increase your grade \\What other boring stuff do you want to talk about");
		}
		else if(ChatbotMain.findKeyword(response, "with", 0) >= 0) {
			int studyPsn = response.indexOf("with");
			String study = response.substring(studyPsn + 2);
			ChatbotMain.print("The reason why you're going to fail is because you use " + study + ", and there are smarter strategies to increase your grade \\What other boring stuff do you want to talk about");
		}
		else {
			String study = response;
			ChatbotMain.print("The reason why you're going to fail is because you " + study + ", and there are smarter strategies to increase your grade \\What other boring stuff do you want to talk about");
		}
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
