package br.com.dio.collection.set.Ex;

import java.util.*;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
*/
public class OrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 45));
            add(new Serie("that '70s show", "comédia", 20));
        }};

        //exibindo
        for (Serie serie : minhasSeries) {
            System.out.printf("Nome: %s \nGenero: %s\nTempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());
        }


        System.out.println("--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("dark", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 20));
        }};
        for (Serie serie : minhasSeries1) {
            System.out.printf("Nome: %s \nGenero: %s\nTempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());
        }

        System.out.println("------\tOrdem natural (TempoEpisodio)\t------");

        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);

        for (Serie serie : minhasSeries2) {
            System.out.printf("Nome: %s \nGenero: %s\nTempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());
        }


        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");

        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatoNomeGeneroTempoEp());
        minhasSeries3.addAll(minhasSeries2);

        for (Serie serie : minhasSeries3) {
            System.out.printf("Nome: %s \nGenero: %s\nTempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());
        }


        System.out.println("--\tOrdem gênero\t--");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());

        minhasSeries4.addAll(minhasSeries3);

        for (Serie serie : minhasSeries4) {
            System.out.printf("Nome: %s  -  Genero: %s  -  Tempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());
        }


        System.out.println("--\tOrdem Tempo Episódio\t--");
        Set<Serie> minhaseries5 = new TreeSet<>(new ComparetoTempoEp());
        minhaseries5.add(new Serie("BKB", "drama", 50));
        minhaseries5.add(new Serie("a casa do dragão", "drama/fantasia", 60));
        minhaseries5.add(new Serie("Rick & Mory", "comedia", 20));

        for (Serie serie : minhaseries5) {

            System.out.printf("Nome: %s  -  Genero: %s  -  Tempo de episodio: %s \n=========================\n",
                    serie.getNome(), serie.getGenero(), serie.getTempoEp());

        }


    }



}

class ComparetoTempoEp implements Comparator <Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getTempoEp().compareTo(s2.getTempoEp());

            }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEp;

    public Serie(String nome, String genero, Integer tempoEp) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEp = tempoEp;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEp() {
        return tempoEp;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEp=" + tempoEp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEp, serie.tempoEp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEp);
    }


    @Override
    public int compareTo(Serie serie) {
        int tempEp = Integer.compare(this.getTempoEp(), serie.getTempoEp());
        if (tempEp != 0) {
            return tempEp;
        }
        return this.getGenero().compareTo(serie.getGenero());


    }
}

class ComparatoNomeGeneroTempoEp implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {

        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) {
            return nome;
        }
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEp(), s2.getTempoEp());
    }
}

class ComparatorGenero implements Comparator<Serie> {


    @Override
    public int compare(Serie s1, Serie s2) {

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;


        return s1.getNome().compareTo(s2.getNome());
    }
}