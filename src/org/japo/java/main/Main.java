/* 
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        final int MIN_PESO = 0;
        final int MAX_PESO = 250;
        final int NUM_DIAS = 7;
        final String[] DIA = {"Lunes", "Martes", "Miércoles",
            "Jueves", "Viernes", "Sábado", "Domingo"};

        //Variables
        boolean exitLoop;
        double pesoDia;
        double pesoTotal = 0;
        double pesoMedio;
        int numDia;

        //Bucle principal
        for (numDia = 0; numDia < NUM_DIAS; numDia++) {
            //Reiniciamos el bucle del peso para el siguiente día de la semana.
            exitLoop = false;

            //Bucle del peso.
            do {
                try {
                    //Bloque principal
                    System.out.printf("Día semanal.....................: "
                            + "%s.%n", DIA[numDia]);
                    System.out.printf("Introduzca el peso del día .....: ");
                    pesoDia = SCN.nextDouble();

                    //Comprobamos que se encuentra en el rango pertinente.
                    if (pesoDia >= MIN_PESO && pesoDia <= MAX_PESO) {
                        //Si así es, sumaremos el valor al peso total.
                        pesoTotal += pesoDia;

                        //Y le devolveremos la siguiente línea al usuario.
                        System.out.printf(Locale.ENGLISH,
                                "Usted pesa hoy .................: "
                                + "%03.2f.%n%n", pesoDia);

                        //Además, saldremos del bucle.
                        exitLoop = true;
                    } else {
                        //Pero si el valor está fuera del rango creado, al aire.
                        System.out.printf("ERROR: "
                                + "El peso introducido no se encuentra en el "
                                + "rango esperado (0-250kg).%n"
                                + "Por favor, vuelva a intentarlo.%n");
                    }
                } catch (Exception e) {
                    //Si el usuario intenta liarla, se lo evitaremos.
                    System.out.printf("ERROR: El valor introducido no es un "
                            + "número válido.%n"
                            + "Recuerde separar los decimales con un punto, "
                            + "no con una coma.%n");
                } finally {
                    //¡LIMPIA SIEMPRE EL BÚFER, CEPORRO!
                    SCN.nextLine();
                }
            } while (exitLoop == false);
        }
        //Ya una vez terminado el bucle, devolvemos la media y nos salimos.
        pesoMedio = pesoTotal / NUM_DIAS;
        System.out.printf(Locale.ENGLISH,
                "%nEl peso medio semanal es de ....: %03.2fkg.%n",
                pesoMedio);
    }
}
