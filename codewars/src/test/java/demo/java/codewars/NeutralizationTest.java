package demo.java.codewars;

import org.junit.Assert;
import org.junit.Test;

import static demo.java.codewars.Neutralization.neutralize;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class NeutralizationTest {
    @Test
    public void test1() {
        assertThat(neutralize("Mg(OH)2", "HCl"), is("Mg(OH)2 + 2HCl \u2192 MgCl2 + 2H2O"));
    }

    @Test
    public void test2() {
        assertThat(neutralize("NH4OH", "H2SO4"), is("2NH4OH + H2SO4 \u2192 (NH4)2SO4 + 2H2O"));
    }

    @Test
    public void test3() {
        assertThat(neutralize("Os(OH)4", "H2CO"), is("Os(OH)4 + 2H2CO \u2192 Os(CO)2 + 4H2O"));
    }

    @Test
    public void test4() {
        assertThat(neutralize("H3BO3", "Th(OH)4"), is("4H3BO3 + 3Th(OH)4 \u2192 Th3(BO3)4 + 12H2O"));
    }

    @Test
    public void test5() {
        assertThat(neutralize("Ga(OH)2", "H4P2O7"), is("2Ga(OH)2 + H4P2O7 \u2192 Ga2P2O7 + 4H2O"));
    }
    public void test6() {
        assertNull(neutralize("Cu(OH)2", "Hg(OH)2"));
    }
    @Test
    public void shouldPassHardcodedTests() {
        System.out.println("Testing spec: should pass hardcoded tests");
        assertThat(neutralize("HCl", "NaOH"), is("HCl + NaOH \u2192 NaCl + H2O"));
        assertThat(neutralize("H2SO4", "Ca(OH)2"), is("H2SO4 + Ca(OH)2 \u2192 CaSO4 + 2H2O"));

        assertThat(neutralize("H3BO3", "Th(OH)4"), is("4H3BO3 + 3Th(OH)4 \u2192 Th3(BO3)4 + 12H2O"));
        assertThat(neutralize("La(OH)3", "HNO2"), is("La(OH)3 + 3HNO2 \u2192 La(NO2)3 + 3H2O"));

        // Ammonia specific tests
//        System.out.println("- Ammonium Hydroxide explicit tests (ammonia, NH3, diluted in aqueous solutions)");
//        KnownCompound ammonia = knownByType.get(Type.Base).stream().filter(c -> c.formula.equals("NH4OH")).findAny().orElseThrow(() -> new IllegalStateException("Corrupted compounds collection; it must contain ammonium hydroxide"));
//        assertThat(
//                String.format("%s cannot react with itself", ammonia.name),
//                neutralize(ammonia.formula, ammonia.formula),
//                is(nullValue())
//        );
//        assertThat(
//                String.format("%s cannot react with another base", ammonia.name),
//                neutralize(ammonia.formula, "Mg(OH)2"),
//                is(nullValue())
//        );
//        assertThat(
//                String.format("%s should react with hydrochloric acid yielding ammonium chloride and water", ammonia.name),
//                neutralize(ammonia.formula, "HCl"),
//                is("NH4OH + HCl \u2192 NH4Cl + H2O")
//        );
//        assertThat(
//                String.format("%s should react with sulfuric acid yielding ammonium sulfate and water", ammonia.name),
//                neutralize(ammonia.formula, "H2SO4"),
//                is("2NH4OH + H2SO4 \u2192 (NH4)2SO4 + 2H2O")
//        );
//        assertThat(
//                String.format("%s should react with phosphoric acid yielding ammonium phosphate and water", ammonia.name),
//                neutralize(ammonia.formula, "H3PO4"),
//                is("3NH4OH + H3PO4 \u2192 (NH4)3PO4 + 3H2O")
//        );
    }

    @Test
    public void test11() {
        Assert.assertNull(neutralize("NaOH", "KOH"));       // null, because base cannot react with base
        Assert.assertNull(neutralize("HBrO3", "HIO4"));
    }
    @Test
    public void testFormula() {
        System.out.println(Neutralization.process("NH4OH", 0));
        System.out.println(Neutralization.process("Th(OH)4", 0));
        System.out.println(Neutralization.process("HCl", 0));
        System.out.println(Neutralization.process("H2SO4", 0));
    }
}
