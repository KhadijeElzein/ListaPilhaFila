package br.com.khadije.zein.domain;

public class ListaEncadeada<T extends Comparable <T>> {
	
	private No<T> primeiro;
	
	private No<T> ultimo;

	public ListaEncadeada() {
		super();
		this.primeiro = null;
		this.ultimo = null;
	}

	public No<T> getPrimeiro() {
		return primeiro;
	}
	
	public void setPrimeiro(No<T> primeiro) {
		this.primeiro = primeiro;
	}
	
	public No<T> getUltimo() {
		return ultimo;
	}
	
	public void setUltimo(No<T> ultimo) {
		this.ultimo = ultimo;
	}
}
