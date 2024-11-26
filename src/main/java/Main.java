import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> pessoas = new ArrayList<>();

        System.out.println("Digite os nomes e sexo separados por vírgula (exemplo: Ana,F):");
        System.out.println("Digite 'fim' para encerrar a entrada.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fim")) {
                break;
            }
            pessoas.add(input);
        }


        List<String> mulheres = pessoas.stream()
                .filter(pessoa -> {
                    String[] partes = pessoa.split(",");
                    return partes.length == 2 && partes[1].trim().equalsIgnoreCase("F");
                })
                .map(pessoa -> pessoa.split(",")[0])
                .collect(Collectors.toList());


        System.out.println("Lista de mulheres:");
        mulheres.forEach(System.out::println);
    }
}