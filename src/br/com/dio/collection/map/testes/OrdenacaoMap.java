package br.com.dio.collection.map.testes;

import java.util.*;

public class OrdenacaoMap {
    /*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);

Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
*/
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória - HashMap\t--");
        Map<String, Livro> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("xxi Lições Para o Século 21", 432));
        }};

        for (Map.Entry<String, Livro> entry : meusLivros.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("==================");

        System.out.println("--\tOrdem Inserção - LinkedHashMap \t--");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> entry : meusLivros2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }


        System.out.println("==================");
        System.out.println("--\tOrdem alfabética autores - TreeMap\t--");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);

        for (Map.Entry<String, Livro> entry : meusLivros3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("==================");
        System.out.println("--\tOrdem alfabética nomes dos livros\t--");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro> entry : meusLivros4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }



        System.out.println("==================");
        System.out.println("--\tOrdem número de página\t--");

        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPagina());

        meusLivros5.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro>entry: meusLivros5){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getPaginas());
        }

    }

}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}