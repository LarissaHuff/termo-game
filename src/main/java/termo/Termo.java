package termo;

public class Termo {
    private String palavraSecreta;
    private int tentativas;
    private Character[] letrasDescobertas;
    private static final int MAX_TENTATIVAS = 5;

    public Termo() {
    }

    public void iniciaNovaTentativa(String palavraSecreta) {
        this.tentativas = 0;
        setPalavraSecreta(palavraSecreta);
        letrasDescobertas = new Character[palavraSecreta.length()];
        System.out.println("a palavra secreta te" +
                "m " + this.palavraSecreta.length() + " posições");

    }
    public void printaAtual() {
        for (Character a : letrasDescobertas) {
            if (a != null) {
                System.out.print(a + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("");
    }

    public boolean tentativa(String tentativa) {
        if (palavraSecreta.length() != tentativa.length()) {
            System.out.println("Palavra com tamanhos diferentes," +
                    " a palavra secreta tem " + palavraSecreta.length() + " letras.");
            return false;
        }
        tentativas++;
        if (tentativas >= MAX_TENTATIVAS) {
            System.out.println("Atingiu 5 tentativas");
            System.out.println("A palavra era... " + palavraSecreta);
            return true;
        } else if (tentativa.equals(palavraSecreta)) {
            System.out.println("Acertou");
            return true;
        } else {
            percorre(tentativa);
        }
        return false;
    }
    public void percorre(String tentativa) {
        char[] chars = tentativa.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = analisaTentativa(chars[i], i);
            System.out.print(c + " ");
        }
        System.out.println("\n");
    }

    public char analisaTentativa(char letraTentativa, int posicao) {
        if (palavraSecreta.charAt(posicao) == letraTentativa) {
            letrasDescobertas[posicao] = letraTentativa;
            return 'v';
        }

        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letraTentativa) {
                return 'a';
            }
        }

        return 'n';
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setPalavraSecreta(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
    }

}

