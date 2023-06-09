package br.com.mudi.mudi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mudi.mudi.DTOs.NovoPedidoDTO;
import br.com.mudi.mudi.models.Pedido;
import br.com.mudi.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario(NovoPedidoDTO dados) {
		
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String salvar (@Valid NovoPedidoDTO dados, BindingResult result) {
//		Pedido pedido = dados.toPedido();
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = new Pedido(dados);
		
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}
	
	@GetMapping("atualizar/{id}")
	public String formularioAtualizar(@PathVariable Long id, Model model) {
		
		Pedido pedido = pedidoRepository.getReferenceById(id);
		//model.addAttribute("pedido", pedido);
		
		System.out.println(pedido.getNomeProduto());
		
		return "forward:/pedido/formulario_atualizar";
	}
	@PutMapping("atualizar")
	public int atualizar(@PathVariable Integer id, BindingResult result) {
		
		return id;
	}
	
}
