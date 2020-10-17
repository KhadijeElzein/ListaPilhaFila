package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.No;

public class ListaCircular<T extends Comparable<T>> extends ListaEncadeada<T>{

	public ListaCircular<T> insereInicio(ListaCircular<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
			l.setUltimo(elemento);
		} else {
			elemento.setProx(l.getPrimeiro());
			l.setPrimeiro(elemento);
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}

	public ListaCircular<T> remover(ListaCircular<T> l, T x) {
		if (!vazia(l)) {
			No<T> ant = l.getPrimeiro(); // elemento anterior
			No<T> p = l.getPrimeiro(); // usado para encontrar o elemento a ser retirado
			do { // localiza o elemento
				ant = p;
				p = p.getProx();
			} while (p != l.getPrimeiro() && p.getInfo() != x);
			if (p != null) { // elemento encontrado
				if (p == l.getPrimeiro()) { // remoção na cabeça
					l.setPrimeiro(l.getPrimeiro().getProx());
					l.getUltimo().setProx(l.getPrimeiro());
				} else
					ant.setProx(p.getProx());
			} else
				System.out.println("Elemento não encontrado");
		}else{
		      System.out.println("Lista vazia");
		}
		return l;
	}

	public Integer busca(ListaCircular<T> l, T x) {
		Integer posicao = 0;
		if (vazia(l)) {
			System.out.println("Lista vazia");
			return null;
		}
		No<T> p = l.getPrimeiro(); // usado para encontrar o elemento a ser retirad
		if (l.getPrimeiro().getInfo().equals(x))
			return 0;
		do { // localiza o elemento
			p = p.getProx();
			posicao++;
		} while (p != l.getPrimeiro() && p.getInfo() != x);
		if (p != null) {
			return posicao;
		} else
			return null;
	}

	public ListaCircular<T> FLVazia(ListaCircular<T> l) {
		No<T> aux = l.getPrimeiro();
		do {
			aux.setInfo(null);
			aux = aux.getProx();
		} while (aux != l.getPrimeiro());
		l.setPrimeiro(null);
		l.getUltimo().setProx(null);
		l.setUltimo(null);
		return l;
	}

	public ListaCircular<T> insereFim(ListaCircular<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
		} else {
			l.getUltimo().setProx(elemento);
		}
		l.setUltimo(elemento);
		l.getUltimo().setProx(l.getPrimeiro());

		return l;
	}

	public ListaCircular<T> insereP(ListaCircular<T> l, T x, Integer p) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
			l.setUltimo(elemento);
		} else {
			if (p == 0)
				insereInicio(l, x);
			else {
				No<T> aux = l.getPrimeiro();
				for (int i = 0; i < p - 1; i++) {
					aux = aux.getProx();
				}
				if (aux == l.getPrimeiro())
					System.out.println("posição acima do tamanho da lista");
				else if (aux.getProx().equals(l.getPrimeiro()))
					insereFim(l, x);
				else {
					No<T> store = aux.getProx();
					aux.setProx(elemento);
					elemento.setProx(store);
				}
			}
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}

	public T retira(Integer p, ListaCircular<T> l, T x) {
		No<T> aux = l.getPrimeiro();
		No<T> ant = l.getPrimeiro();
		if (vazia(l)) {
			System.out.println("Lista vazia");
		} else if (p == 0) {
			l.setPrimeiro(l.getPrimeiro().getProx());
		} else {
			for (int i = 0; i < p; i++) {
				ant = aux;
				aux = aux.getProx();
			}
			if (aux.getInfo().equals(x)) {
				ant.setProx(aux.getProx());
			}
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return x;
	}

	public Boolean vazia(ListaCircular<T> l) {
		return (l.getPrimeiro() == null);
	}

	public void imprime(ListaCircular<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			No<T> aux = l.getPrimeiro();
			System.out.print("[");
			do {
				System.out.print(aux.getInfo() + " ");
				aux = aux.getProx();
			} while (aux != l.getPrimeiro());
			System.out.println("]");
		}
	}

	public ListaCircular<T> ordenar(ListaCircular<T> l) {
		No<T> atual = l.getPrimeiro();
		if (vazia(l)) {
			System.out.println("Lista vazia");
		} else {
			do {
				No<T> prox = atual.getProx();
				while (prox != l.getPrimeiro()) {
					if (atual.getInfo().compareTo(prox.getInfo()) > 0) {
						T tmp = atual.getInfo();
						atual.setInfo(prox.getInfo());
						prox.setInfo(tmp);
					}
					prox = prox.getProx();
				}
				atual = atual.getProx();
			} while (atual != l.getPrimeiro());
		}
		return l;
	}

	public ListaCircular<T> concatenar(ListaCircular<T> l1, ListaCircular<T> l2) {
		No<T> atual1 = l1.getPrimeiro();
		No<T> atual2 = l2.getPrimeiro();
		ListaCircular<T> l3 = new ListaCircular<T>();
		do{
			insereFim(l3, atual1.getInfo());
			atual1 = atual1.getProx();
		}while(atual1!=l1.getPrimeiro());
		do{
			insereFim(l3, atual2.getInfo());
			atual2 = atual2.getProx();
		}while(atual2!=l2.getPrimeiro());
		return l3;
	}

}
