package br.com.alura.screnMatch.service;

public interface IconverteDados {
	// Usando Generics
	<T> T obterDados(String json, Class<T> classe );

}
