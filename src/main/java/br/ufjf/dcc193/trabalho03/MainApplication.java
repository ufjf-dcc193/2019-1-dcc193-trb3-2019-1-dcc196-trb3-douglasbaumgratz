package br.ufjf.dcc193.trabalho03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.ufjf.dcc193.trabalho03.Models.Etiqueta;
import br.ufjf.dcc193.trabalho03.Persistence.EtiquetaRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		ConfigurableApplicationContext ctx;
		EtiquetaRepository repositorioEtiqueta;

		Etiqueta etiqueta1;

		ctx = SpringApplication.run(MainApplication.class, args);
		repositorioEtiqueta = ctx.getBean(EtiquetaRepository.class);

		etiqueta1 = new Etiqueta("Título 1", "Descrição 1", "URL1");
		repositorioEtiqueta.save(etiqueta1);

	}

}
