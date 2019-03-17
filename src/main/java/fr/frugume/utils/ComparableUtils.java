package fr.frugume.utils;

/**
 * Classe utilitaire pour différentes comparaisons.
 */
public class ComparableUtils {
    private ComparableUtils() {
    }

    /**
     * Comparaison null safe entre deux chaines de caractères.
     *
     * @param s1 String 1.
     * @param s2 String 2.
     * @return Résultat de la comparaison.
     */
    public static int safeStringCompare(String s1, String s2) {
        int result;
        if(s1 != null) {
            if (s2 != null) {
                result = s1.compareTo(s2);
            } else {
                result = 1;
            }
        } else {
            if (s2 != null) {
                result = -1;
            } else {
                result = 1;
            }
        }
        return result;
    }
}
