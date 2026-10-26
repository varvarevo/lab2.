import pokemons.Azumarill;
import pokemons.Illumise;
import pokemons.Psyduck;
import pokemons.Seel;
import pokemons.Sudowoodo;
import pokemons.Tangela;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        battle.addAlly(new Illumise("Lumi", 1));
        battle.addAlly(new Psyduck("Duckie", 1));
        battle.addAlly(new Tangela("Noodle", 1));

        battle.addFoe(new Azumarill("Bubbles", 1));
        battle.addFoe(new Sudowoodo("Woody", 1));
        battle.addFoe(new Seel("Snowball", 1));

        battle.go();
    }
}
