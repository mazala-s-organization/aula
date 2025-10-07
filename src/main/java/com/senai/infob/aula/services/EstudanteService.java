package com.senai.infob.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.repositories.EstudanteRepository;

@Service
public class EstudanteService {
    
    @Autowired
    public EstudanteRepository EstudanteRepository;

    public Long count(){
        return EstudanteRepository.count();
    }

    public Estudante salvar(Estudante estudante) {
        return EstudanteRepository.save(estudante);
    }

    public Boolean deletar(Integer id) {
        Estudante estudante = EstudanteRepository.findById(id).get();
        if(estudante != null) {
            EstudanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
