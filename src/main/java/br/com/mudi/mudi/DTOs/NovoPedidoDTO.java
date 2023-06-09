package br.com.mudi.mudi.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NovoPedidoDTO(
		@NotBlank @Size(min = 5, max = 255)
		String nomeProduto,
		@NotBlank @Size(min = 5, max = 1000) 
		String urlProduto, 
		@NotBlank @Size(min = 5, max = 1000)
		String urlImagem,
		@Size(min = 5, max = 1000)
		String descricao
)
{
}
