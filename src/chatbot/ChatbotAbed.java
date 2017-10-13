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
		ChatbotMain.print("Hey has your day been good or bad" + " " + ChatbotMain.chatbot.getUsername());
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
			emotion = ChatbotMain.getInput().toLowerCase();
		}
	}
	private void talkPolicy(String s) 
	{
		ChatbotMain.print("So what do you want to learn about? Weight? How long does homework take to do?");
		s = ChatbotMain.getInput().toLowerCase();
		if(ChatbotMain.findKeyword(s, "weight",  0) >=0 )
		{
			ChatbotMain.print("Homework is worth 20% of your grade");
		}
		else if(ChatbotMain.findKeyword(s, "long",  0) >=0 )
		{
			ChatbotMain.print("Homework takes 30 minutes to do. So please do it.");
		}
		else
		{
			ChatbotMain.print("Ask about weight or length of homework.");
		}
		ChatbotMain.print("You can say bye and leave or talk about classwork or tests. You can also get the general about page.");
		ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
		
	
	}
	private void annoyedHelper() 
	{
		ChatbotMain.print("I expected better. You have to work harder.");
		if(ChatbotMain.yesInterpreter(emotion))
		{
			ChatbotMain.print("Your day should not be going so well if you ain't working hard.");
		}
		if(ChatbotMain.noInterpreter(emotion))
		{
			ChatbotMain.print("Of course your day is not going well. If you did your homework then maybe it would have gone better.");
		}
	}
	private void compationateHelper()
	{
		ChatbotMain.print("I am proud you are doing your work. Keep it up.");
		if(ChatbotMain.yesInterpreter(emotion))
		{
			ChatbotMain.print("It is awesome your having a good day. I bet it is gonna be better with my help!");
		}
		if(ChatbotMain.noInterpreter(emotion))
		{
			ChatbotMain.print("Don't worry if your day hasn't gone so well. Maybe with my help, your day is gonna get better.");
		}
	}
	private void giveResources(String response) 
	{
		ChatbotMain.print("First of all are you even doing your homework??");
		response  = ChatbotMain.getInput().toLowerCase();
		if(ChatbotMain.noInterpreter(response))
		{
			annoyedHelper();
		}
		if(ChatbotMain.yesInterpreter(response))
		{
			compationateHelper();
		}
		ChatbotMain.print("Well tell me are you struggling with git or java concepts?");
		response = ChatbotMain.getInput().toLowerCase();
		if(response.contains("java") )
		{
			ChatbotMain.print("Well I hope this helps! go to tutorialspoint.com/java/");
		}
		else if(response.contains("git"))
		{
			
			ChatbotMain.print("Well I hope this helps! go to git-scm.com/docs ");
		}
		else
		{
			ChatbotMain.print("Please pick java or git.");
		}
		ChatbotMain.print("You can say bye and leave or talk about classwork or tests. You can also get the general about page.");
		ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());

	}
	public void talk(String response) 
	{
		greeter();
		ChatbotMain.print("Would you like to learn more about the polices or do you need help with the homework?");
		response = ChatbotMain.getInput().toLowerCase();
		while(ChatbotMain.findKeyword(response.toLowerCase(), goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findKeyword(response.toLowerCase(), "policy",  0) >=0 )
			{
				talkPolicy(response);
			}
			else if(ChatbotMain.findKeyword(response.toLowerCase(), "homework help", 0) >= 0)
			{
				giveResources(response);
			}
			else
			{
				response = ChatbotMain.getInput().toLowerCase();
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