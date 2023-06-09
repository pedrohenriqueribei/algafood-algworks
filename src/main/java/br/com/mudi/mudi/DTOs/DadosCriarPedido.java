package br.com.mudi.mudi.DTOs;

import br.com.mudi.mudi.models.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosCriarPedido {
	
	private String nomeProduto;
	private String urlProduto;
	private String urlImagem; 
	private String descricao;
	
	public Pedido toPedido() {
		Pedido p = new Pedido();
		p.setDescricao(descricao);
		p.setNomeProduto(nomeProduto);
		p.setUrlImagem(urlImagem);
		p.setUrlProduto(urlProduto);
		
		return p;
	}

	
}
