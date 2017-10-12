
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
	//Modified by Jasmit (10/05/2017)
	public void restartChat(String response) 
	{
		chatting = true;
		while(chatting)
		{	
			if(ChatbotMain.findKeyword(last, response, 0) >= 0) 
			{
				chatting = false;
				last = response;
				getJasmit().repeated(response, repetition++);
			}
			else if(lord.isTriggered(response)) 
			{
				last = response;
				repetition = 0;
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				getLord().talk(response);
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
			else 
			{
				last = response;
				repetition = 0;
				getJasmit().talk(response);
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
		// find a way to check the name is no more than 2 word
		// Modified by Jasmit - 10/09/2017
		ChatbotMain.print("Hi! I am Mr. Binoculars and a rhombus. Are you a new student?");
		String s = ChatbotMain.getInput().toLowerCase();
			if (ChatbotMain.findKeyword(s, "no", 0) >= 0){
				ChatbotMain.print("Sorry about that. I have so many students that I didn't recognize you. You should participate more. Tell me your name.");
				username = ChatbotMain.getInput();
				ChatbotMain.print("Ohhhh. Yeah I see your name now. So what do you want to talk about " + username+ "?");
				restartChat(ChatbotMain.getInput());
			}
			else if (ChatbotMain.findKeyword(s.toLowerCase(), "yes", 0) >= 0){
				ChatbotMain.print("It seems you haven't been updated onto my roster. Tell me your name?");
				username = ChatbotMain.getInput();
				ChatbotMain.print("Okay. I've noted it down so I'll ask my supervisor later. So what do you want to talk about " + username+ "?");
				restartChat(ChatbotMain.getInput());
			}
			
			else {
				ChatbotMain.print("It'll be easier if you answer with a yes or no. Just tell me your name and I'll figure it out.");
				username = ChatbotMain.getInput();
				ChatbotMain.print("You aren't on my roster, so you must be a new student, " + username + ". What do you want to know about?");
				restartChat(ChatbotMain.getInput());
			}
	}

}