package cadastro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.ComputadorDAO;
import DAO.VendaDAO;
import DAO.VendedorDAO;
import entidades.Computador;
import entidades.Venda;
import entidades.Vendedor;

public class OpcoesMenu {

	/* ################################ PRODUTOS ################################ */

	//tela de cadastro de novos computadores
	public static void menuCadastrarProduto(){

		Computador computador = new Computador();

		Menus.desenhaLinha();
		//lê informações do teclado
		computador.setCodigo(Teclado.getLong("Codigo"));
		computador.setDescricao(Teclado.getString("Descricao"));
		computador.setPreco(Teclado.getFloat("Preco"));
		Menus.desenhaLinha();

		int confirma = Teclado.getInt("Confirmar Cadastro?(0->sim/1->nao)");

		if (confirma == 0){
			try{
				ComputadorDAO computadorDAO = new ComputadorDAO();
				computadorDAO.adiciona(computador);
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! " + e.toString());
				Menus.menuPrincipal();
			}

			System.out.println("Dados Inseridos No Banco!");
			System.out.println("Pressione uma tecla para continuar");

			try{
				System.in.read();
			}catch(IOException e){
				System.out.println(e.toString());
			}
			Menus.menuPrincipal();
		}else{
			Menus.menuPrincipal();
		}
	}

	//tela de exclusão de produto
	public static void menuExcluirProduto() {

		Menus.desenhaLinha();
		long codigo = Teclado.getLong("Codigo");
		Computador computador=null;

		try{
			ComputadorDAO computadorDAO = new ComputadorDAO();
			computador = computadorDAO.getComputador(codigo);
		}catch (SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
		}catch (Exception e){
			System.out.println(e.toString());
		}

		Menus.desenhaLinha();
		System.out.println("Codigo: "+ computador.getCodigo());
		System.out.println("Descricao: "+ computador.getDescricao());
		System.out.println("Preco: "+ computador.getPreco());
		Menus.desenhaLinha();
		int confirma = Teclado.getInt("Confirmar Exclusao?(0->sim / 1->nao)");

		if (confirma == 0){
			try{
				ComputadorDAO computadorDAO = new ComputadorDAO();
				computadorDAO.exclui(computador.getCodigo());
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! "+e.toString());
				Menus.menuPrincipal();
			}
			System.out.println("Dados Excluidos do Banco!");
			Teclado.pause();
			Menus.menuPrincipal();
		}else{
			Menus.menuPrincipal();
		}
	}

	//tela de edição de produto
	public static void menuEditarProduto(){

		Menus.desenhaLinha();
		long codigo = Teclado.getLong("Codigo");
		Computador computador=null;

		try{
			ComputadorDAO computadorDAO = new ComputadorDAO();
			computador = computadorDAO.getComputador(codigo);
		}catch (SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}catch (Exception e){
			System.out.println(e.toString());
			Menus.menuPrincipal();
		}

		Menus.desenhaLinha();
		System.out.println("Codigo: "+ computador.getCodigo());
		System.out.println("Descrição: "+ computador.getDescricao());
		System.out.println("Preco: "+ String.format("%.02f", computador.getPreco()));
		Menus.desenhaLinha();
		int confirma = Teclado.getInt("Editar esse Produto?(0->sim / 1->nao)");
		if(confirma == 0){
			menuEditar(computador);
			try{
				ComputadorDAO computadorDAO = new ComputadorDAO();
				computadorDAO.atualiza(computador);
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! "+e.toString());
				Menus.menuPrincipal();
			}
			System.out.println("Dados Atualizados No Banco!");
			Teclado.pause();
			Menus.menuPrincipal();

		}else{
			Menus.menuPrincipal();
		}

	}

	//menu de opções dos campos do computador disponiveis para edição
	public static void menuEditar(Computador computador){

		Menus.desenhaLinha();
		System.out.println("1. Editar Descrição");
		System.out.println("2. Editar Preco");
		Menus.desenhaLinha();

		int op = Teclado.getInt("Opcao");

		switch (op)
		{
		case 1:
			computador.setDescricao(Teclado.getString("Nova Descricao"));
			break;
		case 2:
			computador.setPreco(Teclado.getFloat("Novo Preco"));
			break;
		default:
			System.out.println("Opcao Invalida!");
			menuEditar(computador);
			break;
		}
	}

