package br.com.dio.collection.map.testes;

import java.sql.SQLOutput;
import java.util.*;

public class ex1 {
    /*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3351543
 Estado = CE - população  = 9187103
 Estado = RN - população = 3534265
 */

    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os " +
                "estados e suas respectivas populações: ");

        Map<String, Integer> populacaoUF = new HashMap<>();
        populacaoUF.put("PE", 9616621);
        populacaoUF.put("AL", 3351543);
        populacaoUF.put("CE", 9187103);
        populacaoUF.put("RN", 3534265);

        System.out.println(populacaoUF);
        System.out.println("Substitua a pop do estado do RN por 3534165");

        populacaoUF.put("RN", 3534165);
        System.out.println(populacaoUF);

        System.out.println("Confira se a PB está no dicionario, se não adicione: PB 4039277");

        System.out.println("PB presente? " + populacaoUF.containsKey("PB"));

        System.out.println("Exiba a população do estado PE: " + populacaoUF.get("PE"));
        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");

        Map<String, Integer> populacaoUF2 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println(populacaoUF2);
        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");

        Map<String, Integer> populacaoUF3 = new TreeMap<>(populacaoUF2);

        System.out.println(populacaoUF3);

        Integer minPop = Collections.min(populacaoUF3.values());

        for (Map.Entry<String, Integer> entry : populacaoUF3.entrySet()) {
            if (entry.getValue().equals(Collections.min(populacaoUF3.values()))) {
                System.out.println("menor pop " + entry.getKey() + " : " + entry.getValue());
            }
            if (entry.getValue().equals(Collections.max(populacaoUF3.values()))) {
                System.out.println("Maior pop " + entry.getKey() + " : " + entry.getValue());
            }
        }


        System.out.println("Exiba a soma da população desses estados: ");
        Iterator<Integer> iterator = populacaoUF3.values().iterator();

        var soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);
        soma = 0;
        for (Map.Entry<String, Integer> entry : populacaoUF3.entrySet()) {
            soma += entry.getValue();
        }
        System.out.println(soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " +
                "" + (soma / populacaoUF3.size()));

        for (Map.Entry<String, Integer> entry : populacaoUF3.entrySet()) {
            if (entry.getValue()<4000000){

                //System.out.println("Removendo " +entry.getKey());
            }

        }

    }


}
