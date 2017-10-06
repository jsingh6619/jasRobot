package chatbot;

public class Chatbot 
{	
	private String username;
	private boolean chatting;
	private ChatbotJasmit jasmit;
	private ChatbotAbed abed;
	private ChatbotAbid abid;
	private ChatbotLord lord;
	private String last;
	private int repetition;

	public Chatbot() 
	{
		jasmit = new ChatbotJasmit();
		abed = new ChatbotAbed();
		abid = new ChatbotAbid();
		lord = new ChatbotLord();
		username = "Unknown User";
		chatting  = true;
		repetition = 0;
		last = "";
	}

	//Made by Abed & written by Abid (10/04/2017)
	//Modified to function fully by Jasmit (10/05/2017)
	public void restartChat(String response) 
	{
		chatting = true;
		while(chatting)
		{	
			if(last.equals(response)) 
			{
				chatting = false;
				getJasmit().repeated(response, repetition++);
			}
			else if(jasmit.isTriggered(response)) 
			{
				last = response;
				repetition = 0;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getJasmit().talk(response);
			}
			else if(abed.isTriggered(response)) 
			{
				last = response;
				repetition = 0;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getAbed().talk(response);
			}
			else if(abid.isTriggered(response))
			{
				last = response;
				repetition = 0;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getAbid().talk(response);
			}
			else if(lord.isTriggered(response)) 
			{
				last = response;
				repetition = 0;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getLord().talk(response);
			}
			else 
			{
				last = response;
				repetition = 0;
				ChatbotMain.print("Uhhhhh, I'm not sure how to respond to that right now. Lets talk about something else. Do you have any questions about the homework, classwork, tests/quizzes, of the class?");
				response = ChatbotMain.getInput();
			}
		}
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
	
	public void startChatting() 
	{
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		ChatbotMain.print("What would you like to talk about " + username + "?");
		restartChat(ChatbotMain.getInput());
	}
}