package br.com.gaalv.todo.util;

import java.math.BigDecimal;
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

    public static Optional<Long> readLong(Scanner sc) {

        try{

            var input = sc.nextLine().trim();
            return Optional.of(Long.parseLong(input));
        } catch (NumberFormatException e) {return Optional.empty();}
    }

    public static String readString(Scanner sc) {

        try {

            return sc.nextLine().trim();
        } catch (Exception e) {return "";}
    }

    public static Optional<BigDecimal> readBigDecimal(Scanner sc) {

        try {

            var input = sc.nextLine().trim();
            return Optional.of(new BigDecimal(input));
        } catch (NumberFormatException e) {return Optional.empty();}

    }
}
