package br.com.khadije.zein.service;

import br.com.khadije.zein.domain.ListaEncadeadaSentinela;
import br.com.khadije.zein.domain.No;
import br.com.khadije.zein.service.interfaces.ListaEncadeadaSentinelaService;

public class ListaEncadeadaSentinelaServiceImpl<T extends Comparable<T>> implements ListaEncadeadaSentinelaService<T> {

	@Override
	public ListaEncadeadaSentinela<T> insereInicio(ListaEncadeadaSentinela<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
			l.setUltimo(elemento);
		} else {
			elemento.setProx(l.getPrimeiro().getProx());
			l.getPrimeiro().setProx(elemento);
		}
		return l;
	}

	@Override
	public ListaEncadeadaSentinela<T> remover(ListaEncadeadaSentinela<T> l, T x) {
		No<T> ant = l.getPrimeiro().getProx(); // elemento anterior
		No<T> p = l.getPrimeiro().getProx(); // usado para encontrar o elemento a ser retirado
		while (p != null && p.getInfo() != x) { // localiza o elemento
			ant = p;
			p = p.getProx();
		}
		if (p != null) { // elemento encontrado
			if (p == l.getPrimeiro().getProx()) // remoção na cabeça
				l.getPrimeiro().setProx(l.getPrimeiro().getProx().getProx());
			else
				ant.setProx(p.getProx());
		} else
			System.out.println("Elemento não encontrado");
		return l;
	}
	@Override
	public Integer busca(ListaEncadeadaSentinela<T> l, T x) {
		Integer posicao = 0;
		No<T> p = l.getPrimeiro().getProx(); // usado para encontrar o elemento a ser retirado
		while (p != null && p.getInfo() != x) { // localiza o elemento
			p = p.getProx();
			posicao++;
		}
		if (p != null) {
			return posicao;
		} else
			return 0;
	}

	@Override
	public ListaEncadeadaSentinela<T> FLVazia(ListaEncadeadaSentinela<T> l) {
		l.getPrimeiro().setProx(null);
		l.setUltimo(l.getSentinela());
		return l;
	}

	@Override
	public ListaEncadeadaSentinela<T> insereFim(ListaEncadeadaSentinela<T> l, T x) {
		No<T> elemento = new No<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
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
	public ListaEncadeadaSentinela<T> insereP(ListaEncadeadaSentinela<T> l, T x, Integer p) {
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
	public T retira(Integer p, ListaEncadeadaSentinela<T> l, T x) {
		No<T> aux = l.getPrimeiro().getProx();
		No<T> ant = l.getPrimeiro().getProx();
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
	public Boolean vazia(ListaEncadeadaSentinela<T> l) {
		return (l.getPrimeiro().getProx() == null);
	}

	@Override
	public void imprime(ListaEncadeadaSentinela<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			No<T> aux = l.getPrimeiro().getProx();
			System.out.print("[");
			while (aux != null) {
				System.out.print(aux.getInfo()+ " ");
				aux = aux.getProx();
			}
			System.out.println("]");
		}
	}

	
	@Override
	public ListaEncadeadaSentinela<T> ordenar(ListaEncadeadaSentinela<T> l) {
		No<T> atual = l.getPrimeiro().getProx();
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
	/**/
	@Override
	public ListaEncadeadaSentinela<T> concatenar(ListaEncadeadaSentinela<T> l1, ListaEncadeadaSentinela<T> l2) {
		 No<T> atual1 = l1.getPrimeiro().getProx();
		 No<T> atual2 = l2.getPrimeiro().getProx();
		 ListaEncadeadaSentinela<T> l3 = new ListaEncadeadaSentinela<T>();
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
		 //l1.getUltimo().setProx(l2.getPrimeiro().getProx());
         return l3;
	}

}