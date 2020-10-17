package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaCircular;

public class MainListaCircular {

	public static void main(String[] args) {
		ListaCircular<Integer> lc1 = new ListaCircular<Integer>();
		ListaCircular<Integer> lc2 = new ListaCircular<Integer>();
		ListaCircular<Integer> lc3 = new ListaCircular<Integer>();
		lc1 = lc1.insereFim(lc1, 8);
		lc1 = lc1.insereFim(lc1, 7);
		lc1 = lc1.insereFim(lc1, 6);
		lc1 = lc1.insereFim(lc1, 5);
		lc1 = lc1.insereFim(lc1, 4);
		lc1 = lc1.insereFim(lc1, 3);
		lc1 = lc1.insereFim(lc1, 2);
		lc1 = lc1.insereFim(lc1, 1);
		System.out.println("A lista digitada pelo usuario é: ");
		lc1.imprime(lc1);
		
		lc1 = lc1.ordenar(lc1);
		System.out.println("A lista ordenada é: ");
		lc1.imprime(lc1);
		
		lc1 = lc1.remover(lc1, 3);

		
		lc1 = lc1.insereInicio(lc1,100);

		lc1 = lc1.insereP(lc1, 200, 5);

		lc1.imprime(lc1);
		
		System.out.println("A posicao do item 6 é " + lc1.busca(lc1, 6));

		System.out.println("A lista sem o valor "+lc1.retira(lc1.busca(lc1,100),lc1, 100)+ "fica:"); 
		lc1.imprime(lc1);
		
		lc2=lc1;
		System.out.println("A nova lista e uma copia da lista anterior:");
		lc2.imprime(lc2);
		
		System.out.println(" Somando as duas, temos: ");
		lc3=lc2.concatenar(lc1, lc2);
		lc3.imprime(lc3);
		
		lc3 = lc3.insereFim(lc3, 300);
		lc3.imprime(lc3);

		lc3.FLVazia(lc3);
		System.out.println("A lista apos limpar fica: ");
		lc3.imprime(lc3);
		
	}

}
