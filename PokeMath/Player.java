//Sidd Rao
//Player.java

public class Player
{
	String playerName;
	int playerHealth;
	int totalHealth;
	int attack;
	public Player(String name, int health)
	{
		playerName = name;
		playerHealth = health;
		totalHealth = health;
		attack = 10;
	}
}