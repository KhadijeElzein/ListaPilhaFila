package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.listas.ListaEstatica;

public class MainListaEstatica {
	
	public static void main(String[] args) {
		ListaEstatica<Integer> l1 = new ListaEstatica<Integer>(Integer.class);
		ListaEstatica<Integer> l2 = new ListaEstatica<Integer>(Integer.class);
		ListaEstatica<Integer> l3 = new ListaEstatica<Integer>(Integer.class);
		l1 = l1.insereFim(l1, 8);
		l1 = l1.insereFim(l1, 7);
		l1 = l1.insereFim(l1, 6);
		l1 = l1.insereFim(l1, 5);
		l1 = l1.insereFim(l1, 4);
		l1 = l1.insereFim(l1, 3);
		l1 = l1.insereFim(l1, 2);
		l1 = l1.insereFim(l1, 1);
		System.out.println("A lista digitada pelo usuario é: ");
		l1.imprime(l1);	
		l1 = l1.ordenar(l1);
		System.out.println("A lista ordenada é: ");
		l1.imprime(l1);
		l1 = l1.remover(l1, 3);
		l1 = l1.insereInicio(l1,100);
		l1 = l1.insereP(l1, 200, 5);
		l1 = l1.insereP(l1, 50, 15);
		System.out.println("A lista com elementos removidos e adicionados é: ");
		l1.imprime(l1);
		System.out.println("A posicao do item 6 é " + l1.busca(l1, 6));
		System.out.println("A lista sem o valor "+l1.retira(l1.busca(l1,6),l1, 6)+ " fica:"); 
		l1.imprime(l1);
		l2=l1;
		System.out.println("A nova lista e uma copia da lista anterior:");
		l2.imprime(l2);
		System.out.println("Somando as duas, temos:");
		l3= l2.concatenar(l1, l2);
		l3.imprime(l3);
		System.out.println("A nova lista esta cheia? " + l3.isCheia(l3));
		l3 = l3.insereFim(l3, 300);
		l3.imprime(l3);
		l3.FLVazia(l3);
		System.out.println("A lista apos limpar fica:");
		l3.imprime(l3);
	}
}
