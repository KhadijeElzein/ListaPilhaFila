package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.No;

public class ListaCircularSentinela <T extends Comparable<T>> extends ListaEncadeadaSentinela<T>{
	public ListaCircularSentinela() {
		super();
		this.setSentinela(new No<T>(null));
		this.setPrimeiro(this.getSentinela());
		this.setUltimo(this.getSentinela());
		this.getUltimo().setProx(this.getPrimeiro());
	}
	
	
	public ListaCircularSentinela<T> insereInicio(ListaCircularSentinela<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
			l.setUltimo(elemento);			
		} else {
			elemento.setProx(l.getPrimeiro().getProx());
			l.getPrimeiro().setProx(elemento);
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}

	public ListaCircularSentinela<T> remover(ListaCircularSentinela<T> l, T x) {
		
		if (vazia(l)) {
			System.out.println("Lista vazia");
			return null;
		}
		l.getSentinela().setInfo(x);
		No<T> ant = l.getSentinela();
		No<T> p = l.getSentinela(); // usado para encontrar o elemento a ser retirado
		do {
			ant = p;
			p = p.getProx();
	    } while (p.getInfo() != x);
		if (p != l.getSentinela()) { // elemento encontrado
			if (p == l.getPrimeiro().getProx()) // remoção na cabeça
				l.getPrimeiro().setProx(l.getPrimeiro().getProx().getProx());
			else
				ant.setProx(p.getProx());
		} else
			System.out.println("Elemento não encontrado");
		return l;
	}
	
	
	public Integer busca(ListaCircularSentinela<T> l, T x) {
		Integer posicao = 0;
		l.getSentinela().setInfo(x);
		No<T> p = l.getSentinela();		
		if (vazia(l)) {
			System.out.println("Lista vazia");
			return null;
		}
		do { // localiza o elemento
			p = p.getProx();
			posicao++;
		} while (p.getInfo() != x);
		if (p != l.getSentinela()) {
			return posicao-1;
		} else
			return null;
	}

	
	public ListaCircularSentinela<T> FLVazia(ListaCircularSentinela<T> l) {
		No<T> aux = l.getPrimeiro().getProx();
		do {
			aux.setInfo(null);
			aux = aux.getProx();
		} while (aux != l.getPrimeiro());
		l.setPrimeiro(l.getSentinela());
		l.setUltimo(l.getSentinela());
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}

	public ListaCircularSentinela<T> insereFim(ListaCircularSentinela<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
		} else {
			l.getUltimo().setProx(elemento);
		}
		l.setUltimo(elemento);
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}
	
	
	public ListaCircularSentinela<T> insereP(ListaCircularSentinela<T> l, T x, Integer p) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
			l.setUltimo(elemento);
		} else {
			if (p == 0)
				insereInicio(l, x);
			else {
				No<T> aux = l.getPrimeiro().getProx();
				for (int i = 0; i < p - 1; i++) {
					aux = aux.getProx();
				}
				if (aux.equals(l.getSentinela()))
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

	
	public T retira(Integer p, ListaCircularSentinela<T> l, T x) {
		No<T> aux = l.getPrimeiro().getProx();
		No<T> ant = l.getPrimeiro().getProx();
		if (vazia(l)) {
			System.out.println("Lista vazia");
		} else if (p == 0) {
			l.getPrimeiro().setProx(l.getPrimeiro().getProx().getProx());
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

	
	public Boolean vazia(ListaCircularSentinela<T> l) {
		return (l.getPrimeiro().getProx()==l.getPrimeiro());
	}

	
	public void imprime(ListaCircularSentinela<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			No<T> aux = l.getPrimeiro().getProx();
			System.out.print("[");
			do {
				System.out.print(aux.getInfo()+ " ");
				aux = aux.getProx();
			}while (aux != l.getPrimeiro());
			System.out.println("]");
		}
	}

	
	
	public ListaCircularSentinela<T> ordenar(ListaCircularSentinela<T> l) {
		No<T> atual = l.getPrimeiro().getProx();
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
		return l;
	}
	
	public ListaCircularSentinela<T> concatenar(ListaCircularSentinela<T> l1, ListaCircularSentinela<T> l2) {
		 No<T> atual1 = l1.getPrimeiro().getProx();
		 No<T> atual2 = l2.getPrimeiro().getProx();
		 ListaCircularSentinela<T> l3 = new ListaCircularSentinela<T>();
         do{
        	 insereFim(l3,atual1.getInfo());
        	 atual1 = atual1.getProx();
         }while(atual1!=l1.getPrimeiro());
         do{
        	 insereFim(l3,atual2.getInfo());
        	 atual2 = atual2.getProx();
         }while(atual2!=l2.getPrimeiro());
         return l3;
	}


}
