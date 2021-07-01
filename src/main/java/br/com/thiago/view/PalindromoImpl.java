package br.com.thiago.view;

import java.util.Locale;

public class PalindromoImpl implements Palindromo{

    @Override
    public String palavraContrario(String frase) {
        String fraseSemEspaco = frase.replace(" ", "").toLowerCase(Locale.ROOT);
        StringBuilder fraseInvertida = new StringBuilder();
        for (int i = fraseSemEspaco.length() - 1; i >= 0; i--) {
            fraseInvertida.append(fraseSemEspaco.charAt(i));
        }
        if(fraseSemEspaco.equals(fraseInvertida.toString())){
            return frase + " é palindromo";
        } else {
            return frase + " não é palindromo";
        }
    }
}
