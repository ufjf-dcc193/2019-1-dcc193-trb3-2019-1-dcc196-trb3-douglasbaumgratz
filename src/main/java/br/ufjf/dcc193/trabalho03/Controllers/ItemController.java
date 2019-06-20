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

import br.ufjf.dcc193.trabalho03.Models.Item;
import br.ufjf.dcc193.trabalho03.Persistence.ItemRepository;

/**
 * ItemController
 */
@Controller
public class ItemController {
    @Autowired
    ItemRepository itens;

    @RequestMapping("/item-listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item/listar");
        List<Item> item = itens.findAll();
        mv.addObject("itens", item);
        mv.addObject("title", "Itens");
        return mv;
    }

    @GetMapping("/item-novo.html")
    public ModelAndView nova() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item/novo");
        mv.addObject("title", "Item");
        return mv;
    }

    @GetMapping("/item-editar.html")
    public ModelAndView editar(Item aux) {
        ModelAndView mv = new ModelAndView();
        Item item = itens.findById(aux.getId()).get();
        mv.setViewName("item/editar");
        mv.addObject("title", "Item");
        mv.addObject("item", item);
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
        itens.save(aux);
        mv.setViewName("redirect:item-listar.html");
        return mv;
    }

    @RequestMapping("/item-excluir.html")
    public RedirectView remove(Item aux) {
        itens.deleteById(aux.getId());
        return new RedirectView("item-listar.html");
    }
    
}