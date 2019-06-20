package br.ufjf.dcc193.trabalho03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.ufjf.dcc193.trabalho03.Models.*;
import br.ufjf.dcc193.trabalho03.Persistence.*;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		ConfigurableApplicationContext ctx;
		EtiquetaRepository repositorioEtiqueta;
		UsuarioRepository repositorioUsuario;
		ItemRepository repositorioItem;

		ctx = SpringApplication.run(MainApplication.class, args);
		repositorioEtiqueta = ctx.getBean(EtiquetaRepository.class);
		repositorioUsuario = ctx.getBean(UsuarioRepository.class);
		repositorioItem = ctx.getBean(ItemRepository.class);

		Etiqueta etiqueta1;
		Etiqueta etiqueta2;
		Etiqueta etiqueta3;

		Usuario usuario1;
		Usuario usuario2;

		Item item1;
		Item item2;
		Item item3;

		etiqueta1 = new Etiqueta("Título 1", "Descrição 1", "URL1");
		etiqueta2 = new Etiqueta("Título 2", "Descrição 2", "URL2");
		etiqueta3 = new Etiqueta("Título 3", "Descrição 3", "URL3");
		repositorioEtiqueta.save(etiqueta1);
		repositorioEtiqueta.save(etiqueta2);
		repositorioEtiqueta.save(etiqueta3);

		usuario1 = new Usuario("Usuario 1", 123, "Descrição 1", "usuario@gmail.com");
		usuario2 = new Usuario("Usuario 2", 123, "Descrição 2", "usuario2@gmail.com");
		repositorioUsuario.save(usuario1);
		repositorioUsuario.save(usuario2);

		item1 = new Item("Item1");
		item2 = new Item("Item2");
		item3 = new Item("Item3");
		repositorioItem.save(item1);
		repositorioItem.save(item2);
		repositorioItem.save(item3);

	}

}
