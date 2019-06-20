package br.ufjf.dcc193.trabalho03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.ufjf.dcc193.trabalho03.Models.Etiqueta;
import br.ufjf.dcc193.trabalho03.Models.Usuario;
import br.ufjf.dcc193.trabalho03.Persistence.EtiquetaRepository;
import br.ufjf.dcc193.trabalho03.Persistence.UsuarioRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		ConfigurableApplicationContext ctx;
		EtiquetaRepository repositorioEtiqueta;
		UsuarioRepository repositorioUsuario;

		Etiqueta etiqueta1;
		Usuario usuario1;

		ctx = SpringApplication.run(MainApplication.class, args);
		repositorioEtiqueta = ctx.getBean(EtiquetaRepository.class);
		repositorioUsuario = ctx.getBean(UsuarioRepository.class);

		etiqueta1 = new Etiqueta("Título 1", "Descrição 1", "URL1");
		repositorioEtiqueta.save(etiqueta1);

		usuario1 = new Usuario("Usuario 1", 123, "Descrição 1", "usuario@gmail.com");
		repositorioUsuario.save(usuario1);

		

	}

}
