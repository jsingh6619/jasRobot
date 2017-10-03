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
		abed = new ChatbotAbed();
		abid = new ChatbotAbid();
		lord = new ChatbotLord();
		username = "Unknown User";
		chatting  = true;
	}
	
	public void restartChat() {
		chatting = true;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public ChatbotJasmit getJasmit()
	{
		return jasmit;
	}
	
	public ChatbotAbed getAbed() 
	{
		return abed;
	}
	
	public ChatbotAbid getAbid() 
	{
		return abid;
	}
	
	public ChatbotLord getLord() 
	{
		return lord;
	}

	
	
	public void startChatting() {

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
			else if(abed.isTriggered(response)) 
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				abed.talk(response);
			}
			else if(abid.isTriggered(response))
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				abid.talk(response);
			}
			else if(lord.isTriggered(response)) 
			{
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				lord.talk(response);
			}
			else 
			{
				ChatbotMain.print("Uhhhhh, I'm not sure how to respond to that right now. Lets talk about something else. Do you have any questions about the homework, classwork, tests/quizzes, of the class?");
			}
		}
	}
}
