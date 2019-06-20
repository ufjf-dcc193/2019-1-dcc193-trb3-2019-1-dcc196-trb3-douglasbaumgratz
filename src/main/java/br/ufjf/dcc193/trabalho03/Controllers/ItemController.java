package br.ufjf.dcc193.trabalho03.Controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.ufjf.dcc193.trabalho03.Models.*;
import br.ufjf.dcc193.trabalho03.Persistence.*;

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
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        List<Item> item = repositorioItens.findAll();
        mv.setViewName("item/listar");
        mv.addObject("itens", item);
        mv.addObject("title", "Itens");
        return mv;
    }

    @GetMapping("/item-novo.html")
    public ModelAndView nova() {
        ModelAndView mv = new ModelAndView();
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

    @GetMapping("/item-editar.html")
    public ModelAndView editar(Item aux) {
        ModelAndView mv = new ModelAndView();
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

    @PostMapping({ "/item-novo.html", "/item-editar.html" })
    public ModelAndView salvar(@Valid Item aux, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
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

    @RequestMapping("/item-excluir.html")
    public RedirectView remove(Item aux) {
        repositorioItens.deleteById(aux.getId());
        return new RedirectView("item-listar.html");
    }
    
}