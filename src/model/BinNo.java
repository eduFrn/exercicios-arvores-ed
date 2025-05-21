package model;

public class BinNo {
	int valor;
	BinNo esq, dir;
	int nivel;

	public BinNo(int valor) {
		this.valor = valor;
		this.nivel = 0;
		esq = dir = null;
	}
}
