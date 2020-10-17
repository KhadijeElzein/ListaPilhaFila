package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaDuplamenteEncadeadaSentinela;

public class MainListaDuplamenteEncadeadaSentinela {
	public static void main(String[] args) {
	ListaDuplamenteEncadeadaSentinela<Integer> lde1 = new ListaDuplamenteEncadeadaSentinela<Integer>();
	ListaDuplamenteEncadeadaSentinela<Integer> lde2 = new ListaDuplamenteEncadeadaSentinela<Integer>();
	ListaDuplamenteEncadeadaSentinela<Integer> lde3 = new ListaDuplamenteEncadeadaSentinela<Integer>();
	lde1 = lde1.insereFim(lde1, 8);
	lde1 = lde1.insereFim(lde1, 7);
	lde1 = lde1.insereFim(lde1, 6);
	lde1 = lde1.insereFim(lde1, 5);
	lde1 = lde1.insereFim(lde1, 4);
	lde1 = lde1.insereFim(lde1, 3);
	lde1 = lde1.insereFim(lde1, 2);
	lde1 = lde1.insereFim(lde1, 1);
	System.out.println("A lista digitada pelo usuario é: ");
	lde1.imprime(lde1);
	
	lde1 = lde1.ordenar(lde1);
	System.out.println("A lista ordenada é: ");
	lde1.imprime(lde1);
	
	lde1 = lde1.remover(lde1, 3);

	
	lde1 = lde1.insereInicio(lde1,100);

	lde1 = lde1.insereP(lde1, 200, 5);

	lde1.imprime(lde1);
	
	System.out.println("A posicao do item 6 é " + lde1.busca(lde1, 6));

	System.out.println("A lista sem o valor "+lde1.retira(lde1.busca(lde1,100),lde1, 100)+ "fica:"); 
	lde1.imprime(lde1);
	
	lde2=lde1;
	System.out.println("A nova lista e uma copia da lista anterior:");
	lde2.imprime(lde2);
	
	System.out.println(" Somando as duas, temos: ");
	lde3=lde2.concatenar(lde1, lde2);
	lde3.imprime(lde3);
	
	lde3 = lde3.insereFim(lde3, 300);
	lde3.imprime(lde3);

	lde3.FLVazia(lde3);
	System.out.println("A lista apos limpar fica: ");
	lde3.imprime(lde3);

}
}
