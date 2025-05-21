package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BArvore {
	private BinNo raiz;

	private BinNo inserir(BinNo atual, BinNo novoNo) {
		if (atual == null)
			return novoNo;
		else if (novoNo.valor < atual.valor)
			atual.esq = inserir(atual.esq, novoNo);
		else
			atual.dir = inserir(atual.dir, novoNo);
		return atual;
	}

	public void inserirNo(BinNo novoNo) {
		raiz = inserir(raiz, novoNo);
	}

	public void exibir() {
		System.out.println("Exibindo elementos da árvore");
		exibirArvore(raiz);
	}

	private void exibirArvore(BinNo atual) {
		if (atual != null) {
			exibirArvore(atual.esq);
			System.out.println(atual.valor);
			exibirArvore(atual.dir);
		}
	}

	public void excluirNo(int item) {
		try {
			BinNo atual = raiz;
			BinNo pai = null, filho = null, temp = null;

			while (atual != null && atual.valor != item) {
				pai = atual;
				if (item < atual.valor)
					atual = atual.esq;
				else
					atual = atual.dir;
			}

			if (atual == null)
				System.out.println("Elemento não localizado");
			if (pai == null) {
				if (atual.dir == null)
					raiz = atual.esq;
				else if (atual.esq == null)
					raiz = atual.dir;
				else {
					for (temp = atual, filho = atual.esq; filho.dir != null; temp = filho, filho = filho.dir)
						;

					if (filho != atual.esq) {
						temp.dir = filho.esq;
						filho.esq = raiz.esq;
					}
					filho.dir = raiz.dir;
					raiz = filho;
				}
			} else if (atual.dir == null) {
				if (pai.esq == atual)
					pai.esq = atual.esq;
				else
					pai.dir = atual.esq;
			} else if (atual.esq == null) {
				if (pai.esq == atual)
					pai.esq = atual.dir;
				else
					pai.dir = atual.dir;
			} else {
				for (temp = atual, filho = atual.esq; filho.dir != null; temp = filho, filho = filho.dir)
					;

				if (filho != atual.esq) {
					temp.dir = filho.esq;
					filho.esq = atual.esq;
				}
				filho.dir = atual.dir;
				if (pai.esq == atual)
					pai.esq = filho;
				else
					pai.dir = filho;
			}
		} catch (NullPointerException erro) {
			// Elemento não encontrado
			System.err.println("[ERRO] Elemento não encontrado.");
		}
	}

	public void exibirInOrdem() {
		System.out.println("Exibir a árvore in-ordem");
		exibirInOrdem(raiz);
	}

	private void exibirInOrdem(BinNo atual) {
		if (atual != null) {
			exibirInOrdem(atual.esq);
			System.out.println(atual.valor);
			exibirInOrdem(atual.dir);
		}
	}

	public void exibirPreOrdem() {
		System.out.println("Exibir a árvore pré-ordem");
		exibirPreOrdem(raiz);
	}

	private void exibirPreOrdem(BinNo atual) {
		if (atual != null) {
			System.out.println(atual.valor);
			exibirPreOrdem(atual.esq);
			exibirPreOrdem(atual.dir);
		}
	}

	public void exibirPosOrdem() {
		System.out.println("Exibir a árvore pós-ordem");
		exibirPosOrdem(raiz);
	}

	private void exibirPosOrdem(BinNo atual) {
		if (atual != null) {
			exibirPosOrdem(atual.esq);
			exibirPosOrdem(atual.dir);
			System.out.println(atual.valor);
		}
	}

	public void exibirNivel() {
		System.out.println("Exibir a árvore em nível");
		exibirNivel(raiz);
	}

	private void exibirNivel(BinNo raiz) {
		LinkedList<BinNo> no = new LinkedList<BinNo>();
		no.add(raiz);
		while (!no.isEmpty()) {
			BinNo atual = no.pop();
			System.out.println(atual.valor);
			if (atual.esq != null)
				no.add(atual.esq);
			if (atual.dir != null)
				no.add(atual.dir);
		}
	}

	// Exercício 1
	public void definirNivel() {
		if(raiz == null) {
			System.out.println("Árvore vazia.");
			return;
		}
		
		System.out.println("Definindo e apresentando os elementos e seus níveis");
		definirNivel(raiz);
	}

	private void definirNivel(BinNo raiz) {
		LinkedList<BinNo> no = new LinkedList<BinNo>();
		no.add(raiz);
		while (!no.isEmpty()) {
			BinNo atual = no.pop();
			System.out.println("Elemento: " + atual.valor + " - Nível: " + atual.nivel);
			if (atual.esq != null) {
				atual.esq.nivel = atual.nivel + 1;
				no.add(atual.esq);
			}

			if (atual.dir != null) {
				atual.dir.nivel = atual.nivel + 1;
				no.add(atual.dir);
			}
		}
	}

	// Exercício 2
	public void contar() {
		if(raiz == null) {
			System.out.println("Árvore vazia.");
			return;
		}
		
		System.out.println("Contando elementos na árvore");
		System.out.println(contar(raiz));
	}

	private int contar(BinNo atual) {
		if (atual != null)
			return 1 + contar(atual.esq) + contar(atual.dir);

		return 0;
	}

	// Exercício 3
	public void procurar(int valor) {
		if(raiz == null) {
			System.out.println("Árvore vazia.");
			return;
		}
		System.out.println("Procurando pelo nó com valor: " + valor);

		ArrayList<BinNo> ant = new ArrayList<BinNo>();
		procurar(ant, valor, raiz);
	}

	private void procurar(ArrayList<BinNo> ant, int valor, BinNo atual) {
		if (atual != null) {
			if (atual.valor == valor) {
				System.out.println("Valor " + valor + " encontrado. Seus antecessores são: ");
				for (int i = 0; i < ant.size(); i++) {
					System.out.print(ant.get(i).valor);
					if (i < ant.size() - 1) {
						System.out.print(" -> ");
					}
				}
				System.out.println();
			} else {
				ant.add(atual);
				procurar(ant, valor, atual.esq);
				procurar(ant, valor, atual.dir);
				ant.remove(ant.size() - 1);
			}
		}
	}

	// Exercício 4
	public void exibirFolhas() {
		if(raiz == null) {
			System.out.println("Árvore vazia.");
			return;
		}
		
		System.out.println("Exibindo folhas da árvore");
		exibirFolhas(raiz);
	}

	private void exibirFolhas(BinNo atual) {
		if (atual != null) {
			exibirFolhas(atual.esq);
			if (atual.esq == null && atual.dir == null) {
				System.out.println(atual.valor);
			}
			exibirFolhas(atual.dir);
		}
	}

}