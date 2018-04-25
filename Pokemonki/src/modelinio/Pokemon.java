package modelinio;

import exceptions.BadPotionException;
import exceptions.DeadPokemonException;

public abstract class Pokemon {
	private int attackPoints;
	private int defensePoints;
	private int maxHP;
	private int currentHP;
	protected String name;
	protected String attackName;
	protected PokemonType type;
	protected PokemonType strongAgainst;
	protected PokemonType weakAgainst;
	
	public Pokemon(int AP, int DP, int maxHP){
		this.attackPoints = AP;
		this.defensePoints = DP;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
	}
	
	public void heal(int hp) throws BadPotionException, DeadPokemonException{
		if (hp < 0){
			throw new BadPotionException("Heal value can only be positive! ");
		}
		if(currentHP > 0){
			if(currentHP + hp > maxHP){
				currentHP = maxHP;
			}
			else{
				currentHP += hp;
			}
			healInfo(hp);
		}
		else{
			throw new DeadPokemonException("Pokemon is already dead!");
		}
	}
	
	public void attack(Pokemon other) throws DeadPokemonException{
		if(other.currentHP <= 0){
			throw new DeadPokemonException("Pokemon " + other.getName() + " is already dead!");
		}
		else if(currentHP <= 0){
			throw new DeadPokemonException("Pokemon " + getName() + " is already dead!");
		}
		
		else{
			int dmg = attackPoints;
			System.out.println(getName() + " used " + getAttackName() + ".");
			if (other.type.equals(this.strongAgainst)){
				dmg = (int)(dmg * 1.2);
				superEffectiveMessage();
			}
			else if (other.type.equals(this.weakAgainst)){
				dmg = (int)(dmg * 0.8);
				notEffectiveMessage();
			}
			attackInfo(dmg);
			other.getAttacked(dmg);		
		}
	}
	
	public void getAttacked(int dmg){
		dmg = dmg - (int)(defensePoints/5);
		damageTakenInfo(dmg);
		if (currentHP > dmg){
			currentHP = currentHP - dmg;
		}
		else {
			currentHP = 0;
			deadInfo();
		}		
	}
	
	private void healInfo(int hp){
		System.out.println(getName() + " healed for " + hp);
	}
	
	private void attackInfo(int dmg){
		System.out.println(getName() + " attacked for " + dmg + " damage.");
	}
	
	private void damageTakenInfo(int dmg){
		System.out.println(getName() + " took " + dmg + " damage.");
	}
	
	private final void deadInfo(){
		System.out.println(getName() + " is dead.");
	}
	
	private final void superEffectiveMessage(){
		System.out.println(getName() + " is super effective!");
	}
	
	private final void notEffectiveMessage(){
		System.out.println(getName() + " is not very effective...");
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public String getAttackName() {
		return attackName;
	}

	public PokemonType getType() {
		return type;
	}

	public PokemonType getStrongAgainst() {
		return strongAgainst;
	}

	public PokemonType getWeakAgainst() {
		return weakAgainst;
	}

}
