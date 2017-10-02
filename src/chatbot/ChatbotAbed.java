package chatbot;

public class ChatbotAbed implements Topic 
{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;

	public ChatbotAbed() 
	{
		String[] temp = {"stuff","things","whatever",""};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "pug";
		response = "";
		
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
		ChatbotMain.print("Hey!So u wanna talk abiut generic stuff huh?");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.findKeyword(response, secretKeyword, 0)>=0)
			{
				ChatbotMain.print("I cant even fam. i love pugs.");
				response = ChatbotMain.getInput();
			}
			else
			{
				ChatbotMain.print("thats cool i guees. but lets talk bout somethin else");
				response = ChatbotMain.getInput();
			}
		}
		//access variables	frim other classes
		ChatbotMain.print("Nice talkin to u" + ChatbotMain.chatbot.getUsername() + "!");
	}

}
