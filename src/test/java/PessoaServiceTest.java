import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class PessoaServiceTest {

    @Test
    void deveConterSomenteMulheres() {

        List<String> pessoas = Arrays.asList(
                "Ana,F",
                "Carlos,M",
                "Maria,F",
                "João,M",
                "Clara,F"
        );


        List<String> resultadoEsperado = Arrays.asList("Ana", "Maria", "Clara");


        List<String> mulheres = PessoaService.filtrarMulheres(pessoas);


        assertEquals(resultadoEsperado, mulheres, "A lista de mulheres está incorreta!");


        assertTrue(mulheres.stream().allMatch(nome ->
                pessoas.stream().anyMatch(pessoa -> pessoa.startsWith(nome) && pessoa.contains(",F"))
        ), "A lista contém nomes que não são de mulheres!");
    }
}
