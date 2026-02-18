package br.com.gaalv.todo.util;

import java.util.Optional;
import java.util.Scanner;

public class InputReader {

    private InputReader() {}

    public static Optional<Integer> readInt(Scanner sc) {

        try{

            var input = sc.nextLine().trim();
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {return Optional.empty();}
    }
}
