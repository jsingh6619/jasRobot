package chatbot;

public class ChatbotAbed implements Topic 
{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int responseCounter;

	public ChatbotAbed() 
	{
		String[] temp = {"homework","extenstion","projects"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "incomplete";
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

	public void talk(String response) 
	{
		ChatbotMain.print("Hey! So did you do your work?");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{	
			if(ChatbotMain.findKeyword(response, secretKeyword, 0)>=0)
			{
				ChatbotMain.print("What happened?");
				response = ChatbotMain.getInput();
				responseCounter+=1;
			}
			else
			{
				ChatbotMain.print("thats cool i guees. but lets talk bout somethin else");
				response = ChatbotMain.getInput();
				responseCounter+=1;
			}
			if(responseCounter == 1)
			{
				
			}
		}
		//access variables	frim other classes
		
		ChatbotMain.print("Nice talkin to u" + ChatbotMain.chatbot.getUsername() + "!");
	}

}
