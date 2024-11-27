package br.com.alura.screnMatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screnMatch.model.DadosEpisodio;
import br.com.alura.screnMatch.model.DadosSerie;
import br.com.alura.screnMatch.model.DadosTemporada;
import br.com.alura.screnMatch.service.ConsumoApi;
import br.com.alura.screnMatch.service.ConverteDado;
import principal.Main;

@SpringBootApplication
public class ScrenMatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciando classes.
	// Dasos serie	Passando todo trabalho para a classe Main com o metodo menu()
	ConsumoApi consumoApi = new ConsumoApi();
	var json = consumoApi.consultaApi("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
	ConverteDado converte = new ConverteDado();
	DadosSerie dados = converte.obterDados(json, DadosSerie.class);
	//System.out.println(dados);
	
	// Instanciando a classe Main
	Main principal = new Main();
	principal.menu();
	
	
	// Dados episodeo
	json = consumoApi.consultaApi("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
	DadosEpisodio episodio = converte.obterDados(json, DadosEpisodio.class);
//	System.out.println(episodio);	

	// Dados Temporadas
//	List<DadosTemporada> listaTemporada = new ArrayList();
//	
//	for (int i = 1; i < dados.totalTemporadas(); i++) {
//         json = consumoApi.consultaApi("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
//         // Instanciando DadosTemporada
//         DadosTemporada dadosTemporada = converte.obterDados(json, DadosTemporada.class);
//         listaTemporada.add(dadosTemporada);
//	}
//	listaTemporada.forEach(System.out::println);
		
		
	}

}
