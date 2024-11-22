package br.com.alura.screnMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screnMatch.model.DadosSerie;
import br.com.alura.screnMatch.service.ConsumoApi;
import br.com.alura.screnMatch.service.ConverteDado;

@SpringBootApplication
public class ScrenMatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScrenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciando classes.
		
	ConsumoApi consumoApi = new ConsumoApi();
	var json = consumoApi.consultaApi("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
	ConverteDado converte = new ConverteDado();
	DadosSerie dados = converte.obterDados(json, DadosSerie.class);
	System.out.println(dados);
		
		
		
		
		
	}

}
