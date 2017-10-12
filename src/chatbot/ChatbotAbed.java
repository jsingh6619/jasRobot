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
		if(ChatbotMain.yesInterpreter(emotion))
		{
			ChatbotMain.print("Good to hear");
		}
		else if(ChatbotMain.noInterpreter(emotion))
		{
			ChatbotMain.print("I hope your day gets better.");
		}
		else
		{
			ChatbotMain.print("Umm can u say good or bad");
			emotion = ChatbotMain.getInput();
		}
	}
	private void talkPolicy(String s) 
	{
		ChatbotMain.print("So what do you want to learn about? Weight? How long does homework take to do?");
		s = ChatbotMain.getInput();
		
	}
	private void annoyedHelper() 
	{
		ChatbotMain.print("I expected better. You have to work harder.");
		if(ChatbotMain.yesInterpreter(emotion))
		{
			ChatbotMain.print("YOur day should not be going so well if you ain't working hard.");
		}
		if(ChatbotMain.noInterpreter(emotion))
		{
			ChatbotMain.print("Of course your day is not going well. If you did your homework then maybe it would have gone better.");
		}
	}
	private void giveResources(String s) 
	{
		ChatbotMain.print("First of all are you even doing your homework??");
		if(ChatbotMain.noInterpreter(ChatbotMain.getInput()))
		{
			annoyedHelper();
		}
		ChatbotMain.print("Well tell me are you struggling with Git or java concepts?");
		s = ChatbotMain.getInput();
		if(ChatbotMain.findKeyword(s, "git",  0) >=0 )
		{
			ChatbotMain.print("Well I hope this helps! https://git-scm.com/docs ");
		}
		else if(ChatbotMain.findKeyword(s, "java",  0) >=0 )
		{
			ChatbotMain.print("Use this.http://introcs.cs.princeton.edu/java/11cheatsheet/");
		}
		else
		{
			ChatbotMain.print("Please pick java or git.");
		}
		

	}
	public void talk(String response) 
	{
		greeter();
		ChatbotMain.print("Would you like to learn more about the polices or do you need help with the homework?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
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
				response = ChatbotMain.getInput();
				ChatbotMain.print("Please pick policy or homework help");
				responseCounter++;
				if(responseCounter == 5)
				{
					ChatbotMain.print("I am a nice guy but your not getting help.");
					ChatbotMain.chatbot.restartChat("food");
				}
			}
			
		
		}
		//access variables	frOm other classes
		
		ChatbotMain.print("Nice talkin to u" + ChatbotMain.chatbot.getUsername());
		ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
	}
}