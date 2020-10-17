package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.NoDuplamenteEncadeado;

public class ListaDuplamenteEncadeadaCircularSentinela<T extends Comparable<T>>  extends ListaDuplamenteEncadeadaSentinela<T> {

	
	public ListaDuplamenteEncadeadaCircularSentinela() {
		super();
		this.setSentinela(new NoDuplamenteEncadeado<T>(null));
		this.setPrimeiro(this.getSentinela());
		this.getPrimeiro().setProx(this.getPrimeiro());
		this.getPrimeiro().getProx().setAnterior(this.getPrimeiro());
		this.setUltimo(this.getPrimeiro());
	}

	Boolean vazia (ListaDuplamenteEncadeadaCircularSentinela<T> l){  
	    return ( l.getPrimeiro().getProx() == l.getPrimeiro());
	}

	public ListaDuplamenteEncadeadaCircularSentinela<T> insereInicio(ListaDuplamenteEncadeadaCircularSentinela<T> l, T x){
		NoDuplamenteEncadeado<T> aux = new NoDuplamenteEncadeado<T>(x); 
		if (!vazia(l)){
			 aux.setProx(l.getPrimeiro().getProx());
			 l.getPrimeiro().getProx().setAnterior(aux);
			 l.getPrimeiro().setProx(aux);
			 aux.setAnterior(l.getPrimeiro());

	   }else{
		   l.getPrimeiro().setProx(aux);
		   aux.setAnterior(l.getPrimeiro());
	       aux.setProx(l.getPrimeiro()); 
		   l.setUltimo(aux);			
	   }
	   l.getUltimo().setProx(l.getPrimeiro());
	   return l;
	}
	
	public ListaDuplamenteEncadeadaCircularSentinela<T> insereFim(ListaDuplamenteEncadeadaCircularSentinela<T> l, T x) {
		NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<T>(x);	      
	    novo.setAnterior(l.getUltimo());
	    if (vazia(l)) {
			novo.setAnterior(l.getPrimeiro().getProx());
			l.getPrimeiro().setProx(novo);
		} else {
			l.getUltimo().setProx(novo);
		}
	    
		l.setUltimo(novo);
	    novo.setProx(l.getPrimeiro());
	   return l;
	}
	
	 public ListaDuplamenteEncadeadaCircularSentinela<T> insereP (ListaDuplamenteEncadeadaCircularSentinela<T> l, T x, Integer p){
		 NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
			if (vazia(l)) {
				l.getPrimeiro().setProx(elemento);
				l.setUltimo(elemento);
			} else {
				if (p == 0)
					insereInicio(l, x);
				else {
					NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
					for (int i = 0; i < p - 1; i++) {
						aux = aux.getProx();
					}
					if (aux.equals(l.getSentinela()))
						System.out.println("posição acima do tamanho da lista");
					else if (aux.getProx().equals(l.getPrimeiro()))
						insereFim(l, x);
					else {
						NoDuplamenteEncadeado<T> store = aux.getProx();
						store.setAnterior(elemento);
						aux.setProx(elemento);
						elemento.setProx(store);
						elemento.setAnterior(aux);
					}
				}
			}
			l.getUltimo().setProx(l.getPrimeiro());
			return l;
	 }
	 public T retira(Integer p, ListaDuplamenteEncadeadaCircularSentinela<T> l, T x) {
		 if (vazia(l)) {
				System.out.println("Lista vazia");
		 } else {
		 NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
		 if (p == 0){
	    	l.getPrimeiro().setProx(aux.getProx());
	    	l.getPrimeiro().setAnterior(l.getPrimeiro());
	        } else {
	        	 for (int i = 0; i < p; i++) {
	     			aux = aux.getProx();
	     		}if (aux.getInfo().equals(x)) {
	     			if(aux.getProx().equals(l.getPrimeiro())) {
	     				aux.getAnterior().setProx(l.getPrimeiro());
	     			}else {
	     				aux.getProx().setAnterior(aux.getAnterior());
	     				aux.getAnterior().setProx(aux.getProx());
	     			}
	     		}
	        }
	     }
		 l.getUltimo().setProx(l.getPrimeiro());
		 return x;
	}
	public ListaDuplamenteEncadeadaCircularSentinela<T> remover(ListaDuplamenteEncadeadaCircularSentinela<T> l , T x) {
		if (!vazia(l)){
		  l.getSentinela().setInfo(x);
	      NoDuplamenteEncadeado<T> p = l.getSentinela();
	      do {
				p = p.getProx();
		   } while (p.getInfo() != x);
	      if (p.getProx() != l.getPrimeiro()) { // elemento encontrado
				if (p == l.getPrimeiro().getProx()) // remoção na cabeça
					l.getPrimeiro().setProx(l.getPrimeiro().getProx().getProx());
				else {
					p.getAnterior().setProx(p.getProx());
					p.getProx().setAnterior(p.getAnterior());
				}
	      }else {
	    	  p.getAnterior().setProx(l.getPrimeiro());
	      }
	   }else{
	       System.out.println("Lista vazia ");
	   }
	  return l;
	}
	
	public Integer busca(ListaDuplamenteEncadeadaCircularSentinela<T> l, T x) {
		   Integer posicao = 0;
		   l.getSentinela().setInfo(x);
		   NoDuplamenteEncadeado<T> p = l.getSentinela();		
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
	   
	public ListaDuplamenteEncadeadaCircularSentinela<T> concatenar(ListaDuplamenteEncadeadaCircularSentinela<T> l1, ListaDuplamenteEncadeadaCircularSentinela<T> l2 ){
		 NoDuplamenteEncadeado<T> atual1 = l1.getPrimeiro().getProx();
		 NoDuplamenteEncadeado<T> atual2 = l2.getPrimeiro().getProx();
		 ListaDuplamenteEncadeadaCircularSentinela<T> l3 = new ListaDuplamenteEncadeadaCircularSentinela<T>();
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
	
	public ListaDuplamenteEncadeadaCircularSentinela<T> ordenar(ListaDuplamenteEncadeadaCircularSentinela<T> l){
		NoDuplamenteEncadeado<T> atual = l.getPrimeiro().getProx();
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
		return l;
	}
	
	public ListaDuplamenteEncadeadaCircularSentinela<T> FLVazia(ListaDuplamenteEncadeadaCircularSentinela<T> l) {
		NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
		do {
			aux.setInfo(null);
			aux = aux.getProx();
		} while (aux != l.getPrimeiro());
		l.getPrimeiro().setAnterior(l.getSentinela());
		l.setPrimeiro(l.getSentinela());
		l.setUltimo(l.getSentinela());
		l.getUltimo().setProx(l.getPrimeiro());
		l.getUltimo().setAnterior(l.getSentinela());
		return l;
	}
	
	public void imprime(ListaDuplamenteEncadeadaCircularSentinela<T> l)
	{
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
			System.out.print("[");
			do {
				System.out.print(aux.getInfo()+ " ");
				aux = aux.getProx();
			}while (aux != l.getPrimeiro());
			System.out.println("]");
		}
	}	
}
