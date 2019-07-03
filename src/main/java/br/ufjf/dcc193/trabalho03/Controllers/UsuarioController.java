package br.ufjf.dcc193.trabalho03.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho03.Models.Usuario;
import br.ufjf.dcc193.trabalho03.Persistence.UsuarioRepository;

/**
 * UsuarioController
 */
@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository repositorioUsuarios;

    @RequestMapping("/usuario-listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario/listar");
        List<Usuario> usuarios = repositorioUsuarios.findAll();
        mv.addObject("usuarios", usuarios);
        mv.addObject("title", "Usuários");
        return mv;
    }

    @GetMapping("/usuario-novo.html")
    public ModelAndView nova() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario/novo");
        mv.addObject("title", "Usuário");
        return mv;
    }

    @GetMapping("/usuario-editar.html")
    public ModelAndView editar(Usuario aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Usuario user = (Usuario) session.getAttribute("user");
            Usuario usuario = repositorioUsuarios.findById(aux.getId()).get();
            if(usuario.getId() != user.getId()) {
                mv.setViewName("redirect:usuario-listar.html");
                return mv;
            }
            mv.setViewName("usuario/editar");
            mv.addObject("title", "Usuário");
            mv.addObject("usuario", usuario);
            return mv;
        }
        return mv;
    }

    @PostMapping({ "/usuario-novo.html", "/usuario-editar.html" })
    public ModelAndView salvar(@Valid Usuario aux, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("usuario/editar");
            mv.addObject("usuario", aux);
            mv.addObject("title", "Usuario");
            return mv;
        }
        repositorioUsuarios.save(aux);
        mv.setViewName("redirect:usuario-listar.html");
        return mv;
    }

    @RequestMapping("/usuario-excluir.html")
    public ModelAndView remove(Usuario aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Usuario user = (Usuario) session.getAttribute("user");
            if(aux.getId() != user.getId()) {
                mv.setViewName("redirect:usuario-listar.html");
                return mv;
            }
            repositorioUsuarios.deleteById(aux.getId());
            mv.setViewName("redirect:usuario-listar.html");
            session.setAttribute("user", null);
            return mv;
        }
        return mv;
    }
}