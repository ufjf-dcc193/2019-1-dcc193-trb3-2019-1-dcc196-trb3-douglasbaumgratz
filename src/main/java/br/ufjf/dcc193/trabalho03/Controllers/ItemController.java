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

import br.ufjf.dcc193.trabalho03.Models.Anotacao;
import br.ufjf.dcc193.trabalho03.Models.Etiqueta;
import br.ufjf.dcc193.trabalho03.Models.Item;
import br.ufjf.dcc193.trabalho03.Models.Vinculo;
import br.ufjf.dcc193.trabalho03.Persistence.AnotacaoRepository;
import br.ufjf.dcc193.trabalho03.Persistence.EtiquetaRepository;
import br.ufjf.dcc193.trabalho03.Persistence.ItemRepository;
import br.ufjf.dcc193.trabalho03.Persistence.VinculoRepository;

/**
 * ItemController
 */
@Controller
public class ItemController {
    @Autowired
    ItemRepository repositorioItens;
    @Autowired
    AnotacaoRepository repositorioAnotacoes;
    @Autowired
    EtiquetaRepository repositorioEtiquetas;
    @Autowired
    VinculoRepository repositorioVinculos;

    @RequestMapping("/item-listar.html")
    public ModelAndView listar(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            List<Item> item = repositorioItens.findAll();
            mv.setViewName("item/listar");
            mv.addObject("itens", item);
            mv.addObject("title", "Itens");
            return mv;
        }
        return mv;
    }

    @GetMapping("/item-novo.html")
    public ModelAndView nova(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            List<Anotacao> anotacoes = repositorioAnotacoes.findAll();
            List<Etiqueta> etiquetas = repositorioEtiquetas.findAll();
            List<Vinculo> vinculos = repositorioVinculos.findAll();
            mv.addObject("anotacoes", anotacoes);
            mv.addObject("etiquetas", etiquetas);
            mv.addObject("vinculos", vinculos);
            mv.addObject("title", "Item");
            mv.setViewName("item/novo");
            return mv;
        }
        return mv;
    }

    @GetMapping("/item-editar.html")
    public ModelAndView editar(Item aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            Item item = repositorioItens.findById(aux.getId()).get();
            List<Anotacao> anotacoes = repositorioAnotacoes.findAll();
            List<Etiqueta> etiquetas = repositorioEtiquetas.findAll();
            List<Vinculo> vinculos = repositorioVinculos.findAll();
            mv.addObject("anotacoes", anotacoes);
            mv.addObject("etiquetas", etiquetas);
            mv.addObject("vinculos", vinculos);
            mv.addObject("title", "Item");
            mv.addObject("item", item);
            mv.setViewName("item/editar");
            return mv;
        }
        return mv;
    }

    @PostMapping({ "/item-novo.html", "/item-editar.html" })
    public ModelAndView salvar(@Valid Item aux, BindingResult binding, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            if (binding.hasErrors()) {
                mv.setViewName("item/editar");
                mv.addObject("item", aux);
                mv.addObject("title", "Item");
                return mv;
            }
            repositorioItens.save(aux);
            mv.setViewName("redirect:item-listar.html");
            return mv;
        }
        return mv;
    }

    @RequestMapping("/item-excluir.html")
    public ModelAndView remove(Item aux, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:index.html");
        if (session.getAttribute("user") != null) {
            repositorioItens.deleteById(aux.getId());
            mv.setViewName("redirect:item-listar.html");
            return mv;
        }
        return mv;
    }

}