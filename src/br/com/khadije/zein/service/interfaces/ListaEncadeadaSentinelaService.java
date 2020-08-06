package br.com.khadije.zein.service.interfaces;

import br.com.khadije.zein.domain.ListaEncadeadaSentinela;

public interface ListaEncadeadaSentinelaService<T extends Comparable<T>> {
	
	public ListaEncadeadaSentinela<T> insereInicio(ListaEncadeadaSentinela<T> l, T x);
	
	public ListaEncadeadaSentinela<T> remover(ListaEncadeadaSentinela<T> l, T x);
	
	public Integer busca(ListaEncadeadaSentinela<T> l, T x);
	
	public ListaEncadeadaSentinela<T> FLVazia(ListaEncadeadaSentinela<T> l);
	
	public ListaEncadeadaSentinela<T> insereFim(ListaEncadeadaSentinela<T> l, T x);
	
	public ListaEncadeadaSentinela<T> insereP(ListaEncadeadaSentinela<T> l, T x, Integer p);

	public T retira(Integer p, ListaEncadeadaSentinela<T> l , T x);
	
	public Boolean vazia(ListaEncadeadaSentinela<T> l);
	
	public void imprime(ListaEncadeadaSentinela<T> l);
	
	public ListaEncadeadaSentinela<T> ordenar(ListaEncadeadaSentinela<T> l);
	
	public ListaEncadeadaSentinela<T> concatenar (ListaEncadeadaSentinela<T> l1, ListaEncadeadaSentinela<T> l2);


}