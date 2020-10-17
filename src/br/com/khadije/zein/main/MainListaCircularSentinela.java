package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaCircularSentinela;

public class MainListaCircularSentinela {

	public static void main(String[] args) {
		ListaCircularSentinela<Integer> lcs1 = new ListaCircularSentinela<Integer>();
		ListaCircularSentinela<Integer> lcs2 = new ListaCircularSentinela<Integer>();
		ListaCircularSentinela<Integer> lcs3 = new ListaCircularSentinela<Integer>();
		lcs1 = lcs1.insereFim(lcs1, 8);
		lcs1 = lcs1.insereFim(lcs1, 7);
		lcs1 = lcs1.insereFim(lcs1, 6);
		lcs1 = lcs1.insereFim(lcs1, 5);
		lcs1 = lcs1.insereFim(lcs1, 4);
		lcs1 = lcs1.insereFim(lcs1, 3);
		lcs1 = lcs1.insereFim(lcs1, 2);
		lcs1 = lcs1.insereFim(lcs1, 1);
		System.out.println("A lista digitada pelo usuario é: ");
		lcs1.imprime(lcs1);
		
		lcs1 = lcs1.ordenar(lcs1);
		System.out.println("A lista ordenada é: ");
		lcs1.imprime(lcs1);
		
		lcs1 = lcs1.remover(lcs1, 3);

		
		lcs1 = lcs1.insereInicio(lcs1,100);

		lcs1 = lcs1.insereP(lcs1, 200, 5);

		lcs1.imprime(lcs1);
		
		System.out.println("A posicao do item 6 é " + lcs1.busca(lcs1, 6));

		System.out.println("A lista sem o valor "+lcs1.retira(lcs1.busca(lcs1,100),lcs1, 100)+ "fica:"); 
		lcs1.imprime(lcs1);
		
		lcs2=lcs1;
		System.out.println("A nova lista e uma copia da lista anterior:");
		lcs2.imprime(lcs2);
		
		System.out.println(" Somando as duas, temos: ");
		lcs3=lcs2.concatenar(lcs1, lcs2);
		lcs3.imprime(lcs3);
		
		lcs3 = lcs3.insereFim(lcs3, 300);
		lcs3.imprime(lcs3);

		lcs3.FLVazia(lcs3);
		System.out.println("A lista apos limpar fica: ");
		lcs3.imprime(lcs3);
		
	}

}
