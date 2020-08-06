package br.com.khadije.zein.domain;

public class ListaEncadeadaSentinela<T extends Comparable<T>> extends ListaEncadeada<T> {

	private No<T> sentinela;
	
	public ListaEncadeadaSentinela() {
		super();
		this.sentinela  = new No<T>(null);
		this.setPrimeiro(this.sentinela);
		this.setUltimo(this.sentinela);
	}

	public No<T> getSentinela() {
		return sentinela;
	}

	public void setSentinela(No<T> sentinela) {
		this.sentinela = sentinela;
	}
	

}
