package br.com.khadije.zein.main;

import br.com.khadije.zein.domain.ListaEncadeada;
import br.com.khadije.zein.domain.ListaEncadeadaSentinela;
import br.com.khadije.zein.domain.ListaEstatica;
import br.com.khadije.zein.service.ListaEncadeadaSentinelaServiceImpl;
import br.com.khadije.zein.service.ListaEncadeadaServiceImpl;
import br.com.khadije.zein.service.ListaEstaticaServiceImpl;

public class Main {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
			ListaEstatica<Integer> l1 = new ListaEstatica<Integer>(Integer.class);
			ListaEstatica<Integer> l2 = new ListaEstatica<Integer>(Integer.class);
			ListaEstatica<Integer> l3 = new ListaEstatica<Integer>(Integer.class);
			ListaEstaticaServiceImpl<Integer> service = new ListaEstaticaServiceImpl<Integer>();
			l1 = service.insereFim(l1, 8);
			l1 = service.insereFim(l1, 7);
			l1 = service.insereFim(l1, 6);
			l1 = service.insereFim(l1, 5);
			l1 = service.insereFim(l1, 4);
			l1 = service.insereFim(l1, 3);
			l1 = service.insereFim(l1, 2);
			l1 = service.insereFim(l1, 1);
			System.out.println("A lista digitada pelo usuario eh: \n");
			service.imprime(l1);
			
			l1 = service.ordenar(l1);
			System.out.println("\nA lista ordenada eh: \n");
			service.imprime(l1);
			
			l1 = service.remover(l1, 3);
			l1 = service.insereInicio(l1,100);
			l1 = service.insereP(l1, 200, 5);
			l1 = service.insereP(l1, 50, 15);
			service.imprime(l1);
			System.out.println("A posicao do item 6 eh" + service.busca(l1, 6));
			
			System.out.println("A lista sem o valor "+service.retira(service.busca(l1,6),l1, 6)+ "fica:"); 
			service.imprime(l1);
			
			l2=l1;
			System.out.println("A nova lista e uma copia da lista anterior:");
			service.imprime(l2);
			
			System.out.println("\n\nSomando as duas, temos: \n\n");
			l3=service.concatenar(l1, l2);
			service.imprime(l3);
			
			System.out.println("Havera o numero 1 aqui para testar se a nova lista esta cheia: " + service.isCheia(l3));
			l3 = service.insereFim(l3, 300);
			service.imprime(l3);

			service.FLVazia(l3);
			System.out.println("\n\nA lista apos limpar fica: \n\n");
			service.imprime(l3);
			
			ListaEncadeada<Integer> le1 = new ListaEncadeada<Integer>();
			ListaEncadeada<Integer> le2 = new ListaEncadeada<Integer>();
			ListaEncadeada<Integer> le3 = new ListaEncadeada<Integer>();
			ListaEncadeadaServiceImpl<Integer> serviceEncadeada = new 
					ListaEncadeadaServiceImpl<Integer>();
			le1 = serviceEncadeada.insereFim(le1, 8);
			le1 = serviceEncadeada.insereFim(le1, 7);
			le1 = serviceEncadeada.insereFim(le1, 6);
			le1 = serviceEncadeada.insereFim(le1, 5);
			le1 = serviceEncadeada.insereFim(le1, 4);
			le1 = serviceEncadeada.insereFim(le1, 3);
			le1 = serviceEncadeada.insereFim(le1, 2);
			le1 = serviceEncadeada.insereFim(le1, 1);
			System.out.println("A lista digitada pelo usuario eh: \n");
			serviceEncadeada.imprime(le1);
			
			le1 = serviceEncadeada.ordenar(le1);
			System.out.println("\nA lista ordenada eh: \n");
			serviceEncadeada.imprime(le1);
			
			le1 = serviceEncadeada.remover(le1, 3);
			le1 = serviceEncadeada.insereInicio(le1,100);
			le1 = serviceEncadeada.insereP(le1, 200, 5);
			serviceEncadeada.imprime(le1);
			System.out.println("A posicao do item 6 eh" + serviceEncadeada.busca(le1, 6));
			
			System.out.println("A lista sem o valor "+serviceEncadeada.retira(serviceEncadeada.busca(le1,6),le1, 6)+ "fica:"); 
			serviceEncadeada.imprime(le1);
			
			le2=le1;
			System.out.println("A nova lista e uma copia da lista anterior:");
			serviceEncadeada.imprime(le2);
			
			System.out.println("\n\nSomando as duas, temos: \n\n");
			le3=serviceEncadeada.concatenar(le1, le2);
			serviceEncadeada.imprime(le3);
			
			le3 = serviceEncadeada.insereFim(le3, 300);
			serviceEncadeada.imprime(le3);

			serviceEncadeada.FLVazia(le3);
			System.out.println("\n\nA lista apos limpar fica: \n\n");
			serviceEncadeada.imprime(le3);
			
			
			ListaEncadeadaSentinela<Integer> les1 = new ListaEncadeadaSentinela<Integer>();
			ListaEncadeadaSentinela<Integer> les2 = new ListaEncadeadaSentinela<Integer>();
			ListaEncadeadaSentinela<Integer> les3 = new ListaEncadeadaSentinela<Integer>();
			ListaEncadeadaSentinelaServiceImpl<Integer> serviceSentinela = new 
					ListaEncadeadaSentinelaServiceImpl<Integer>();
			les1 = serviceSentinela.insereFim(les1, 8);
			les1 = serviceSentinela.insereFim(les1, 7);
			les1 = serviceSentinela.insereFim(les1, 6);
			les1 = serviceSentinela.insereFim(les1, 5);
			les1 = serviceSentinela.insereFim(les1, 4);
			les1 = serviceSentinela.insereFim(les1, 3);
			les1 = serviceSentinela.insereFim(les1, 2);
			les1 = serviceSentinela.insereFim(les1, 1);
			System.out.println("A lista digitada pelo usuario eh: \n");
			serviceSentinela.imprime(les1);
			
			les1 = serviceSentinela.ordenar(les1);
			System.out.println("\nA lista ordenada eh: \n");
			serviceSentinela.imprime(les1);
			
			les1 = serviceSentinela.remover(les1, 3);

			
			les1 = serviceSentinela.insereInicio(les1,100);
			les1 = serviceSentinela.insereP(les1, 200, 5);
			serviceSentinela.imprime(les1);
			System.out.println("A posicao do item 6 eh" + serviceSentinela.busca(les1, 6));

			System.out.println("A lista sem o valor "+serviceSentinela.retira(serviceSentinela.busca(les1,6),les1, 6)+ "fica:"); 
			serviceSentinela.imprime(les1);
			
			les2=les1;
			System.out.println("A nova lista e uma copia da lista anterior:");
			serviceSentinela.imprime(les2);
			
			System.out.println("\n\nSomando as duas, temos: \n\n");
			les3=serviceSentinela.concatenar(les1, les2);
			serviceSentinela.imprime(les3);
			
			les3 = serviceSentinela.insereFim(les3, 300);
			serviceSentinela.imprime(les3);

			serviceSentinela.FLVazia(les3);
			System.out.println("\n\nA lista apos limpar fica: \n\n");
			serviceSentinela.imprime(les3);
			

	}

}
