package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaEncadeada;

public class MainListaEncadeada {

	public static void main(String[] args) {
		ListaEncadeada<Integer> le1 = new ListaEncadeada<Integer>();
		ListaEncadeada<Integer> le2 = new ListaEncadeada<Integer>();
		ListaEncadeada<Integer> le3 = new ListaEncadeada<Integer>();
		le1 = le1.insereFim(le1, 8);
		le1 = le1.insereFim(le1, 7);
		le1 = le1.insereFim(le1, 6);
		le1 = le1.insereFim(le1, 5);
		le1 = le1.insereFim(le1, 4);
		le1 = le1.insereFim(le1, 3);
		le1 = le1.insereFim(le1, 2);
		le1 = le1.insereFim(le1, 1);
		System.out.println("A lista digitada pelo usuario é: ");
		le1.imprime(le1);
		
		le1 = le1.ordenar(le1);
		System.out.println("A lista ordenada é: ");
		le1.imprime(le1);
		
		le1 = le1.remover(le1, 3);
		le1 = le1.insereInicio(le1,100);
		le1 = le1.insereP(le1, 200, 5);
		le1.imprime(le1);
		System.out.println("A posicao do item 6 é " + le1.busca(le1, 6));
		
		System.out.println("A lista sem o valor "+le1.retira(le1.busca(le1,6),le1, 6)+ " fica:"); 
		le1.imprime(le1);
		
		le2=le1;
		System.out.println("A nova lista é uma copia da lista anterior:");
		le2.imprime(le2);
		
		System.out.println("Somando as duas, temos: ");
		le3=le2.concatenar(le1, le2);
		le3.imprime(le3);
		
		le3 = le3.insereFim(le3, 300);
		le3.imprime(le3);

		le3.FLVazia(le3);
		System.out.println(" A lista apos limpar fica: ");
		le3.imprime(le3);

	}

}
