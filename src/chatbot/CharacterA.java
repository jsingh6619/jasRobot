package chatbot;

public class CharacterA implements Dueler{
	private String name;
	private int HP;
	private boolean loaded;
	
	public CharacterA() {
		name = "Mr.Binoculars";
		loaded = false;
	}
	public String getName() {
		return name;
	}
	public void setStartingHP(int hp) {
		HP = hp;	
	}
	public int getHP() {
		return HP;
	}
	public boolean determineIfOpponentIsFair(Dueler d, int hp){
		if(d.getHP() == hp){
			return true;
		}else{
			return false;
		}
	}
	public int getAction(Object caller) {
		if(caller instanceof Duel) {
			if(loaded) {
				if(Math.random() > .5) {
					loaded = false;
					return 1;
				}else {
					return 2;
				}
			}else {
				if(Math.random() > .5) {
					loaded = true;
					return 0;
				}else {
					return 2;
				}
			}
		}
		return 3;
	}

	public void hit(Object caller) {
		HP -= 10;
	}
}
