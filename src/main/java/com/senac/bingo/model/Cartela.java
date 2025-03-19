package com.senac.bingo.model;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
public class Cartela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private Set<Integer> numeros = new HashSet<>();

    @ManyToOne
    private Estabelecimento estabelecimento;

    public Cartela() {
        this.numeros = gerarNumerosAleatorios();
    }

    private Set<Integer> gerarNumerosAleatorios() {
        Random random = new Random();
        Set<Integer> numerosSorteados = new HashSet<>();
        while (numerosSorteados.size() < 15) {
            numerosSorteados.add(random.nextInt(75) + 1); // Números de 1 a 75
        }
        return numerosSorteados;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Set<Integer> getNumeros() { return numeros; }
    public void setNumeros(Set<Integer> numeros) { this.numeros = numeros; }

    public Estabelecimento getEstabelecimento() { return estabelecimento; }
    public void setEstabelecimento(Estabelecimento estabelecimento) { this.estabelecimento = estabelecimento; }

}
