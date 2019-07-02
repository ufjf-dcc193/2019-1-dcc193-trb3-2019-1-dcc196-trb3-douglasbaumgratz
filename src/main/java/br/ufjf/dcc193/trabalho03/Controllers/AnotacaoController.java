package br.ufjf.dcc193.trabalho03.Controllers;

import java.util.Date;
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

import br.ufjf.dcc193.trabalho03.Models.Anotacao;
import br.ufjf.dcc193.trabalho03.Models.Usuario;
import br.ufjf.dcc193.trabalho03.Persistence.AnotacaoRepository;

/**
 * AnotacaoController
 */
@Controller
public class AnotacaoController {
    @Autowired
    AnotacaoRepository anotacaoRepository;

    @RequestMapping("/anotacao-listar.html")
    public ModelAndView listar(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            mv.setViewName("anotacao/listar");
            List<Anotacao> anotacao = anotacaoRepository.findAll();
            mv.addObject("anotacoes", anotacao);
            mv.addObject("title", "Anotação");
            return mv;
        }
        return mv;
    }

    @GetMapping("/anotacao-novo.html")
    public ModelAndView nova(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            mv.setViewName("anotacao/novo");
            mv.addObject("title", "Anotação");
            return mv;
        }
        return mv;
    }

    @GetMapping("/anotacao-editar.html")
    public ModelAndView editar(Anotacao aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Anotacao anot = anotacaoRepository.findById(aux.getId()).get();
            mv.setViewName("anotacao/editar");
            mv.addObject("title", "Anotação");
            mv.addObject("anotacao", anot);
            return mv;
        }
        return mv;
    }

    @PostMapping({ "/anotacao-novo.html"})
    public ModelAndView salvar(@Valid Anotacao aux, BindingResult binding, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            if (binding.hasErrors()) {
                mv.setViewName("anotacao/editar");
                mv.addObject("anotacao", aux);
                mv.addObject("title", "Anotação");
                return mv;
            }
            Usuario user = (Usuario) session.getAttribute("user");
            Date dtCadastro = new Date();
            aux.setUsuario(user);
            aux.setDataInclusao(dtCadastro.toString());
            Date dtEdit = new Date();
            aux.setDataAlteracao(dtEdit.toString());
            anotacaoRepository.save(aux);
            mv.setViewName("redirect:anotacao-listar.html");
            return mv;
        }
        return mv;
    }

    @PostMapping({ "/anotacao-editar.html" })
    public ModelAndView salvarAlteracao(@Valid Anotacao aux, BindingResult binding, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Anotacao anotacao = anotacaoRepository.getOne(aux.getId());
            if (binding.hasErrors()) {
                mv.setViewName("anotacao/editar");
                mv.addObject("anotacao", aux);
                mv.addObject("title", "Anotação");
                return mv;
            }
            Date dtEdit = new Date();
            anotacao.setDataAlteracao(dtEdit.toString());
            anotacao.setDescricao(aux.getDescricao());
            anotacao.setTitulo(aux.getTitulo());
            anotacao.setUrl(aux.getUrl());
            anotacaoRepository.save(anotacao);
            mv.setViewName("redirect:anotacao-listar.html");
            return mv;
        }
        return mv;
    }

    @RequestMapping("/anotacao-excluir.html")
    public ModelAndView remove(Anotacao aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            anotacaoRepository.deleteById(aux.getId());
            mv.setViewName("redirect:anotacao-listar.html");
            return mv;
        }
        return mv;
    }
}