package com.luiz.Controller;

import com.luiz.Entity.Pais;
import com.luiz.Service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Pais> getTodosOsPaises() throws Exception {
        return paisService.getTodosOsPaises();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pais getPais(@PathVariable("id") int id) throws Exception {
        return paisService.getPais(id);
    }

}