	/* ################################ FIM - PRODUTOS ################################ */

	/* ################################ VENDEDOR ################################ */
	public static void menuCadastrarVendedor(){

		Vendedor vendedor = new Vendedor();

		Menus.desenhaLinha();
		//lê informações do teclado
		vendedor.setRegistro(Teclado.getLong("Registro"));
		vendedor.setNome(Teclado.getString("Nome"));
		Menus.desenhaLinha();

		int confirma = Teclado.getInt("Confirmar Cadastro?(0->sim/1->nao)");

		if (confirma == 0){
			try{
				VendedorDAO vendedorDAO = new VendedorDAO();
				vendedorDAO.adiciona(vendedor);
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! " + e.toString());
				Menus.menuPrincipal();
			}

			System.out.println("Dados Inseridos No Banco!");
			System.out.println("Pressione uma tecla para continuar");

			try{
				System.in.read();
			}catch(IOException e){
				System.out.println(e.toString());
			}
			Menus.menuPrincipal();
		}else{
			Menus.menuPrincipal();
		}
	}
	
	public static void menuExcluirVendedor() {

		Menus.desenhaLinha();
		long registro = Teclado.getLong("Registro");
		Vendedor vendedor=null;

		try{
			VendedorDAO vendedorDAO = new VendedorDAO();
			vendedor = vendedorDAO.getVendedor(registro);
		}catch (SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
		}catch (Exception e){
			System.out.println(e.toString());
		}

		Menus.desenhaLinha();
		System.out.println("Registro: "+ vendedor.getRegistro());
		System.out.println("Nome: "+ vendedor.getNome());
		Menus.desenhaLinha();
		int confirma = Teclado.getInt("Confirmar Exclusao?(0->sim / 1->nao)");

		if (confirma == 0){
			try{
				VendedorDAO vendedorDAO = new VendedorDAO();
				vendedorDAO.exclui(vendedor.getRegistro());
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! "+e.toString());
				Menus.menuPrincipal();
			}
			System.out.println("Dados Excluidos do Banco!");
			Teclado.pause();
			Menus.menuPrincipal();
		}else{
			Menus.menuPrincipal();
		}
	}
	
	public static void menuEditarVendedor(){

		Menus.desenhaLinha();
		long registro = Teclado.getLong("Registro");
		Vendedor vendedor=null;

		try{
			VendedorDAO vendedorDAO = new VendedorDAO();
			vendedor = vendedorDAO.getVendedor(registro);
		}catch (SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}catch (Exception e){
			System.out.println(e.toString());
			Menus.menuPrincipal();
		}

		Menus.desenhaLinha();
		System.out.println("Registro: "+ vendedor.getRegistro());
		System.out.println("Nome: "+ vendedor.getNome());
		Menus.desenhaLinha();
		int confirma = Teclado.getInt("Editar esse Produto?(0->sim / 1->nao)");
		if(confirma == 0){
			menuEditarV(vendedor);
			try{
				VendedorDAO vendedorDAO = new VendedorDAO();
				vendedorDAO.atualiza(vendedor);
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! "+e.toString());
				Menus.menuPrincipal();
			}
			System.out.println("Dados Atualizados No Banco!");
			Teclado.pause();
			Menus.menuPrincipal();

		}else{
			Menus.menuPrincipal();
		}

	}

	//menu de opções dos campos do computador disponiveis para edição
	public static void menuEditarV(Vendedor vendedor){

		Menus.desenhaLinha();
		System.out.println("1. Editar Registro");
		System.out.println("2. Editar Nome");
		Menus.desenhaLinha();

		int op = Teclado.getInt("Opcao");

		switch (op)
		{
		case 1:
			vendedor.setRegistro(Teclado.getLong("Nome Registro"));
			break;
		case 2:
			vendedor.setNome(Teclado.getString("Novo Nome:"));
			break;
		default:
			System.out.println("Opcao Invalida!");
			menuEditarV(vendedor);
			break;
		}
	}

