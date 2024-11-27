package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screnMatch.model.DadosSerie;
import br.com.alura.screnMatch.model.DadosTemporada;
import br.com.alura.screnMatch.service.ConsumoApi;
import br.com.alura.screnMatch.service.ConverteDado;

public class Main {
	List<DadosTemporada> listaTemporada = new ArrayList();
	private ConverteDado converte = new ConverteDado();
	private ConsumoApi consumoApi = new ConsumoApi();
	private Scanner leitura = new Scanner(System.in);
	private static final String ENDERECO = "https://www.omdbapi.com/?t=";
	private static final String API_KEY = "&apikey=6585022c";
	
	
	public void menu() throws IOException, InterruptedException {
		System.out.println("Digite o nome da série para pesquisa: ");
		var nome = leitura.nextLine();
		var resultadoBusca = ENDERECO + nome.replace(" ", "+") + API_KEY;
		var json = consumoApi.consultaApi(resultadoBusca );
		DadosSerie dados = converte.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		
		// Temporadas
		
		
		for (int i = 1; i < dados.totalTemporadas(); i++) {
	         json = consumoApi.consultaApi("https://www.omdbapi.com/?t="+nome.replace(" ", "+") + "&season=" + i + "&apikey=6585022c");
	         // Instanciando DadosTemporada
	         DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
	         listaTemporada.add(dadosTemporada);
		}
		listaTemporada.forEach(System.out::println);
	}

}
