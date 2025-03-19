package com.senac.bingo.controller;

import com.senac.bingo.model.Endereco;
import com.senac.bingo.repository.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/endereco")
    public String abrirEndereco(Endereco endereco){
        return "cadastro-endereco";
    }

    @PostMapping("/salvar-endereco")
    public String salvarEndereco(@Valid Endereco endereco, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "redirect:/endereco";
        }


        enderecoRepository.save(endereco);
        return "redirect:/";
    }

}