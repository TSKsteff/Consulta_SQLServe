package br.com.Consulta.service;

import br.com.Consulta.Model.Funcionario;
import br.com.Consulta.Repository.FuncionariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FuncionariosService {

    private final FuncionariosRepository  funcionariosRepository;

    public List<Funcionario> findAll(){
        List<Funcionario> funcionariosList = funcionariosRepository.findAll();
        FileUtils.saveObjectToFile(funcionariosList);
        return funcionariosList;
    }

}
