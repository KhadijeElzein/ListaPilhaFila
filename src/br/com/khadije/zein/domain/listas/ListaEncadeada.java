package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.No;
import br.com.khadije.zein.service.interfaces.ListaService;

public class ListaEncadeada<T extends Comparable <T>> implements ListaService<T,ListaEncadeada<T>> {
	
	private No<T> primeiro;
	
	private No<T> ultimo;

	public ListaEncadeada() {
		super();
		this.primeiro = null;
		this.ultimo = null;
	}

	public No<T> getPrimeiro() {
		return primeiro;
	}
	
	public void setPrimeiro(No<T> primeiro) {
		this.primeiro = primeiro;
	}
	
	public No<T> getUltimo() {
		return ultimo;
	}
	
	public void setUltimo(No<T> ultimo) {
		this.ultimo = ultimo;
	}
	
	@Override
	public ListaEncadeada<T> insereInicio(ListaEncadeada<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
			l.setUltimo(elemento);
		} else {
			elemento.setProx(l.getPrimeiro());
			l.setPrimeiro(elemento);
		}
		return l;
	}

	@Override
	public ListaEncadeada<T> remover(ListaEncadeada<T> l, T x) {
		No<T> ant = l.getPrimeiro(); // elemento anterior
		No<T> p = l.getPrimeiro(); // usado para encontrar o elemento a ser retirado
		while (p != null && p.getInfo() != x) { // localiza o elemento
			ant = p;
			p = p.getProx();
		}
		if (p != null) { // elemento encontrado
			if (p == l.getPrimeiro()) // remoção na cabeça
				l.setPrimeiro(l.getPrimeiro().getProx());
			else
				ant.setProx(p.getProx());
		} else
			System.out.println("Elemento não encontrado");
		return l;
	}

	@Override
	public Integer busca(ListaEncadeada<T> l, T x) {
		Integer posicao = 0;
		No<T> p = l.getPrimeiro(); // usado para encontrar o elemento a ser retirado
		while (p != null && p.getInfo() != x) { // localiza o elemento
			p = p.getProx();
			posicao++;
		}
		if (p != null) {
			return posicao;
		} else
			return null;
	}

	@Override
	public ListaEncadeada<T> FLVazia(ListaEncadeada<T> l) {
		No<T> p = l.getPrimeiro();
		while (p != null) {
			p.setInfo(null);
			p = p.getProx();
		}
		l.getPrimeiro().setProx(null);
		l.setPrimeiro(null);
		l.setUltimo(null);
		return l;
	}

	@Override
	public ListaEncadeada<T> insereFim(ListaEncadeada<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
			l.setUltimo(elemento);
		} else {
			elemento.setProx(null);
			l.getUltimo().setProx(elemento);
			l.setUltimo(l.getUltimo().getProx());
			l.getUltimo().setProx(null);
		}
		return l;
	}

	@Override
	public ListaEncadeada<T> insereP(ListaEncadeada<T> l, T x, Integer p) {
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
				if(aux == null) System.out.println("posição acima do tamanho da lista");
				else {
					No<T> store = aux.getProx();
					aux.setProx(elemento);
					elemento.setProx(store);
				}
			}
		}
		return l;
	}

	@Override
	public T retira(Integer p, ListaEncadeada<T> l, T x) {
		No<T> aux = l.getPrimeiro();
		No<T> ant = l.getPrimeiro();
		for (int i = 0; i < p; i++) {
			ant = aux;
			aux = aux.getProx();
		}
		if (aux.getInfo().equals(x)) {
			ant.setProx(aux.getProx());
		}
		return x;
	}

	@Override
	public Boolean vazia(ListaEncadeada<T> l) {
		return (l.getPrimeiro() == null);
	}

	@Override
	public void imprime(ListaEncadeada<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			No<T> aux = l.getPrimeiro();
			System.out.print("[");
			while (aux != null) {
				System.out.print(aux.getInfo()+ " ");
				aux = aux.getProx();
			}
			System.out.println("]");
		}
	}

	@Override
	public ListaEncadeada<T> ordenar(ListaEncadeada<T> l) {
		No<T> atual = l.getPrimeiro();
		while (atual != null) {
			No<T> prox = atual.getProx();
			while (prox != null) {
				if (atual.getInfo().compareTo(prox.getInfo()) > 0) {
					T tmp = atual.getInfo();
					atual.setInfo(prox.getInfo());
					prox.setInfo(tmp);
				}
				prox = prox.getProx();
			}
			atual = atual.getProx();
		}
		return l;
	}

	@Override
	public ListaEncadeada<T> concatenar(ListaEncadeada<T> l1, ListaEncadeada<T> l2) {
		 No<T> atual1 = l1.getPrimeiro();
		 No<T> atual2 = l2.getPrimeiro();
		 ListaEncadeada<T> l3 = new ListaEncadeada<T>();
         while (atual1 != null) 
         {
        	 insereFim(l3,atual1.getInfo());
        	 atual1 = atual1.getProx();
         }
         while (atual2 != null) 
         {
        	 insereFim(l3,atual2.getInfo());
        	 atual2 = atual2.getProx();
         }
		 //l1.getUltimo().setProx(l2.getPrimeiro());;
         return l3;
	}
}
