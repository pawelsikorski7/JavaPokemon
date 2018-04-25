package modelinio;

public class PokemonWater extends Pokemon {

	public PokemonWater(int AP, int DP, int maxHP) {
		super(AP, DP, maxHP);
		super.type = PokemonType.WATER;
		super.strongAgainst = PokemonType.FIRE;
		super.weakAgainst = PokemonType.GRASS;
	}

}
