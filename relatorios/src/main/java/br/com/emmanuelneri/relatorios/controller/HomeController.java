package br.com.emmanuelneri.relatorios.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "home", viewId = "/pages/index.xhtml", pattern = "/home")
})
public class HomeController {

}
