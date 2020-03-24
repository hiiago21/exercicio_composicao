package entidades;

public class OrdemItem {
	
	private Integer quantidade;
	private Double price;
	
	private Produto produto;

	public OrdemItem(Integer quantidade, Double price, Produto produto) {
		this.quantidade = quantidade;
		this.price = price;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return price * quantidade;
	}

	@Override
	public String toString() {
		return produto.getName()
				+ ", $"
				+ price
				+ ", Quantidade: "
				+ quantidade
				+ ", Subtotal: "
				+ subTotal();
	}
	
	

}
