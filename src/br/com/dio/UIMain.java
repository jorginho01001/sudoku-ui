package br.com.dio;

import br.com.dio.ui.custom.screen.MainScreen;

import java.util.stream.Stream;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class UIMain {

    public static void main(String[] args) {
        // Verificar se os args não estão vazios
        if (args == null || args.length == 0) {
            System.out.println("Nenhum argumento passado.");
            return;
        }

        // Processar os args e dividir com segurança
        final var gameConfig = Stream.of(args)
                .collect(toMap(
                        k -> {
                            // Verificar se o argumento está no formato esperado
                            String[] parts = k.split(";");
                            if (parts.length != 2) {
                                throw new IllegalArgumentException("Formato de argumento inválido: " + k);
                            }
                            return parts[0]; // Retorna a chave (x,y)
                        },
                        v -> {
                            // Verificar se o argumento está no formato esperado
                            String[] parts = v.split(";");
                            if (parts.length != 2) {
                                throw new IllegalArgumentException("Formato de argumento inválido: " + v);
                            }
                            return parts[1]; // Retorna o valor (número,fixed)
                        }
                ));

        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }
}
