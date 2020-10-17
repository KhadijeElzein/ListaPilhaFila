package br.com.khadije.zein.domain.filas;

public class FilaEstaticaCircular<T> extends FilaEstatica<T> {
	
	public FilaEstaticaCircular(Class<T> c) {
		super(c);
		this.setFim(0);
		this.setInicio(0);
	}

	public Boolean vazia(FilaEstaticaCircular<T> f) {
		return (f.getInicio() == f.getFim());
	}
	
	public Boolean cheia(FilaEstaticaCircular<T> f) {
	    return ((f.getFim()+1) % tam_max == f.getInicio());
	}

	public FilaEstaticaCircular<T> enfileira(FilaEstaticaCircular<T> f, T x){
	   if (!cheia(f)){
	       f.getItem()[f.getFim()]=x;
	       f.setFim((f.getFim()+1) % tam_max);
	   }else{
	       System.out.println("fila cheia");
	   } 
	   return f;
	}
	public T desinfileira(FilaEstaticaCircular<T> f) {
		if(!vazia(f)) {
			T aux = f.getItem()[f.getInicio()];
			f.setInicio((f.getInicio()+1)% tam_max);
			return aux;
		}else {
			System.out.println("Fila Vazia");
			return null;
		}
	}
	public FilaEstaticaCircular<T> FFVazia(FilaEstaticaCircular<T> f){
		f.setFim(0);
		f.setInicio(0);
		return f;
	}
	
	public void imprime(FilaEstaticaCircular<T> f){

	    if (cheia(f)){    
		       System.out.println("fila cheia");
	    }else    
	    if (!vazia(f)){
	    	System.out.print("[");
			for(int i = 0 ; i < f.getFim(); i++)
				System.out.print(f.getItem()[i]+ " ");
			System.out.println("]");
	    }else {
			System.out.println("Fila Vazia");
	      }
	}
	public Integer tamanho (FilaEstaticaCircular<T> f){
        Integer aux =tam_max - f.getFim() - f.getInicio();
	    if (f.getInicio()<= f.getFim())
	        aux = f.getFim() - f.getInicio();
	   return aux;
	};

}
