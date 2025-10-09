package com.senai.infob.aula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.models.Professor;
import com.senai.infob.aula.services.ProfessorService;


@RestController
public class ProfessorController {
    
    @Autowired
    public ProfessorService professorService;
    
    @GetMapping("/count")
    public Long count(){
        return professorService.count();
    }
    
    @PostMapping("/salvar")
    public Professor salvar(@RequestBody Professor estudante) {
        return professorService.salvar(estudante);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = professorService.deletar(id);
        if (deletou) {
            return "Usuário removido com sucesso";
    }
    return "Falha ao remover o usuário";
 }
   @GetMapping("/buscar/{id}")
    public Professor buscarPorId(@PathVariable Integer id) {
        return professorService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }
    
 @PutMapping("/atualizarUm/{id}")
    public Professor atualizarUm(@PathVariable Integer id, @RequestBody Professor professor) {
        return professorService.atualizarUm(professor, id);
    }
    
}