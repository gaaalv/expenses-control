package main.java.br.com.gaalv.view;

import main.java.br.com.gaalv.model.enums.TipoDespesa;
import main.java.br.com.gaalv.model.enums.TipoPagamento;
import main.java.br.com.gaalv.view.enums.EscolhaMenuPrincipal;
import main.java.br.com.gaalv.view.enums.OpcaoMenu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;
    static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public InputReader() { this.scanner = new Scanner(System.in); }

    public Optional<BigDecimal> lerBigDecimal() {
        try{
            BigDecimal input = new BigDecimal(scanner.nextLine().trim());
            if (input.signum() > 0) { // regra duplicada com Service.isValida() — revisar se mudar uma
                return Optional.of(input);
            }
            System.out.println("[INPUT_READER] Erro! Valor deve ser maior que zero.");
            return Optional.empty();
        } catch(NumberFormatException nfe) {
            System.out.println("[INPUT_READER] Erro! Dado não inserido corretamente.(BigDecimal) ID: " +
                    nfe.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Integer> lerInt() {
        try {
            var input = scanner.nextLine().trim();
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            System.out.println("[INPUT_READER] Erro! Dado não inserido corretamente.(Integer) ID: " +
                    nfe.getMessage());
            return Optional.empty();
        }
    }

    public Optional<String> lerString() {
        try{
            String input = scanner.nextLine().trim();
            return input.isEmpty() ? Optional.empty() : Optional.of(input);
        } catch(Exception e) {
            System.out.println("[INPUT_READER] Erro! Dado não inserido corretamente.(String) ID: " +
                    e.getMessage());
            return Optional.empty();
        }


    }

    private <T extends Enum<T> & OpcaoMenu> Optional<T> lerOpcaoMenu(T[] valores) {
        try {
            int input = Integer.parseInt(scanner.nextLine().trim());
            for(T valor : valores) {
                if (input == valor.getId()) return Optional.of(valor);
            }
            return Optional.empty();
        } catch (NumberFormatException nfe) {
            System.out.println("[INPUT_READER] Erro! Dado não inserido corretamente. ID: " +
                    nfe.getMessage());
            return Optional.empty();
        }
    }

    public Optional<TipoPagamento> lerTipoPagamento() {
        return lerOpcaoMenu(TipoPagamento.values());
    }

    public Optional<TipoDespesa> lerTipoDespesa() {
        return lerOpcaoMenu(TipoDespesa.values());
    }

    public Optional<EscolhaMenuPrincipal> lerEscolhaMenuPrincipal() {
        return lerOpcaoMenu(EscolhaMenuPrincipal.values());
    }

    public Optional<LocalDate> lerLocalDate() {
        try{
            String input = scanner.nextLine().trim();
            return Optional.of(LocalDate.parse(input, FORMATO_DATA));
        } catch(DateTimeParseException dtpe) {
            System.out.println("[INPUT_READER] Erro! Dado não inserido corretamente.(LocalDate) ID: " +
                    dtpe.getMessage());
            return Optional.empty();
        }
    }

    public void encerrarScanner() { scanner.close(); }
}
