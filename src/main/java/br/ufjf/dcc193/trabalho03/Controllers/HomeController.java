package br.ufjf.dcc193.trabalho03.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho03.Models.Usuario;
import br.ufjf.dcc193.trabalho03.Persistence.UsuarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @authors douglas
 */
@Controller
public class HomeController {
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     *
     * @return
     */
    @RequestMapping({ "/", "/index.html" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");        
        return mv;
    }

    @PostMapping("/login.html")
    public ModelAndView login(Usuario user, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        List<Usuario> users = usuarioRepository.findAll();
        mv.setViewName("redirect:index.html");
        for (Usuario usuario : users) {
            if (usuario.getCodigo().equals(user.getCodigo()) && usuario.getEmail().equals(user.getEmail())) {
                mv.addObject("usuario", usuario);
                mv.setViewName("redirect:index.html");
                session.setAttribute("user", usuario);
                return mv;
            }
        }
        return mv;
    }
}