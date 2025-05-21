package view;

import model.BArvore;
import model.BinNo;

public class Main {
	public static void main(String[] args) {

		// Preenchendo a arvore
		BArvore arvore1 = new BArvore();
		arvore1.inserirNo(new BinNo(14));
		arvore1.inserirNo(new BinNo(16));
		arvore1.inserirNo(new BinNo(12));
		arvore1.inserirNo(new BinNo(11));
		arvore1.inserirNo(new BinNo(17));
		arvore1.inserirNo(new BinNo(15));
		arvore1.inserirNo(new BinNo(10));
		arvore1.inserirNo(new BinNo(13));
		arvore1.exibir();

		// Resolução do exercicio 1. Definindo e exibindo os níveis dos elementos
		System.out.println("-".repeat(20));
		System.out.println("1.");
		arvore1.definirNivel();

		// Resolução do exercicio 2. Retornando a quantidade de elementos da árvore
		System.out.println("\n"+"-".repeat(20));
		System.out.println("2.");
		arvore1.contar();

		// Resolução do exercicio 3. Encontrando nó e imprimindo seus antecessores.
		System.out.println("\n"+"-".repeat(20));
		System.out.println("3.");
		arvore1.procurar(10);

		// Resolução do exercicio 4. Exibindo as folhas da árvore em ordem crescente.
		System.out.println("\n"+"-".repeat(20));
		System.out.println("4.");
		arvore1.exibirFolhas();

	}
}
