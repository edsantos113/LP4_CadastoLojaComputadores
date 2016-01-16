package entidades;

/**
 * Caracterização da venda
 * 
 * @author Amanda
 *
 */
public class Venda {

	private long id;
	private String data;
	private long registroVendedor;
	private String nomeComprador;
	private String cpfComprador;
	private long codigoProduto;
	private float desconto;
	private float valorTotal;
	
	//getters
	public long getCodigoProduto() {
		return codigoProduto;
	}
	
	public String getData() {
		return data;
	}
	
	public float getDesconto() {
		return desconto;
	}
	
	public long getId() {
		return id;
	}
	
	public long getRegistroVendedor() {
		return registroVendedor;
	}
	
	public String getNomeComprador() {
		return nomeComprador;
	}
	
	public String getCpfComprador() {
		return cpfComprador;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	//setters
	public void setCodigoProduto(long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setRegistroVendedor(long registroVendedor) {
		this.registroVendedor = registroVendedor;
	}
	
	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}
	
	public void setCpfComprador(String cpfComprador) {
		this.cpfComprador = cpfComprador;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}