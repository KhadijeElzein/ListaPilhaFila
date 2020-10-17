package br.com.khadije.zein.domain.filas;

import java.lang.reflect.Array;

public class FilaEstatica<T> {
	public static int tam_max = 1000;
	private T[] item;
	private Integer inicio;
	private Integer fim;
	
	public FilaEstatica(Class<T> c) {
		super();
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) Array.newInstance(c, tam_max);
		this.item = aux;
		this.inicio = 0;
		this.fim = 0;
	}

	public T[] getItem() {
		return item;
	}
	public void setItem(T[] item) {
		this.item = item;
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public Integer getFim() {
		return fim;
	}
	public void setFim(Integer fim) {
		this.fim = fim;
	}
	public Boolean vazia(FilaEstatica<T> f) {
		return (f.getInicio() == f.getFim());
	}
	public Boolean cheia(FilaEstatica<T> f) {
		return (f.getFim() == tam_max);
	}

	public FilaEstatica<T> enfileira(FilaEstatica<T> f, T x){
	   if (!cheia(f)){
	       f.getItem()[f.getFim()]=x;
	       f.setFim(f.getFim()+1);
	   }else{
	       System.out.println("fila cheia");
	   } 
	   return f;
	}
	public T desinfileira(FilaEstatica<T> f) {
		if(!vazia(f)) {
			T aux = f.getItem()[f.getInicio()];
			f.setInicio(f.getInicio()+1);
			return aux;
		}else {
			System.out.println("Fila Vazia");
			return null;
		}
	}
	public FilaEstatica<T> FFVazia(FilaEstatica<T> f){
		f.setFim(0);
		f.setInicio(0);
		return f;
	}
	
	public void imprime(FilaEstatica<T> f){

	    if (cheia(f)){    
		       System.out.println("fila cheia");
	    }else    
	    if (!vazia(f)){
	    	System.out.print("[");
			for(int i = 0 ; i < f.getFim(); i++)
				System.out.print(f.getItem()[i]+ " ");
			System.out.println("]");
	    }else 
	      {
			System.out.println("Fila Vazia");
	      }
	}
}
