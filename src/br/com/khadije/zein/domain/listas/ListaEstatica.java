package br.com.khadije.zein.domain.listas;

import java.lang.reflect.Array;

import br.com.khadije.zein.service.interfaces.ListaService;

public class ListaEstatica<T extends Comparable <T>> implements ListaService<T,ListaEstatica<T>>{
	public static int tam_max = 1000;
	private T[] item;
	private Integer pos_livre;

	public ListaEstatica(Class<T> c) {
		super();
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) Array.newInstance(c, tam_max);
		this.item = aux;
		this.pos_livre = 0;
	}

	public T[] getItem() {
		return item;
	}

	public void setItem(T[] item) {
		this.item = item;
	}

	public Integer getPos_livre() {
		return pos_livre;
	}

	public void setPos_livre(Integer pos_livre) {
		this.pos_livre = pos_livre;
	}
	
	@Override
	public ListaEstatica<T> insereInicio(ListaEstatica<T> l, T x) {
		if (isCheia(l))
			System.out.println("Lista cheia");
		else {
			for (int i = l.getPos_livre(); i > 0; i--)
				l.getItem()[i] = l.getItem()[i - 1];

			l.getItem()[0] = x;
			l.setPos_livre(l.getPos_livre() + 1);
		}
		return l;
	}

	@Override
	public ListaEstatica<T> remover(ListaEstatica<T> l, T x) {
		if(vazia(l))
			System.out.println("Lista vazia: sem elementos para retirar");
		else {
			Integer pos = 0;
			pos = busca(l, x);
			if (pos== null)
				System.out.println("Elemento não encontrado");
			else {
				for(int i = pos; i < l.getPos_livre(); i++)
					l.getItem()[i] = l.getItem()[i+1];
				l.setPos_livre(l.getPos_livre()-1);
			}
		}
		return l;
	}

	@Override
	public Integer busca(ListaEstatica<T> l, T x) {
		Integer pos=0;
		while(l.getItem()[pos]!=x && pos < l.getPos_livre())
			pos++;
		if (pos == l.getPos_livre())
			return null;
		else
			return pos;
	}

	@Override
	public ListaEstatica<T> FLVazia(ListaEstatica<T> l) {
		for (int i = 0; i < l.getPos_livre(); i++)
	    {
	        l.getItem()[i]= null;
	        l.setPos_livre(0); 
	    }
		return l;
	}

	@Override
	public ListaEstatica<T> insereFim(ListaEstatica<T> l, T x) {
		if (isCheia(l))
			System.out.println("Lista cheia");
		else {
			l.getItem()[l.getPos_livre()] = x;
			l.setPos_livre(l.getPos_livre() + 1);
		}
		return l;

	}

	@Override
	public ListaEstatica<T> insereP(ListaEstatica<T> l, T x, Integer p) {
		if(isCheia(l))
			System.out.println("Lista cheia");
		else if (p > l.getPos_livre())
			l  = insereFim(l, x);
		else {
			for(int i = l.getPos_livre(); i > p-1; i--)
				l.getItem()[i] = l.getItem()[i-1];	
			l.getItem()[p] = x;
			l.setPos_livre(l.getPos_livre()+1);
		}
		return l;
	}

	@Override
	public T retira(Integer p, ListaEstatica<T> l, T x) {
		if (l.getItem()[p]==x) {
			for(int i = p; i < l.getPos_livre(); i++)
				l.getItem()[i] = l.getItem()[i+1];	
			l.setPos_livre(l.getPos_livre()-1);
			return x;
		}
		return null;
	}

	@Override
	public Boolean vazia(ListaEstatica<T> l) {
		return (l.getPos_livre().equals(0));
	}

	public Boolean isCheia(ListaEstatica<T> l) {
		return (l.getPos_livre() >= ListaEstatica.tam_max);
	}

	@Override
	public void imprime(ListaEstatica<T> l) {
		if(vazia(l))
			System.out.println("Lista vazia");
		else {
			System.out.print("[");
			for(int i = 0 ; i < l.getPos_livre(); i++)
				System.out.print(l.getItem()[i]+ " ");
			System.out.println("]");
		}
	}

	@Override
	public ListaEstatica<T> ordenar(ListaEstatica<T> l) {
		for (int i = 0; i < l.getPos_livre()-1; i++) 
            for (int j = 0; j < l.getPos_livre()-i-1; j++) 
                if (l.getItem()[j].compareTo(l.getItem()[j+1]) > 0) 
                { 
                	T temp = l.getItem()[j]; 
                    l.getItem()[j] = l.getItem()[j+1]; 
                    l.getItem()[j+1] = temp; 
                }
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ListaEstatica<T> concatenar(ListaEstatica<T> l1, ListaEstatica<T> l2) {
		Integer pos1, pos2;
		ListaEstatica<T> l3 = new ListaEstatica<T>((Class<T>) Comparable.class);
		
		pos1 = l1.getPos_livre();
		pos2 = l2.getPos_livre();
		
		if( (pos1 + pos2 -1) < ListaEstatica.tam_max) {
			for(int i=0; i<pos1; i++) {
				insereFim(l3, l1.getItem()[i]);
			}
			
			for(int i=0; i<pos2; i++) {
				insereFim(l3, l2.getItem()[i]);
			}
			
		}
		else {
			System.out.println("Não é possível concatenar. Tamanho excede TAM_MAX");
		}
		
		return l3;

	}
	

}
