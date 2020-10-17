package br.com.khadije.zein.domain.pilhas;

import java.lang.reflect.Array;

public class PilhaEstatica<T extends Comparable <T>> {
	public static int tam_max = 1000;
	private T[] item;
	private Integer topo;
	
	


	public PilhaEstatica(Class<T> c) {
		super();
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) Array.newInstance(c, tam_max);
		this.item = aux;
		this.topo = 0;
	}




	public T[] getItem() {
		return item;
	}




	public void setItem(T[] item) {
		this.item = item;
	}




	public Integer getTopo() {
		return topo;
	}




	public void setTopo(Integer topo) {
		this.topo = topo;
	}

	
	public Boolean cheia(PilhaEstatica<T> p){
	    return (p.getTopo() >= PilhaEstatica.tam_max);
	}

	public Boolean vazia(PilhaEstatica<T> p){
	    return (p.getTopo().equals(0));
	}

	

	public PilhaEstatica<T> empilha(PilhaEstatica<T> p, T item){
	    if (!cheia(p)) {
	        p.getItem()[p.getTopo()]= item;
	        p.setTopo(p.getTopo()+1);
	    }else{
	        System.out.println("A pilha esta cheia");
	    }
	    return p;
	}

	public T desempilha(PilhaEstatica<T> p){
	    if (!vazia(p)) {
	    	p.setTopo(p.getTopo()-1);
	        T tp = p.getItem()[p.getTopo()];
	        return tp;
	    }else{
	        System.out.println("A pilha esta vazia");
	        return null;
	    }
	}

	public void imprime(PilhaEstatica<T> p){
			if(vazia(p))
				System.out.println("Pilha vazia");
			else {
				System.out.print("[");
				for(int i = 0 ; i < p.getTopo(); i++)
					System.out.print(p.getItem()[i]+ " ");
				System.out.println("]");
			}
	}
	public PilhaEstatica<T> FPVazia(PilhaEstatica<T> p){
		p.setTopo(0);
		return p;
	}
	public T topo (PilhaEstatica<T> p){
	    return p.getItem()[p.getTopo()-1];
	}
	public Integer tamanho(PilhaEstatica<T> p) {
		return p.getTopo();
	}
}
