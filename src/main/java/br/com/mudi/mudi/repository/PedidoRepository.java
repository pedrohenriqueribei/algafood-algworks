package br.com.mudi.mudi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mudi.mudi.models.Pedido;
import br.com.mudi.mudi.models.Status;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(Status status);

}
