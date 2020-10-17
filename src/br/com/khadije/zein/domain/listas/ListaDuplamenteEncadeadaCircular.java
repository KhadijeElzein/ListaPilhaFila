package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.NoDuplamenteEncadeado;

public class ListaDuplamenteEncadeadaCircular<T extends Comparable<T>>  extends ListaDuplamenteEncadeada<T> {

	public ListaDuplamenteEncadeadaCircular() {
		super();
		// TODO Auto-generated constructor stub
		this.setPrimeiro(null);
		this.setUltimo(this.getPrimeiro());
	}
	
	public ListaDuplamenteEncadeadaCircular<T> insereInicio(
			ListaDuplamenteEncadeadaCircular<T> l, T x) {
		NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
		if (vazia(l)) {
			 l.setPrimeiro(elemento); 
		     l.setUltimo(elemento);
		     elemento.setAnterior(l.getUltimo());
		     elemento.setProx(l.getPrimeiro());
		} else {
			  elemento.setProx(l.getPrimeiro());
			  elemento.setAnterior(l.getPrimeiro().getAnterior());
			  l.setPrimeiro(elemento);
			  l.getUltimo().setProx(elemento);
		}
		l.setPrimeiro(elemento);
		return l;
	}
	
	public ListaDuplamenteEncadeadaCircular<T> remover(ListaDuplamenteEncadeadaCircular<T> l, T x){
		if (!vazia(l)) {
			NoDuplamenteEncadeado<T> p = l.getPrimeiro();
		    do {
		         p = p.getProx();
		    } while (p != l.getPrimeiro() && p.getInfo() != x);
		    if (p != null) {
		    	if (!p.equals(l.getPrimeiro())){
		         if (!p.equals(l.getUltimo())){
		        	 p.getProx().setAnterior(p.getAnterior());
		        	 p.getAnterior().setProx(p.getProx());
		         }else{
		            l.getPrimeiro().setAnterior(p.getAnterior());
		            p.getAnterior().setProx(p.getProx());		         
		         }
		      }else{      
		         l.setPrimeiro(p.getProx());
		         l.getUltimo().setProx(l.getPrimeiro());
		      }
		    }else
				System.out.println("Elemento não encontrado");
		}else
	      System.out.println("Lista vazia");
		return l;
	}
	
	public Integer busca(ListaDuplamenteEncadeadaCircular<T> l, T x) {
		Integer posicao = 0;
		if (vazia(l)) {
			System.out.println("Lista vazia");
			return null;
		}
		NoDuplamenteEncadeado<T> p = l.getPrimeiro(); 
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
	
	public ListaDuplamenteEncadeadaCircular<T> FLVazia
	(ListaDuplamenteEncadeadaCircular<T> l){
		NoDuplamenteEncadeado<T> aux = l.getUltimo(); 
		while (!aux.getAnterior().equals(l.getPrimeiro())) {
		      aux = aux.getAnterior();
		      aux.setInfo(null);  
	    }
		l.setPrimeiro(null);
		l.getUltimo().setProx(null);
		l.setUltimo(null);
		return l;
	}
	
	public ListaDuplamenteEncadeadaCircular<T> insereFim
	(ListaDuplamenteEncadeadaCircular<T> l, T x){
		if(vazia(l)) {
			l = insereInicio(l, x);
        }else{
        	NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<T>(x);
        	novo.setProx(l.getUltimo().getProx());
        	novo.setAnterior(l.getUltimo());
        	l.getUltimo().setProx(novo);
        	l.setUltimo(novo);
        }      
		return l;
	}
	
	public ListaDuplamenteEncadeadaCircular<T> insereP
	(ListaDuplamenteEncadeadaCircular<T> l, T x, Integer p){
		NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
		if (vazia(l)) {
			l.setPrimeiro(elemento);
			l.setUltimo(elemento);
		} else {
			if (p == 0)
				insereInicio(l, x);
			else {
				NoDuplamenteEncadeado<T> aux = l.getPrimeiro();
				for (int i = 0; i < p - 1; i++) {
					aux = aux.getProx();
				}
				if (aux == l.getPrimeiro())
					System.out.println("posição acima do tamanho da lista");
				else if (aux.getProx().equals(l.getPrimeiro()))
					insereFim(l, x);
				else {
					NoDuplamenteEncadeado<T> store = aux.getProx();
					aux.setProx(elemento);
					elemento.setProx(store);
				}
			}
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return l;
	}

	public T retira(Integer p, ListaDuplamenteEncadeadaCircular<T>  l , T x){
		NoDuplamenteEncadeado<T> aux = l.getPrimeiro();
		if (vazia(l)) {
			System.out.println("Lista vazia");
		} else if (p == 0) {
			l.setPrimeiro(l.getPrimeiro().getProx());
		} else {
			for (int i = 0; i < p; i++) {
				aux = aux.getProx();
			}
			if (aux.getInfo().equals(x)) {
				aux.getAnterior().setProx(aux.getProx());
			}
		}
		l.getUltimo().setProx(l.getPrimeiro());
		return x;
	}
	
	
	public Boolean vazia(ListaDuplamenteEncadeadaCircular<T> l) {
		return (l.getPrimeiro() == null);
	}
	
	public void imprime(ListaDuplamenteEncadeadaCircular<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			NoDuplamenteEncadeado<T> aux = l.getPrimeiro();
			System.out.print("[");
			do {
				System.out.print(aux.getInfo() + " ");
				aux = aux.getProx();
			} while (aux != l.getPrimeiro());
			System.out.println("]");
		}
	}
	
	public ListaDuplamenteEncadeadaCircular<T> ordenar
	(ListaDuplamenteEncadeadaCircular<T> l){
		NoDuplamenteEncadeado<T> atual = l.getPrimeiro();
		if (vazia(l)) {
			System.out.println("Lista vazia");
		} else {
			do {
				NoDuplamenteEncadeado<T> prox = atual.getProx();
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
	
	public ListaDuplamenteEncadeadaCircular<T> concatenar 
	(ListaDuplamenteEncadeadaCircular<T> l1, 
			ListaDuplamenteEncadeadaCircular<T> l2){
		
		NoDuplamenteEncadeado<T> atual1 = l1.getPrimeiro();
		NoDuplamenteEncadeado<T> atual2 = l2.getPrimeiro();
		ListaDuplamenteEncadeadaCircular<T> l3 = new ListaDuplamenteEncadeadaCircular<T>();
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
