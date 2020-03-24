package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.OrdemStatus;

public class Ordem {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private OrdemStatus status;
	
	private List<OrdemItem> itens = new ArrayList<>();
	private Cliente cliente;
	
	public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public List<OrdemItem> getItens() {
		return itens;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(OrdemItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrdemItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		
		for (OrdemItem L:itens) {
			sum += L.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Informações da Ordem: \n");
		sb.append("Hora da ordem: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status da ordem: ");
		sb.append(status + "\n");
		sb.append(cliente);
		sb.append("Itens da ordem: \n");
		for (OrdemItem L : itens) {
			sb.append(L + "\n");
		}
		sb.append("Preço tota: " + total());
		return sb.toString();
	}

}
