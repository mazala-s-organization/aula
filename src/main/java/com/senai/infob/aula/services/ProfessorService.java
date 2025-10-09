package com.senai.infob.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.aula.models.Professor;

@Service
public class ProfessorService {
    
    @Autowired
    public com.senai.infob.aula.repositories.ProfessorRepository ProfessorRepository;

    public Long count(){
        return ProfessorRepository.count();
    }

    public Professor salvar(Professor professor) {
        return ProfessorRepository.save(professor);
    }

    public Boolean deletar(Integer id) {
        Professor professor = ProfessorRepository.findById(id).get();
        if(professor != null) {
            ProfessorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Professor buscarPorId(Integer Id) {
        return ProfessorRepository.findById(Id).get();
    }

    public List<Professor> listarTodos() {
        return ProfessorRepository.findAll();
    }

    public Professor atualizarUm(Professor professor, Integer id) {
        Professor e = buscarPorId(id);
        if (e != null) {
            return ProfessorRepository.save(professor);
        }
        return null;
    }
}