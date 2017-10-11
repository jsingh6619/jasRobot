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
		String[] temp = {"homework"};
		keywords = temp;
		goodbyeKeyword = "bye";
		response = " ";
		responseCounter = 0;
	}
	//public void 
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
	private void talkPolicy() 
	{
		ChatbotMain.print("So what do you want to learn about? Weight? How long does homework take to do?");
		
		
	}
	private void giveResources() 
	{
		
	}
	public void talk(String response) 
	{
		ChatbotMain.print("Would you like to learn more about the polices or do you need help with the homework?");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1)
		{
			if(ChatbotMain.getInput().equals("policy"))
			{
				talkPolicy();
			}
			else if(ChatbotMain.getInput().equals("help"))
			{
				giveResources();
			}
			else
			{
				ChatbotMain.print("Please pick policy or homework help");
				responseCounter++;
				if(responseCounter == 5)
				{
					ChatbotMain.print("I am a nice guy but Now im seriously mad. Im so mad im changing this conversation ALL TOGETHER");
					ChatbotMain.chatbot.restartChat("Food");
				}
			}
			
		
		}
		//access variables	frOm other classes
		
		ChatbotMain.print("Nice talkin to u" + ChatbotMain.chatbot.getUsername() + "!");
	}
	
	

}
