package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

//        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
//        Cozinha cozinha = new Cozinha();
//        cozinha.setId(1L);
        //cozinhaRepository.remover(cozinha);


        // scanner to read the values of array, and the value of the days
        Scanner input = new Scanner(System.in);
        int[] arr = new int[8];
        int days;
        // {1, 0, 0, 0, 0, 1, 0, 0}, 1 -> 0 1 0 0 1 0 1 0
        // {1, 1, 1, 0, 1, 1, 1, 1}, 2 -> 0 0 0 0 0 1 1 0

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Cell: " + (i + 1) + ":");
            arr[i] = input.nextInt();
        }

        System.out.println("Number of days: ");
        days = input.nextInt();
        int[] arr2 = cellCompete(arr, days);

        System.out.println("Result: ");
        Arrays.stream(arr2).forEach(s -> System.out.print(s + " "));
    }

    public static int[] cellCompete(int[] states, int days) {
        // if the number of states are less the 8 or the days are less than 1
        // returns the states
        if (states.length < 8 || days < 1) {
            return states;
        }

        // an array to store the old values from the array
        int[] newStates = new int[8];

        for (int d = 0; d < days; d++) {

            // copying the values to the new one
            for (int y = 0; y < states.length; y++) {
                newStates[y] = states[y];
            }

            // if the second value of the array is 1, the first value will be
            // 0, because the unoccupied cells are always 0
            if (newStates[1] == 1) {
                states[0] = 1;
            } else {
                states[0] = 0;
            }

            // using XOR operation (^), will be true (1) only if the
            // two entries are different
            for (int x = 1; x <= states.length - 2; x++) {
                states[x] = newStates[x - 1] ^ newStates[x + 1];
            }

            // if the penultimate value of the array is 1, the last value will be
            // 0, because the unoccupied cells are always 0

            // i need to know which is the value of penultimate cell
            // so i get the length of the states and subtract 2 because
            // the array starts in 0
            if (newStates[states.length - 2] == 1) {
                states[states.length - 1] = 1;
            } else {
                states[states.length - 1] = 0;
            }
        }

        return states;
    }


}
