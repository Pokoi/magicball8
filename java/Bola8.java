package es.esne.eop.bola8.utils;

import android.util.Log;

import java.util.Random;

/**
 * Esta clase proporcionará las respuestas de la Bola 8 de forma aleatoria
 * @author Entornos operativos y plataformas
 */
public class Bola8 {

    private static final String TAG = Bola8.class.getCanonicalName();

    /**
     * Respuestas de la Bola 8
     */
    private static final String[] MAGIC8BALL_RESPONSES={
            "en mi opinión, sí",
            "es cierto",
            "es decididamente así",
            "probablemente",
            "buen pronóstico",
            "todo apunta a que sí",
            "sin duda",
            "sí",
            "sí, definitivamente",
            "debes confiar en ello",
            "es una pregunta vaga, vuelve a intentarlo",
            "mejor pregunta en otro momento",
            "será mejor que no te lo diga ahora",
            "no puedo predecirlo ahora mismo",
            "mejor concéntrate y vuelve a preguntar",
            "no cuentes con ello",
            "no",
            "mis fuentes me dicen que no",
            "las perspectivas no son buenas",
            "es muy dudoso"
    };


    /**
     * Generación aleatoria de las respuestas
     * @return Respuesta generada de forma aleatoria
     */
    public static String getMagic8BallResponse(){

        int randomIndex = new Random().nextInt(MAGIC8BALL_RESPONSES.length);
        return MAGIC8BALL_RESPONSES[randomIndex];
    }

}
