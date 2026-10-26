package pokemons;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class PokemonsTest {

    @Test
    public void typesMatchPokedex() {
        assertArrayEquals(new Type[] {Type.BUG}, new Illumise("a", 1).getTypes());
        assertArrayEquals(new Type[] {Type.WATER, Type.FAIRY}, new Azumarill("a", 1).getTypes());
        assertArrayEquals(new Type[] {Type.ROCK}, new Sudowoodo("a", 1).getTypes());
        assertArrayEquals(new Type[] {Type.WATER}, new Psyduck("a", 1).getTypes());
        assertArrayEquals(new Type[] {Type.WATER}, new Seel("a", 1).getTypes());
        assertArrayEquals(new Type[] {Type.GRASS}, new Tangela("a", 1).getTypes());
    }

    @Test
    public void evolvedPokemonUsesItsOwnStats() {
        // at level 100 a stat is 2 * base + 20 (HP: 2 * base + 125)
        Pokemon sudowoodo = new Sudowoodo("a", 100);
        assertEquals(2 * 70 + 125, sudowoodo.getStat(Stat.HP), 1e-9);
        assertEquals(2 * 115 + 20, sudowoodo.getStat(Stat.DEFENSE), 1e-9);

        Pokemon tangela = new Tangela("a", 100);
        assertEquals(2 * 100 + 20, tangela.getStat(Stat.SPECIAL_ATTACK), 1e-9);
    }

    @Test
    public void classesFollowEvolutionChain() {
        assertEquals(Pokemon.class, Illumise.class.getSuperclass());
        assertEquals(Azumarill.class, Sudowoodo.class.getSuperclass());
        assertEquals(Psyduck.class, Seel.class.getSuperclass());
        assertEquals(Seel.class, Tangela.class.getSuperclass());
    }

    @Test
    public void onlyClassesWithoutChildrenAreFinal() {
        assertTrue(Modifier.isFinal(Illumise.class.getModifiers()));
        assertTrue(Modifier.isFinal(Sudowoodo.class.getModifiers()));
        assertTrue(Modifier.isFinal(Tangela.class.getModifiers()));
        assertFalse(Modifier.isFinal(Azumarill.class.getModifiers()));
        assertFalse(Modifier.isFinal(Psyduck.class.getModifiers()));
        assertFalse(Modifier.isFinal(Seel.class.getModifiers()));
    }

    @Test
    public void nameIsShownWithSpecies() {
        assertEquals("Psyduck Duckie", new Psyduck("Duckie", 1).toString());
    }
}
