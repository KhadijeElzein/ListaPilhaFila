package br.com.khadije.zein.domain.listas;

import br.com.khadije.zein.domain.NoDuplamenteEncadeado;

public class ListaDuplamenteEncadeadaSentinela<T extends Comparable<T>> extends ListaDuplamenteEncadeada<T> {

	private NoDuplamenteEncadeado<T> sentinela;
	
	public ListaDuplamenteEncadeadaSentinela() {
		super();
		this.sentinela  = new NoDuplamenteEncadeado<T>(null);
		this.setPrimeiro(this.sentinela);
		this.setUltimo(this.sentinela);
	}

	public NoDuplamenteEncadeado<T> getSentinela() {
		return sentinela;
	}

	public void setSentinela(NoDuplamenteEncadeado<T> sentinela) {
		this.sentinela = sentinela;
	}
	
	
	public ListaDuplamenteEncadeadaSentinela<T> insereInicio(ListaDuplamenteEncadeadaSentinela<T> l, T x) {
		NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
		elemento.setAnterior(null);
		elemento.setProx(l.getPrimeiro().getProx());
		if (vazia(l)) {
			l.setUltimo(elemento);
		} else {
			l.getPrimeiro().getProx().setAnterior(elemento);
		}
		l.getPrimeiro().setProx(elemento);
		return l;
	}
	
	public ListaDuplamenteEncadeadaSentinela<T> remover(ListaDuplamenteEncadeadaSentinela<T> l, T x) {
		if (!vazia(l)) {
			NoDuplamenteEncadeado<T> p = l.getPrimeiro().getProx();
			while(p != null && p.getInfo() != x) {
			    p = p.getProx();
			    		
			}
		    if(p != null) {
		    	if(p != l.getPrimeiro().getProx()) {
		    	 p.getAnterior().setProx(p.getProx());
		    	} else {
		    		l.getPrimeiro().setProx(p.getProx());
		    	}
		    	if(p != l.getUltimo()) {
			 		p.getProx().setAnterior(p.getAnterior());
		    	} else {
					l.setUltimo(p.getAnterior());
		    	}
		    }else System.out.println("Elemento não encontrado");
		}else System.out.println("Lista vazia");
		return l;
	}

	
	public Integer busca(ListaDuplamenteEncadeadaSentinela<T> l, T x) {
		Integer posicao = 0;
		if (!vazia(l)) {
			NoDuplamenteEncadeado<T> p = l.getPrimeiro().getProx();
			while(p != null && p.getInfo() != x) {
			    p = p.getProx();
				posicao++;
			}
			if (p != null) {
				return posicao;
			} 	
		}
		return null;
	 }

	
	public ListaDuplamenteEncadeadaSentinela<T> FLVazia(ListaDuplamenteEncadeadaSentinela<T> l) {
		NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
		while(aux!=null) {
			aux.setInfo(null);
			aux.setAnterior(null);
			aux = aux.getProx();
		}
		l.getPrimeiro().getProx().setAnterior(null);
		l.getPrimeiro().setProx(null);
		l.getUltimo().setAnterior(null);
		l.getUltimo().setProx(null);
		l.setUltimo(l.getSentinela());
		l.setPrimeiro(l.getSentinela());
		return l;
	}
	
	public ListaDuplamenteEncadeadaSentinela<T> insereFim(ListaDuplamenteEncadeadaSentinela<T> l, T x) {
		NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
		elemento.setProx(null);
		elemento.setAnterior(l.getUltimo());
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
		} else {
			l.getUltimo().setProx(elemento);
		}
		l.setUltimo(elemento);
		return l;
	}

	
	
	public ListaDuplamenteEncadeadaSentinela<T> insereP(ListaDuplamenteEncadeadaSentinela<T> l, T x, Integer p) {
		NoDuplamenteEncadeado<T> elemento = new NoDuplamenteEncadeado<T>(x);
		if (vazia(l)) {
			l.getPrimeiro().setProx(elemento);
			l.setUltimo(elemento);
			l.getPrimeiro().getProx().setAnterior(null);  
			l.getUltimo().setProx(null);
		} else {
			if (p == 0)
				insereInicio(l, x);
			else {
				NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
				for (int i = 0; i < p - 1; i++) {
					aux = aux.getProx();
				
				}
				if(aux == null) System.out.println("posição acima do tamanho da lista");
				else {
					NoDuplamenteEncadeado<T> store = aux.getProx();
					if(store==null)
						insereFim(l,x);
					else {
						store.setAnterior(aux);
						aux.setProx(elemento);
						elemento.setAnterior(aux);
						elemento.setProx(store);
						store.setAnterior(elemento);
					}
				}
			}
		}
		return l;
	}

	
	public T retira(Integer p, ListaDuplamenteEncadeadaSentinela<T> l, T x) {
		NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
		for (int i = 0; i < p; i++) {
			aux = aux.getProx();
		}
		if (aux.getInfo().equals(x)) {
			if(aux.equals(l.getPrimeiro().getProx())) {
				l.getPrimeiro().setProx(aux.getProx());
			}else  aux.getAnterior().setProx(aux.getProx());
		}
		return x;
	}

	
	public Boolean vazia(ListaDuplamenteEncadeadaSentinela<T> l) {
		return (l.getPrimeiro().getProx() == null);
	}

	
	public void imprime(ListaDuplamenteEncadeadaSentinela<T> l) {
		if (vazia(l))
			System.out.println("Lista vazia");
		else {
			NoDuplamenteEncadeado<T> aux = l.getPrimeiro().getProx();
			System.out.print("[");
			while (aux != null) {
				System.out.print(aux.getInfo()+ " ");
				aux = aux.getProx();
			}
			System.out.println("]");
		}
	}

	
	public ListaDuplamenteEncadeadaSentinela<T> ordenar(ListaDuplamenteEncadeadaSentinela<T> l) {
		NoDuplamenteEncadeado<T> atual = l.getPrimeiro().getProx();
		while (atual != null) {
			NoDuplamenteEncadeado<T> prox = atual.getProx();
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

	
	public ListaDuplamenteEncadeadaSentinela<T> concatenar(ListaDuplamenteEncadeadaSentinela<T> l1, ListaDuplamenteEncadeadaSentinela<T> l2) {
		 NoDuplamenteEncadeado<T> atual1 = l1.getPrimeiro().getProx();
		 NoDuplamenteEncadeado<T> atual2 = l2.getPrimeiro().getProx();
		 ListaDuplamenteEncadeadaSentinela<T> l3 = new ListaDuplamenteEncadeadaSentinela<T>();
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
         return l3;
	}

}
