
 
 package chatbot;
//harsh chatbot
public class ChatbotAbid implements Topic{
	
	private String[] keywords;
	private String goodbyeKeyword;
	private String response;
	private boolean saidLike;
	private boolean comWon;
	private boolean playerWon;
	
	private int winCounter;
	private int loseCounter;
	
	public ChatbotAbid() {
		String [] temp = {"late","classwork","food"};
		saidLike = false;
		keywords = temp;
		goodbyeKeyword = "goodbye";
		response = "";
		comWon = true;
		playerWon = true;
	}
	public void talk(String response) {
		ChatbotMain.print("You're really starting to piss me off");
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			//talking to chatbot
			
			ChatbotMain.print("I'm going to kill you. Here's a gun we're dueling");
			
			ChatbotMain.print("Do you know how to play?");
			response = ChatbotMain.getInput();
			if(ChatbotMain.yesInterpreter(response)){
				ChatbotMain.print("Sure you do. Type \"0\" to load \"1\" to shoot an \"2\" to guard");
			}
			else {
				ChatbotMain.print("I work at Tech so I don't explain anything");
				ChatbotMain.print("But I will tell you, type \"0\" to load \"1\" to shoot an \"2\" to guard ");
			}
			ChatbotMain.print("Whomever wins 3 games first is the champion. Oh and since you're trash I'll count ties as a loss for me. You ready?");
			response = ChatbotMain.getInput();
			ChatbotMain.print("That's what I like to hear.YOURE GOING DOWN. JUST LIKE YOUR AVERAGE.");
			while(comWon && playerWon) {
				Duel duel = new Duel();
				boolean gameWinner = duel.dukeItOut();
				
				if(gameWinner) {
					winCounter++;
					if(winCounter == 1) {
						ChatbotMain.print("My grandma could you beat you and she doesn't even speak Spanish");
					}
					if(winCounter == 2) {
						ChatbotMain.print("*dabs*");
					}
					if(winCounter == 3) {
						ChatbotMain.print("I TOLD YOU I COULD WIN DAD WHOS A DISGRACE TO THE FAMILY NOW");
						comWon = false;
					}
				}
				else {
					loseCounter++;
					if(loseCounter == 1) {
						ChatbotMain.print("minus 5 on that test you took last week");
					}
					if(loseCounter == 2) {
						ChatbotMain.print("I can see why everybody talks about you behind your back.");
					}
					if(loseCounter == 3) {
						ChatbotMain.print("*calls a number* Make it look like an accident.");
						playerWon = false;
					}
	
				}
			}
				//play duel
			
			ChatbotMain.print("Do you like this class?");
			response = ChatbotMain.getInput();
				if(ChatbotMain.yesInterpreter(response)){
					ChatbotMain.print("You better like this class");
					ChatbotMain.print("What else do you like?");
					ChatbotMain.getInput();
				}
				else {
					ChatbotMain.print("*puts 0 into your pupilpath*");
					ChatbotMain.print("Then what do you like?");
					ChatbotMain.getInput();
					
				}
				while(saidLike == false)
					if(ChatbotMain.findKeyword(response, "like", 0) >= 0) {
						int likePsn = ChatbotMain.findKeyword(response, "like", 0);
						String like = response.substring(likePsn+5);
						ChatbotMain.print("Oh you like " + like + ", that explains why you're single");
						saidLike = true;
					}
					else {
						ChatbotMain.print("Nah what was that? I want your answer in a sentence.");
						response = ChatbotMain.getInput();
					}
				ChatbotMain.print("You're putting me to sleep and I'm not even real.");
				ChatbotMain.print("But anyways you got any more questions about homework, tests, or policy? Or do you just want to say bye?");
				ChatbotMain.chatbot.restartChat(ChatbotMain.getInput());
			}
		ChatbotMain.print("GET OUTTA MY FACE " + ChatbotMain.chatbot.getUsername().toUpperCase() + " !");
		}	
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