	/* ################################ FIM - VENDEDOR ################################ */

	/* ################################ VENDAS ################################ */

	//tela para cadastro de vendas
	public static void menuRealizarVenda() {

		Menus.desenhaLinha();
		Venda venda = new Venda();

		venda.setId(Teclado.getLong("Identificador"));
		venda.setData(Teclado.getString("Data"));
		venda.setRegistroVendedor(Teclado.getLong("Codigo do Vendedor"));
		venda.setNomeComprador(Teclado.getString("Nome do Comprador"));
		venda.setCpfComprador(Teclado.getString("CPF do Comprador"));
		venda.setCodigoProduto(Teclado.getLong("Codigo do Produto"));
		venda.setDesconto(Teclado.getFloat("Desconto"));

		Computador computador = null;

		try{
			ComputadorDAO computadorDAO = new ComputadorDAO();
			computador = computadorDAO.getComputador(venda.getCodigoProduto());
		}catch (SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}catch (Exception e){
			System.out.println(e.toString());
			Menus.menuPrincipal();
		}
		//calculo do valor total da venda(valor do produto+valor dos acessorios-valor do desconto)
		float valorTotal = computador.getPreco()-venda.getDesconto();
		System.out.println("Valor total: " + valorTotal);
		venda.setValorTotal(valorTotal);

		int confirma = Teclado.getInt("Confirmar Cadastro?(0->sim / 1->nao)");

		if(confirma == 0){
			try{
				VendaDAO vendaDAO = new VendaDAO();
				vendaDAO.adiciona(venda);
			}catch (SQLException e){
				System.out.println("Erro ao acessar banco de dados! "+e.toString());
				Menus.menuPrincipal();
			}
			System.out.println("Dados Inseridos No Banco!");
			Teclado.pause();
			Menus.menuPrincipal();
		} else {
			Menus.menuPrincipal();
		}

	}

	//tela de consulta de vendas por codigo do vendedor
	public static void menuConsultarVendaPorVendedor() {

		Menus.desenhaLinha();
		long registroVendedor = Teclado.getLong("Codigo do Vendedor");
		List<String> vendas = null;
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendas = vendaDAO.getVendasPorVendedor(registroVendedor);
		}catch(SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}

		System.out.println("=============================================================");
		System.out.println("Quantidade de Vendas: " + (vendas.size()-1));
		System.out.println(vendas.get(vendas.size()-1));
		System.out.println("=============================================================\n");
		
		for (int i = 0; i < vendas.size()-1; i++){
			
			System.out.println(vendas.get(i));
		}

		Teclado.pause();
		Menus.menuPrincipal();
	}


	//tela de consulta de vendas por codigo
	public static void menuConsultarVendaPorCodigoVenda() {

		Menus.desenhaLinha();
		long id = Teclado.getLong("Codigo da venda");
		List<String> vendas = null;
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendas = vendaDAO.getVenda(id);
		}catch(SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}

		for (int i = 0; i < vendas.size()-1; i++){
					
			System.out.println(vendas.get(i));
		}
		
		Teclado.pause();
		Menus.menuPrincipal();

	}

	//tela de consulta de vendas por data
	public static void menuConsultarVendaPorData() {

		Menus.desenhaLinha();
		String data = Teclado.getString("Data");
		List<String> vendas = null;
		try{
			VendaDAO vendaDAO = new VendaDAO();
			vendas = vendaDAO.getVendasPorData(data);
		}catch(SQLException e){
			System.out.println("Erro ao acessar banco de dados! "+e.toString());
			Menus.menuPrincipal();
		}
		System.out.println("=============================================================");
		System.out.println("Quantidade de Vendas: " + (vendas.size()-1));
		System.out.println(vendas.get(vendas.size()-1));
		System.out.println("=============================================================\n");

		/*float valorTotal = 0f;
		for(Object venda: vendas){
			valorTotal += ((Venda) venda).getValorTotal();
		}*/
		for (int i = 0; i< vendas.size()-1; i++){
			
			System.out.println(vendas.get(i));
		}
		Teclado.pause();
		Menus.menuPrincipal();
	}

	/* ################################ FIM - VENDAS ################################ */

}