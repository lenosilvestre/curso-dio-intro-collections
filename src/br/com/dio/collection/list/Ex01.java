package br.com.dio.collection.list;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List <Integer> temperatura = new ArrayList<>();

        var messes=0;

        while(messes<6){
            messes++;
            System.out.printf("Informe a temperatura do %sº mês: ",messes);
           temperatura.add(ler.nextInt());

        }
        System.out.println(temperatura);
        Iterator <Integer> iterator = temperatura.iterator();
        int soma = 0 ;
        while (iterator.hasNext()){
            int aux = iterator.next();
            soma += aux;
        }

        System.out.println("Média de temperatura semetral:  "+soma/temperatura.size());


    }
}
