package br.com.dio.collection.map.testes;

import java.util.*;

public class TrabalhandoMap {
    /*
 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
 modelo = gol - consumo = 14,4km/l
 modelo = uno - consumo = 15,6 km/l
 modelo = mobi - consumo = 16,1 km/l
 modelo = hb20 - consumo = 14,5 km/l
 modelo = kwid - consumo = 15,6 km/l
 */
    public static void main(String[] args) {
        Map<String, Double> carros = new HashMap<>();
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        carros.put("gol", 14.4);
        carros.put("uno", 15.6);
        carros.put("mobi", 16.1);
        carros.put("hb20", 14.5);
        carros.put("kwid", 15.6);

        System.out.println(carros.toString());

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carros.put("gol", 15.2);

        System.out.println(carros.toString());

        System.out.println("Confira se o modelo tucson está no dicionário: " + carros.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carros.get("uno"));

        System.out.println("Exiba os modelos: " + carros.keySet());

        System.out.println("Exiba os consumos dos carros: " + carros.values());

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");

        Double consumoMaisEficiente = Collections.max(carros.values());

        System.out.println(consumoMaisEficiente);

        carros.put("ka", 16.1);

        Set<Map.Entry<String, Double>> entries = carros.entrySet();

        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.printf("modelo mais eficiente é o %s que faz %s km/l\n", modeloMaisEficiente, consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double menosEficiente = Collections.min(carros.values());
        System.out.println();

        for (Map.Entry<String, Double> entry : carros.entrySet()) {
            if (entry.getValue().equals(menosEficiente)) {
                System.out.printf("Modelo menos eficiente %s faz %s \n", entry.getKey(), menosEficiente);
            }
        }


        //somando os valores
        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;

        while (iterator.hasNext()) {
            soma += iterator.next();
        }

        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma / carros.size()));

        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");

        System.out.println("antes " + carros);

        Iterator<Double> iterator1 = carros.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }

        System.out.println("depois " + carros);

        System.out.println("Exiba todos os carros na ordem em que foram informados: ");

        Map<String, Double> carrosPorOrdem = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};

        System.out.println(carrosPorOrdem.toString());
        System.out.println();
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPorNome = new TreeMap<>(carrosPorOrdem);
        System.out.println(carrosPorNome.toString());

        System.out.println("Apague o dicionario de carros: ");
        carros.clear();

        System.out.println("Carros está vazio? "+carros.isEmpty());

    }
}
