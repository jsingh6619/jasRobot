/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

public class CharacterB implements Dueler 
{
    private int HP;
    private String name;

    public CharacterB()
    {
        name = "Some Ugly Kid";
    } 
    public String getName()
    {
        return name;
    }
    public void setStartingHP(int HP)
    {
        this.HP = HP;
    }
    public int getHP()
    {
        return HP;
    }
    public boolean determineIfOpponentIsFair(Dueler d, int target)
    {
        if(d.getHP() == target)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public int getAction(Object caller)
    {
        if(caller instanceof Duel) 
        {
        	String response = ChatbotMain.getInput();
        	if(response.equals("0")){
        		return 0;
        	}
        	if(response.equals("1")){
        		return 1;
        	}
        	if(response.equals("2")){
        		return 2;
        	}
        }
        return 3;
    }
    public void hit(Object caller)
    {
        HP -= 10;
    }
}
   
