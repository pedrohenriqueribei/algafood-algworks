package br.com.mudi.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mudi.mudi.models.Pedido;
import br.com.mudi.mudi.models.Status;
import br.com.mudi.mudi.repository.PedidoRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;

	@GetMapping
	public String home(Model model) {

		List<Pedido> pedidos = repository.findAll();
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String aguardando(@PathVariable String status, Model model) {
		
		List<Pedido> pedidos = repository.findByStatus(Status.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
