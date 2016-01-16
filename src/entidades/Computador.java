package entidades;

/**
 * Especialização de um produto, o automovel
 * 
 * @author Werneck e Amanda
 *
 */
public class Computador extends Produto {

	private String descricao;
	private float preco;
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public float getPreco() {
		return preco;
	}
	
	//setters
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
