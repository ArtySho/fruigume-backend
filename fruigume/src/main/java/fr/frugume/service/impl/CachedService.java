package fr.frugume.service.impl;

import java.util.Date;

/**
 * Service générique gérant le cache sur les données referentielles.
 * 
 * @author bensmaine hakim.
 */
abstract class CachedService {
    /**
     * Taux de rafraichissement des données. 90mn en millisecondes.
     */
    private static final long REFRESH_RATE_MS = 90 * 60 * 1000;

    /**
     * Date de fraicheur des données.
     */
    private static Date dataFreshness;

    static void updateDataFreshness() {
        dataFreshness = new Date();
    }

    /**
     * Vérifie la fraicheur des données.
     *
     * @return true si les données sont récentes, false si elles sont périmées.
     */
    boolean areDataExpired() {
        return dataFreshness == null || new Date().getTime() > dataFreshness.getTime() + REFRESH_RATE_MS;
    }
}
