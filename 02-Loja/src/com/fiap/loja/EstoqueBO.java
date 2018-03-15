package com.fiap.loja;

import com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public ProdutoTO consultarProduto(int codigo) {
		ProdutoTO to = null;
		switch (codigo) {
		case 401:
			to = new ProdutoTO(401, "Camiseta Masculina",
					40, "Camiseta branca");
			break;
		case 402:
			to = new ProdutoTO(402, "Camiseta Feminina",
					50, "Camiseta rosa");
			break;
		}
		return to;
	}
	
}
