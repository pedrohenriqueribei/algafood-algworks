package br.com.mudi.mudi.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.mudi.mudi.DTOs.NovoPedidoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	
	@Column(length = 1000)
	private String urlProduto;
	
	@Column(length = 1000)
	private String urlImagem;
	
	@Column(length = 1000)
	private String descricao;
	
	@Enumerated (EnumType.STRING)
	private Status status;
	
	public Pedido(NovoPedidoDTO dados) {
		this.descricao = dados.descricao();
		this.urlProduto = dados.urlProduto();
		this.urlImagem = dados.urlImagem();
		this.nomeProduto = dados.nomeProduto();
		this.status = Status.AGUARDANDO;
	}
}
