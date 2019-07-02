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
import org.springframework.web.servlet.view.RedirectView;

import br.ufjf.dcc193.trabalho03.Models.Etiqueta;
import br.ufjf.dcc193.trabalho03.Persistence.EtiquetaRepository;

/**
 * EtiquetaController
 */
@Controller
public class EtiquetaController {
    @Autowired
    EtiquetaRepository etiquetas;

    @RequestMapping("/etiqueta-listar.html")
    public ModelAndView listar(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            mv.setViewName("etiqueta/listar");
            List<Etiqueta> etiqueta = etiquetas.findAll();
            mv.addObject("etiquetas", etiqueta);
            mv.addObject("title", "Etiquetas");
            return mv;
        }
        return mv;
    }

    @GetMapping("/etiqueta-novo.html")
    public ModelAndView nova(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            mv.setViewName("etiqueta/novo");
            mv.addObject("title", "Etiqueta");
            return mv;
        }
        return mv;
    }

    @GetMapping("/etiqueta-editar.html")
    public ModelAndView editar(Etiqueta aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Etiqueta et = etiquetas.findById(aux.getId()).get();
            mv.setViewName("etiqueta/editar");
            mv.addObject("title", "Etiqueta");
            mv.addObject("etiqueta", et);
            return mv;
        }
        return mv;
    }

    @PostMapping({ "/etiqueta-novo.html", "/etiqueta-editar.html" })
    public ModelAndView salvar(@Valid Etiqueta aux, BindingResult binding, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            if (binding.hasErrors()) {
                mv.setViewName("etiqueta/editar");
                mv.addObject("etiqueta", aux);
                mv.addObject("title", "Etiqueta");
                return mv;
            }
            etiquetas.save(aux);
            mv.setViewName("redirect:etiqueta-listar.html");
            return mv;
        }
        return mv;
    }

    @RequestMapping("/etiqueta-excluir.html")
    public ModelAndView remove(Etiqueta aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            etiquetas.deleteById(aux.getId());
            mv.setViewName("redirect:etiqueta-listar.html");
            return mv;
        }
        return mv;
    }

}