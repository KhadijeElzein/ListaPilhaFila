package br.com.khadije.zein.service.interfaces;

public interface ListaService<T extends Comparable<T>> {
	
	public T insereInicio(T l, T x);
	
	public T remover(T l, T x);
	
	public Integer busca(T l, T x);
	
	public T FLVazia(T l);
	
	public T insereFim(T l, T x);
	
	public T insereP(T l, T x, Integer p);

	public T retira(Integer p, T l , T x);
	
	public Boolean vazia(T l);
	
	public void imprime(T l);
	
	public T ordenar(T l);
	
	public T concatenar (T l1, T l2) throws InstantiationException, IllegalAccessException;

}
