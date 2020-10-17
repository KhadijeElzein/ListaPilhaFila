package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaEncadeadaSentinela;

public class MainListaEncadeadaSentinela {

	public static void main(String[] args) {
		ListaEncadeadaSentinela<Integer> les1 = new ListaEncadeadaSentinela<Integer>();
		ListaEncadeadaSentinela<Integer> les2 = new ListaEncadeadaSentinela<Integer>();
		ListaEncadeadaSentinela<Integer> les3 = new ListaEncadeadaSentinela<Integer>();
		les1 = les1.insereFim(les1, 8);
		les1 = les1.insereFim(les1, 7);
		les1 = les1.insereFim(les1, 6);
		les1 = les1.insereFim(les1, 5);
		les1 = les1.insereFim(les1, 4);
		les1 = les1.insereFim(les1, 3);
		les1 = les1.insereFim(les1, 2);
		les1 = les1.insereFim(les1, 1);
		System.out.println("A lista digitada pelo usuario é: ");
		les1.imprime(les1);
		
		les1 = les1.ordenar(les1);
		System.out.println("A lista ordenada é: ");
		les1.imprime(les1);
		
		les1 = les1.remover(les1, 3);
		les1 = les1.insereInicio(les1,100);
		les1 = les1.insereP(les1, 200, 5);
		les1.imprime(les1);
		System.out.println("A posicao do item 6 é " + les1.busca(les1, 6));

		System.out.println("A lista sem o valor "+les1.retira(les1.busca(les1,6),les1, 6)+ " fica:"); 
		les1.imprime(les1);
		
		les2=les1;
		System.out.println("A nova lista e uma copia da lista anterior:");
		les2.imprime(les2);
		
		System.out.println("Somando as duas, temos: ");
		les3=les2.concatenar(les1, les2);
		les3.imprime(les3);
		
		les3 = les3.insereFim(les3, 300);
		les3.imprime(les3);

		les3.FLVazia(les3);
		System.out.println("A lista apos limpar fica: ");
		les3.imprime(les3);
	}

}
