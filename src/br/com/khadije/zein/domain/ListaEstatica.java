package br.com.khadije.zein.domain;

import java.lang.reflect.Array;

public class ListaEstatica<T extends Comparable <T>> {
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
	

}
