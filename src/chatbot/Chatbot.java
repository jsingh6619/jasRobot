package chatbot;

public class Chatbot 
{	
	private String username;
	private boolean chatting;
	private ChatbotJasmit jasmit;
	private ChatbotAbed abed;
	private ChatbotAbid abid;
	private ChatbotLord lord;
	private String[] repeated;
	private int repetition;
	private String last;

	public Chatbot() 
	{
		jasmit = new ChatbotJasmit();
		abed = new ChatbotAbed();
		abid = new ChatbotAbid();
		lord = new ChatbotLord();
		username = "Unknown User";
		chatting  = true;
		String[] temp = {"I have no means of clarifying it further. Please ask about something else.", "You are just repeating stuff now. What do you want to know?", "You already said that. Please talk about something else", "We already discussed that. So what do you want to know more about?", "I think you just learned copy and paste. Lets try typing something new.", "This is a waste of time. Ask me something useful", "Stop wasting our time. I have work to grade.", "This is the last straw. If you dont stop, say goodbye to your grade."};
		repeated = temp;
		repetition = 0;
		last = "";
	}

	////Made by Abed, written by Abid, modified by Jasmit
	public void restartChat(String response) 
	{
		chatting = true;
		while(chatting)
		{	
			if(last.equals(response)) 
			{
				repetition++;
				ChatbotMain.print(repeated[repetition]);
				response = ChatbotMain.getInput();
			}
			else if(jasmit.isTriggered(response)) 
			{
				last = response;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getJasmit().talk(response);
			}
			else if(abed.isTriggered(response)) 
			{
				last = response;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getAbed().talk(response);
			}
			else if(abid.isTriggered(response))
			{
				last = response;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getAbid().talk(response);
			}
			else if(lord.isTriggered(response)) 
			{
				last = response;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getLord().talk(response);
			}
			else 
			{
				last = response;
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
		ChatbotMain.print("What would you like to talk about?");
		restartChat(ChatbotMain.getInput());
	}
	
	public String sameReply()
	{
		String reply = "";
		reply += repeated[repetition];
		return reply;
	}
}


/*
ChatbotMain.print("Hope you learned everything you wanted to! It was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
ChatbotMain.chatbot.startChatting();
*/