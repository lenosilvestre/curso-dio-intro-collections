package br.com.dio.collection.set.Ex.cores;

import java.util.*;

public class EX01 {
    public static void main(String[] args) {
        Set<String> coresArcoIris = new HashSet<>();

        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for (String cor : coresArcoIris) {
            System.out.println(cor);
        }

        System.out.println("Qtd de cores : " + coresArcoIris.size());
        Set<String> coresOrdemAlfab = new TreeSet<>(coresArcoIris); //TreeSet ordena na ordem natural

        System.out.println("Em ordem alfabetica : " + coresOrdemAlfab);

        //"Ordem inversa "
        Set<String> coresOrdemInversa = new LinkedHashSet<>(coresArcoIris);
        System.out.println("ordem que entrou " + coresOrdemInversa);

        List<String> coresOrdemInversa2 = new ArrayList<>(coresOrdemInversa);

        Collections.reverse(coresOrdemInversa2);
        System.out.println("Ordem de saida " + coresOrdemInversa2);

        for (String cor : coresArcoIris) {
            if (cor.startsWith("v")) {
                System.out.println(cor);
            }
        }
        System.out.println("Remova todas as cores que não começam com a letra “v”: ");
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println(coresArcoIris);

        coresArcoIris.clear();
        System.out.println("Conjunto vazio? "+coresArcoIris.isEmpty());
    }
}
