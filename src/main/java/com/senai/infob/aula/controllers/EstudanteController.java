package com.senai.infob.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.services.EstudanteService;

@RestController
public class EstudanteController {
    
    @Autowired
    public EstudanteService estudanteService;
    
    @GetMapping("/count")
    public Long count(){
        return estudanteService.count();
    }
    
    @PostMapping("/salvar")
    public Estudante salvar(@RequestBody Estudante estudante) {
        return estudanteService.salvar(estudante);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = estudanteService.deletar(id);
        if (deletou) {
            return "Usuário removido com sucesso";
    }
    return "Falha ao remover o usuário";
 }
   @GetMapping("/buscar/{id}")
    public Estudante buscarPorId(@PathVariable Integer id) {
        return estudanteService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<Estudante> listarTodos() {
        return estudanteService.listarTodos();
    }
    
    
}
