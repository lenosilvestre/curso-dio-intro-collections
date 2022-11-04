package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);

Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Roque, idade: 12, cor: amarelo
*/
public class ExemploOrdenado {
    public static void main(String[] args) {

        List<GatoBicho> gatos = new ArrayList<>(){{
              add(new GatoBicho("Jon", 18, "preto"));
              add(new GatoBicho("Simba", 8, "tigrado"));
              add(new GatoBicho("Jon", 12, "amarelo"));
        }};

        System.out.println("--\tOrdem de Iserção\t--");

        System.out.println(gatos);

        System.out.println("--\tOrdem de Iserção\t--");
        Collections.shuffle(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem (Nome)\t--");
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem (Idade)\t--");
       // Collections.sort(gatos , new ComparatoIdades());
        gatos.sort(new ComparatoIdades());
        System.out.println(gatos);

        System.out.println("--\tOrdem (cor)\t--");
        // Collections.sort(gatos , new ComparatoIdades());
        gatos.sort(new ComparatoCores());
        System.out.println(gatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t--");
        gatos.sort(new ComparatoNomeCorIdade());
        System.out.println(gatos);

    }
}
class GatoBicho implements Comparable<GatoBicho> {
    private String nome;
    private Integer idade;
    private String cor;

    public GatoBicho(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(GatoBicho gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}
class ComparatoIdades implements Comparator<GatoBicho>{


    @Override
    public int compare(GatoBicho g1, GatoBicho g2) {
        return  Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
class ComparatoCores implements Comparator<GatoBicho>{
    @Override
    public int compare(GatoBicho g1, GatoBicho g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
class ComparatoNomeCorIdade implements Comparator<GatoBicho>{
    @Override
    public int compare(GatoBicho g1, GatoBicho g2) {
       int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
       if(nome != 0) return nome;

       int idade = Integer.compare(g1.getIdade(), g2.getIdade());
       if (idade !=0) return idade;

       return g1.getCor().compareToIgnoreCase(g2.getCor());


    }
}