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
		AnotacaoRepository repositorioAnotacao;
		VinculoRepository repositorioVinculo;

		ctx = SpringApplication.run(MainApplication.class, args);
		repositorioEtiqueta = ctx.getBean(EtiquetaRepository.class);
		repositorioUsuario = ctx.getBean(UsuarioRepository.class);
		repositorioItem = ctx.getBean(ItemRepository.class);
		repositorioAnotacao = ctx.getBean(AnotacaoRepository.class);
		repositorioVinculo = ctx.getBean(VinculoRepository.class);

		Etiqueta etiqueta1;
		Etiqueta etiqueta2;
		Etiqueta etiqueta3;

		Usuario usuario1;
		Usuario usuario2;

		Item item1;
		Item item2;
		Item item3;

		Anotacao anotacao1;
		Anotacao anotacao2;
		Anotacao anotacao3;

		Vinculo vinculo1;
		Vinculo vinculo2;
		Vinculo vinculo3;

		etiqueta1 = new Etiqueta("Etiqueta 1", "Descrição 1", "URL1");
		etiqueta2 = new Etiqueta("Etiqueta 2", "Descrição 2", "URL2");
		etiqueta3 = new Etiqueta("Etiqueta 3", "Descrição 3", "URL3");
		repositorioEtiqueta.save(etiqueta1);
		repositorioEtiqueta.save(etiqueta2);
		repositorioEtiqueta.save(etiqueta3);

		usuario1 = new Usuario("Usuario 1", "123", "Descrição 1", "usuario@gmail.com");
		usuario2 = new Usuario("Usuario 2", "123", "Descrição 2", "usuario2@gmail.com");
		repositorioUsuario.save(usuario1);
		repositorioUsuario.save(usuario2);

		item1 = new Item("Item1");
		item2 = new Item("Item2");
		item3 = new Item("Item3");
		repositorioItem.save(item1);
		repositorioItem.save(item2);
		repositorioItem.save(item3);

		anotacao1 = new Anotacao("Anotação 1", "descricao 1", "dataInclusao1", "dataAlteracao1");
		anotacao1.setUsuario(usuario1);
		anotacao2 = new Anotacao("Anotação 2", "descricao 2", "dataInclusao2", "dataAlteracao2");
		anotacao2.setUsuario(usuario2);
		anotacao3 = new Anotacao("Anotação 3", "descricao 3", "dataInclusao3", "dataAlteracao3");
		anotacao3.setUsuario(usuario1);
		repositorioAnotacao.save(anotacao1);
		repositorioAnotacao.save(anotacao2);
		repositorioAnotacao.save(anotacao3);

		vinculo1 = new Vinculo(item1, item1);
		vinculo2 = new Vinculo(item2, item2);
		vinculo3 = new Vinculo(item3, item3);
		repositorioVinculo.save(vinculo1);
		repositorioVinculo.save(vinculo2);
		repositorioVinculo.save(vinculo3);
	}

}
