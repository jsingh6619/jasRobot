package chatbot;

public class Chatbot {
	
	private String username;
	private boolean chatting;
	private Topic jasmit;
	private Topic abed;
	private Topic abid;
	private Topic lord;
	private Topic jas;

	public Chatbot() {
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
		return jas;
	}
	
	
	public void startChatting() 
	{
		//whenever you print or get input, use these methods
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
