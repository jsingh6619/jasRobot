package chatbot;

public class ChatbotJasmit implements Topic {
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int repetition;

	public ChatbotJasmit() {
		String [] temp = {"policy", "learn", "about", "teacher", "class", "course"};
		String [] pissed = {"This is a waste of time. Ask me something useful", "Stop wasting our time. I have work to grade.", "This is the last straw. If you dont stop, say goodbye to your grade."};
		String [] semiPissed = {"You already said that. Please talk about something else", "We already discussed that. So what do you want to know more about?", "I think you just learned copy and paste. Lets try typing something new."};
		String [] repeated = {"I think you mistyped, since we already talked about it", "I have no means of clarifying it further. Please ask about something else.", "You are just repeating stuff now."};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "informative";
		response = "";
		repetition = 0;
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to learn more about this class, huh? I'd love to tell you more about this course. What do you want to know?");		
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Thanks! I like to be informative and explain to you more about this class and me.");
				response = ChatbotMain.getInput();
			}
			else if(response.equals("policy")) {
				ChatbotMain.print("Thanks! I like to be informative and explain to you more about this class and me.");
				response = ChatbotMain.getInput();
			}
			else if(response.equals("learn")||response.equals("about")||response.equals("class")||response.equals("course")) {
				//improve this
				ChatbotMain.print("In this class, I will be teaching the students Computer Science.");
				response = ChatbotMain.getInput();
			}
			else if(response.equals("teacher")) {
				ChatbotMain.print("My name is Mr. Binockulars aka the quadilateral ninja. I have been teaching this class for the past 2 days. I am a very nice teacher concerning homework, but dont take my kindness for granted. In case you do bad on a quiz or a quiz, get ready to be riducled and mocked. Under any circumstance, do not mess up classwork. I will get so furious, I will hold you back for a couple of years. ");
				response = ChatbotMain.getInput();
			}
			else{
				ChatbotMain.chatbot.restartChat();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Hope you learned everything you wanted to! It was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
	}

	@Override
	public boolean isTriggered(String response) {
		for (int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
