package br.com.khadije.zein.domain.filas;

import br.com.khadije.zein.domain.No;

public class FilaCircular<T> extends Fila<T>{
	
	
	public FilaCircular() {
		super();
		this.setInicio(null);
		this.setFim(this.getInicio());
	}
	
	public Boolean vazia(Fila<T> f){
	    return (f.getInicio() == null);
	}

	public FilaCircular<T> enfileira(FilaCircular<T> f, T x){
	    No<T> aux = new No<T>(x);
    	aux.setProx(f.getInicio());
	    if (vazia(f)) {
	    	f.setInicio(aux);
	    }
	    else {
	    	f.getFim().setProx(aux);
	    }
	    f.setFim(aux);
	    return f;
	}

	public T desenfileira (FilaCircular<T> f){
	   T item = f.getInicio().getInfo();
	    if (f.getInicio() == f.getFim()) {
	    	f.setInicio(null);
	        f.setFim(f.getInicio());
	    }else {
	    	f.getFim().setProx(f.getInicio().getProx());
	    	f.setInicio(f.getInicio().getProx());
	    }
	    return item;
	}
	
	public void imprime(FilaCircular<T> f){
	    if(vazia(f))
	        System.out.println("Fila vazia");
	    else{
	    	No<T> aux = f.getInicio();
			System.out.print("[");
			while (aux != f.getFim()) {
				System.out.print(aux.getInfo() + " ");
				aux = aux.getProx();
			}
			System.out.print(f.getFim().getInfo());
			System.out.println("]");
	    }
	}

	public FilaCircular<T> FFVazia (FilaCircular<T> f){
	    f.setInicio(null); 
	    f.setFim(f.getInicio());
	    return f;
	}

}
