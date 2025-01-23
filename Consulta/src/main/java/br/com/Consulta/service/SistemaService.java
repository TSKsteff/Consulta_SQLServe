package br.com.Consulta.service;

import br.com.Consulta.Model.Sistema;
import br.com.Consulta.Repository.SistemasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SistemaService {

    private final SistemasRepository sistemasRepository;

    public List<Sistema> findAll(){
        List<Sistema> sistemasList = sistemasRepository.findAll();
        FileUtils.saveObjectToFile(sistemasList);
        return sistemasList;
    }
}
