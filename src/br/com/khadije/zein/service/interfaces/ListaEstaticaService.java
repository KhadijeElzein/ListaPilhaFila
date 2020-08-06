package br.com.khadije.zein.service.interfaces;

import br.com.khadije.zein.domain.ListaEstatica;

public interface ListaEstaticaService<T extends Comparable<T>> {
	
	public ListaEstatica<T> insereInicio(ListaEstatica<T> l, T x);
	
	public ListaEstatica<T> remover(ListaEstatica<T> l, T x);
	
	public Integer busca(ListaEstatica<T> l, T x);
	
	public ListaEstatica<T> FLVazia(ListaEstatica<T> l);
	
	public ListaEstatica<T> insereFim(ListaEstatica<T> l, T x);
	
	public ListaEstatica<T> insereP(ListaEstatica<T> l, T x, Integer p);

	public T retira(Integer p, ListaEstatica<T> l , T x);
	
	public Boolean vazia(ListaEstatica<T> l);
	
	public void imprime(ListaEstatica<T> l);
	
	public ListaEstatica<T> ordenar(ListaEstatica<T> l);
	
	public ListaEstatica<T> concatenar (ListaEstatica<T> l1, ListaEstatica<T> l2) throws InstantiationException, IllegalAccessException;

}
