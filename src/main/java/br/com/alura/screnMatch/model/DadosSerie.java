package br.com.alura.screnMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true) // ignorar o que não é colocado como parametro.
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons")
Integer totalTemporadas, @JsonAlias("imdbRating") String avaliacao) {

}
