package demo.java.codewars;

import java.util.*;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/neutralization-reaction/train/java
 *  every compound whose formula starts with hydrogen (H) must be an acid and
 *  each that ends with a hydroxide group (OH) a base
 *
 *  the formula starts with the positively charged part of the compound and ends with the negatively charged part
 */
public class Neutralization {

    public static final int ACID = 0;
    public static final int BASE = 1;
    public static final int UNKNOWN = -1;

    static Pattern acidPattern = Pattern.compile("(H|H\\d{1})[A-Z]{1,}.*");
    static Pattern basePattern = Pattern.compile(".*(OH|\\(OH\\)\\d{1})$");
    static Pattern digitPattern = Pattern.compile("\\d");

    static List<String> atomNames;
    static {
        String atoms = "H ,He ,Li ,Be ,B ,C ,N ,O ,F ,Ne ,Na ,Mg ,Al ,Si ,P ,S ,Cl ,Ar ,K ,Ca ,Sc ,Ti" +
                " ,V ,Cr ,Mn ,Fe ,Co ,Ni ,Cu ,Zn ,Ga ,Ge ,As ,Se ,Br ,Kr ,Rb ,Sr ,Y ,Zr ,Nb ,Mo ,Tc" +
                " ,Ru ,Rh ,Pd ,Ag ,Cd ,In ,Sn ,Sb ,Te ,I ,Xe ,Cs ,Ba ,La ,Ce ,Pr ,Nd ,Pm ,Sm ,Eu ,Gd" +
                " ,Tb ,Dy ,Ho ,Er ,Tm ,Yb ,Lu ,Hf ,Ta ,W ,Re ,Os ,Ir ,Pt ,Au ,Hg ,Tl ,Pb ,Bi ,Po" +
                " ,At ,Rn ,Fr ,Ra ,Ac ,Th ,Pa ,U ,Np ,Pu ,Am ,Cm ,Bk ,Cf ,Es ,Fm ,Md ,No ,Lr ,Rf" +
                " ,Db ,Sg ,Bh ,Hs ,Mt ,Ds ,Rg ,Cn ,Nh ,Fl ,Mc ,Lv ,Ts ,Og";
        atomNames = Arrays.asList(atoms.split(" ,"));
    }
    public static String neutralize(String formula1, String formula2) {
        System.out.println(String.format("%s %s", formula1, formula2));
        Map<Integer, Formula> c = new HashMap<>();
        put(c, process(formula1, 0), process(formula2, 1));
        Formula acid = c.get(ACID);
        Formula base = c.get(BASE);
        if (acid == null || base == null) {
            return null;
        }
        int lcm = getLcm(acid.amount, base.amount);
        int am = lcm / acid.amount;
        String products = "";
        String[] source = new String[2];
        int bm = lcm / base.amount;
        String bStr = null;
        if (bm == 1) {
            bStr = base.f;
            products += base.cop;
        } else {
            bStr = String.format("%d%s", bm, base.f);
            if (!atomNames.contains(base.cop)) {
                products += String.format("(%s)%d", base.cop, bm);
            } else {
                products += String.format("%s%d", base.cop, bm);
            }

        }
        String aStr = null;
        if (am == 1) {
            aStr = acid.f;
            products += acid.cop;
        } else {
            aStr = String.format("%d%s", am, acid.f);
            if (!atomNames.contains(acid.cop)) {
                products += String.format("(%s)%d", acid.cop, am);
            } else {
                products += String.format("%s%d", acid.cop, am);
            }

        }
        source[acid.index] = aStr;
        source[base.index] = bStr;

        String reactants = String.format("%s + %s", source[0], source[1]);
        if (lcm == 1) {
            products += " + H2O";
        } else {
            products += String.format(" + %dH2O", lcm);
        }


        return reactants + " \u2192 " + products;
    }

    public static void put(Map<Integer, Formula> c, Formula ... fx) {
        for (Formula f : fx) {
            c.put(f.type, f);
        }
    }

    public static int getGcd(int m,int n){
        while(n > 0){
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    public static int getLcm(int m,int n){
        int gcd = getGcd(m,n);
        int result = m*n / gcd;
        return result;
    }

    public static Formula process(String formula1, int index) {
        Formula f = new Formula();
        f.index = index;
        f.f = formula1;
        if (formula1.startsWith("H") && acidPattern.matcher(formula1).matches()) {
            f.type = ACID;
            String acidAmount = formula1.substring(1, 2);
            if (digitPattern.matcher(acidAmount).matches()) {
                f.amount = Integer.parseInt(acidAmount);
                f.cop = formula1.substring(2);
            } else {
                f.amount = 1;
                f.cop = formula1.substring(1);
            }
        } else if (basePattern.matcher(formula1).matches()) {
            f.type = BASE;
            int length = formula1.length();
            String baseAmount = formula1.substring(length -1);
            if (digitPattern.matcher(baseAmount).matches()) {
                f.amount = Integer.parseInt(baseAmount);
                f.cop = formula1.substring(0, length - "(OH)n".length());
            } else {
                f.amount = 1;
                f.cop = formula1.substring(0, length - "OH".length());
            }
        } else {
            f.type = UNKNOWN;
        }
        return f;
    }

    static class Formula {
        int amount;
        int type;
        String cop;
        int index;
        String f;
        @Override
        public String toString() {
            return amount +
                    ", " + type +
                    ", " + cop;
        }
    }
}

