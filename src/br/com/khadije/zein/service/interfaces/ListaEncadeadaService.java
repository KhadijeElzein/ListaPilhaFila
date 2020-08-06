package br.com.khadije.zein.service.interfaces;

import br.com.khadije.zein.domain.ListaEncadeada;

public interface ListaEncadeadaService<T extends Comparable<T>> {
	
	public ListaEncadeada<T> insereInicio(ListaEncadeada<T> l, T x);
	
	public ListaEncadeada<T> remover(ListaEncadeada<T> l, T x);
	
	public Integer busca(ListaEncadeada<T> l, T x);
	
	public ListaEncadeada<T> FLVazia(ListaEncadeada<T> l);
	
	public ListaEncadeada<T> insereFim(ListaEncadeada<T> l, T x);
	
	public ListaEncadeada<T> insereP(ListaEncadeada<T> l, T x, Integer p);

	public T retira(Integer p, ListaEncadeada<T> l , T x);
	
	public Boolean vazia(ListaEncadeada<T> l);
	
	public void imprime(ListaEncadeada<T> l);
	
	public ListaEncadeada<T> ordenar(ListaEncadeada<T> l);
	
	public ListaEncadeada<T> concatenar (ListaEncadeada<T> l1, ListaEncadeada<T> l2);


}
