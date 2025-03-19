package com.senac.bingo.controller;

import com.senac.bingo.model.Endereco;
import com.senac.bingo.model.Estabelecimento;
import com.senac.bingo.repository.EnderecoRepository;
import com.senac.bingo.repository.EstabelecimentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping("/estabelecimento")
    public String abrirCadastroEstabelecimento(Estabelecimento estabelecimento){
        return "cadastro-estabelecimento";
    }

    @PostMapping("/salvar-estabelecimento")
    public String salvarEndereco(@Valid Estabelecimento estabelecimento, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/estabelecimento";
        }
        estabelecimentoRepository.save(estabelecimento);
        return "redirect:/";
    }

}