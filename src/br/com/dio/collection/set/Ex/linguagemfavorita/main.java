package br.com.dio.collection.set.Ex.linguagemfavorita;

import java.util.HashSet;
import java.util.Set;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class main {
    public static void main(String[] args) {

        Set<LinguagemFavorita> linguagemFavorita = new HashSet<>();
        linguagemFavorita.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        linguagemFavorita.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        linguagemFavorita.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        System.out.println("--------\tOrdem de Inserção\t--------");


    }
}
