package com.fiap.inventario;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.loja.EstoqueBO;
import com.fiap.loja.to.ProdutoTO;

public class Estoque {

	public List<ProdutoTO> listar() {
		List<ProdutoTO> produtos = new ArrayList<>();
		
		produtos.add(new ProdutoTO(1, "Camiseta Azul", 10.0, ""));
		produtos.add(new ProdutoTO(2, "Camiseta Rosa", 20.0, ""));
		
		return produtos;
	}
	
	/**
	 * Método para retornar um produto através do código do produto.
	 * @param codProduto
	 * @return ProdutoTO - Produto encontrado com o código inserido.
	 */
	public ProdutoTO buscarProduto(String codProduto) {
		
		EstoqueBO estoqueBO = new EstoqueBO();
		ProdutoTO produtoBuscado = new ProdutoTO();
		
		try {
			produtoBuscado = estoqueBO.consultarProduto(Integer.parseInt(codProduto));
			
			if (produtoBuscado == null)
				throw new AxisFault("Produto não encontrado");
			
		} catch (AxisFault err) {
			err.printStackTrace();
		}
		
		return produtoBuscado;
	}
	
}
