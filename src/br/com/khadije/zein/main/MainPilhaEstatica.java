package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.pilhas.PilhaEstatica;

public class MainPilhaEstatica {

	public static void main(String[] args) {
		 PilhaEstatica<Integer> p = new PilhaEstatica<Integer>(Integer.class);
		 p = p.empilha(p, 11);
		 p = p.empilha(p, 8);
		 p = p.empilha(p, 41);
		 p = p.empilha(p, 4);
		 p = p.empilha(p, 24);
		 p.imprime(p);
		 System.out.println("O item removido foi: " + p.desempilha(p));
		 System.out.println(" O item que está no topo da pilha é: " + p.topo(p));
		 System.out.println(" A pilha contém " + p.tamanho(p)+" itens");
		 p = p.FPVazia(p);
	     System.out.println("A pilha apos limpar fica: ");
		 p.imprime(p);

	}

}
