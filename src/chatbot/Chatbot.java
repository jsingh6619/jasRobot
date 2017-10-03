package chatbot;

public class Chatbot 
{	
	private String username;
	private boolean chatting;
	private ChatbotJasmit jasmit;
	private ChatbotAbed abed;
	private ChatbotAbid abid;
	private ChatbotLord lord;

	public Chatbot() 
	{
		jasmit = new ChatbotJasmit();
		username = "Unknown User";
		chatting = true;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public Topic getJasmit()
	{
		return jasmit;
	}
	
	public Topic getAbed() 
	{
		return abed;
	}
	
	public Topic getAbid() 
	{
		return abid;
	}
	
	public Topic getLord() 
	{
		return lord;
	}
	public Topic getJas() 
	{
		return jasmit;
	}
	
	public void startChatting() 
	{
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		
		while(chatting)
		{
			ChatbotMain.print("What would you like to talk about");
			String response = ChatbotMain.getInput();
			
			if(jasmit.isTriggered(response)) 
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				jasmit.talk(response);
			}
			if(abed.isTriggered(response)) 
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				abed.talk(response);
			}
			if(abid.isTriggered(response))
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				abid.talk(response);
			}
			if(lord.isTriggered(response)) 
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				lord.talk(response);
			}
			else 
			{
				ChatbotMain.print("I'm sorry. I dont understand. I never said I was perfect.");
			}
		}
	}
}
