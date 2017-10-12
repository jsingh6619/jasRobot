package chatbot;

public class ChatbotAbed implements Topic 
{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int responseCounter;
	private String emotion;

	public ChatbotAbed() 
	{
		String[] temp = {"homework"};
		keywords = temp;
		goodbyeKeyword = "bye";
		response = " ";
		responseCounter = 0;
	}
	public boolean isTriggered(String response) 
	{
		for(int i = 0; i< keywords.length;i++)
		{
			///IMPORTANT(on rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;
	}
	private void greeter()
	{
		ChatbotMain.print("Hey has your day been good or bad" +  ChatbotMain.chatbot.getUsername());
		emotion = ChatbotMain.getInput();
		if(ChatbotMain.yesInterperter(emotion))
		{
			ChatbotMain.print("Good to hear");
		}
		else if(ChatbotMain.noInterperter(emotion))
		{
			ChatbotMain.print("I hope your day gets better.");
		}
	}
	private void talkPolicy(String s) 
	{
		ChatbotMain.print("So what do you want to learn about? Weight? How long does homework take to do?");
		s = ChatbotMain.getInput();
		
	}
	private void annoyedHelper() 
	{
		
		
	}
	private void giveResources(String s) 
	{
		ChatbotMain.print("First of all are you even doing your homework??");
		if(ChatbotMain.yesInterperter(ChatbotMain.getInput()))
		{
			annoyedHelper();
		}

	}
	public void talk(String response) 
	{
		greeter();
		ChatbotMain.print("Would you like to learn more about the polices or do you need help with the homework?");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, "policy",  0) >=0 )
			{
				talkPolicy(response);
			}
			else if(ChatbotMain.findKeyword(response, "homework help", 0) >= 0)
			{
				giveResources(response);
			}
			else
			{
				ChatbotMain.print("Please pick policy or homework help");
				ChatbotMain.getInput();
				responseCounter++;
				if(responseCounter == 5)
				{
					ChatbotMain.print("I am a nice guy but your not getting help.");
					ChatbotMain.chatbot.restartChat("Food");
				}
			}
			
		}
		//access variables	frOm other classes
		
		ChatbotMain.print("Nice talkin to u" + ChatbotMain.chatbot.getUsername() + "!");
	}
	
	

}