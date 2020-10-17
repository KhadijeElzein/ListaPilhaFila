package br.com.khadije.zein.service.interfaces;

public interface ListaService<T extends Comparable<T>, R> {
	
	public R insereInicio(R l, T x);
	
	public R remover(R l, T x);
	
	public Integer busca(R l, T x);
	
	public R FLVazia(R l);
	
	public R insereFim(R l, T x);
	
	public R insereP(R l, T x, Integer p);

	public T retira(Integer p, R l , T x);
	
	public Boolean vazia(R l);
	
	public void imprime(R l);
	
	public R ordenar(R l);
	
	public R concatenar (R l1, R l2);


}