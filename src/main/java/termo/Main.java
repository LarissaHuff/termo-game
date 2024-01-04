package termo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Random GERADOR = new Random();

    public static void main(String[] args) throws IOException {
        Termo termo = new Termo();
        termo.iniciaNovaTentativa(getPalavraSecreta());

        Scanner entrada = new Scanner(System.in);
        String tentativa2 = "S";
        while (true) {
            termo.printaAtual();
            System.out.println(termo.getTentativas() + 1 + " - digite sua tentativa: ");
            String tentativa = entrada.nextLine().toUpperCase();

            if (termo.tentativa(tentativa)) {
                System.out.println("Jogar novamente? S/N");
                tentativa2 = entrada.nextLine();

                if (tentativa2.equalsIgnoreCase("N")) {
                    break;
                }
                termo.iniciaNovaTentativa(getPalavraSecreta());
            }
        }
    }

    public static String getPalavraSecreta() throws IOException {
        Path path = Paths.get("palavras.txt");
        List<String> palavras = Files.readAllLines(path);
        int posicao = GERADOR.nextInt(palavras.size() - 1);
        return palavras.get(posicao);

    }
}