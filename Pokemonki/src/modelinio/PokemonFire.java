package modelinio;

public class PokemonFire extends Pokemon {

	public PokemonFire(int AP, int DP, int maxHP) {
		super(AP, DP, maxHP);
		super.type = PokemonType.FIRE;
		super.strongAgainst = PokemonType.GRASS;
		super.weakAgainst = PokemonType.WATER;		
	}

}
