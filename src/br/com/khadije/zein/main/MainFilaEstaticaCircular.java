package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.filas.FilaEstaticaCircular;

public class MainFilaEstaticaCircular {
	public static void main(String[] args) {
		 FilaEstaticaCircular<Integer> p = new FilaEstaticaCircular<Integer>(Integer.class);
		 p = p.enfileira(p, 11);
		 p = p.enfileira(p, 8);
		 p = p.enfileira(p, 41);
		 p = p.enfileira(p, 4);
		 p = p.enfileira(p, 24);
		 p.imprime(p);
		 System.out.println("O item removido foi: " + p.desinfileira(p));
		 p = p.FFVazia(p);
	     System.out.println("A fila apos limpar fica: ");
		 p.imprime(p);

	}
}
