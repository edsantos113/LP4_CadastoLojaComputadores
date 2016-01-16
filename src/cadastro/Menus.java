package cadastro;

/**
 * 
 * @author Amanda
 *
 */
public class Menus {

	//desenha linha divisoria para organizar o visual
	static void desenhaLinha() {
		System.out.println("=============================================================");
	}

	//menu principal
	public static void menuPrincipal() {

		desenhaLinha();
		System.out.println("SISTEMA DE CADASTRO DE VENDAS");
		desenhaLinha();
		System.out.println("1. Cadastrar Produto ");
		System.out.println("2. Excluir Produto");
		System.out.println("3. Editar Produto");
		desenhaLinha();
		System.out.println("4. Cadastrar Vendedor ");
		System.out.println("5. Excluir Vendedor");
		System.out.println("6. Editar Vendedor");
		desenhaLinha();
		System.out.println("7. Realizar Venda");
		System.out.println("8. Consultar Vendas");
		System.out.println("9. Sair");
		desenhaLinha();

		int op = Teclado.getInt("Opcao");

		switch (op){
		case 1:
			OpcoesMenu.menuCadastrarProduto();
			break;
		case 2:
			OpcoesMenu.menuExcluirProduto();
			break;
		case 3:
			OpcoesMenu.menuEditarProduto();
			break;
		case 4:
			OpcoesMenu.menuCadastrarVendedor();
			break;
		case 5:
			OpcoesMenu.menuExcluirVendedor();
			break;
		case 6:
			OpcoesMenu.menuEditarVendedor();
			break;
		case 7:
			OpcoesMenu.menuRealizarVenda();
			break;
		case 8:
			menuConsultarVendas();
			break;
		case 9:
			System.exit(0);
			break;
		default:
			System.out.println("Opcao Invalida!");
			menuPrincipal();
			break;
		}
	}

	//tela de menu de consultas de vendas
	private static void menuConsultarVendas() {

		desenhaLinha();
		System.out.println(" CONSULTA DE VENDAS");
		desenhaLinha();
		System.out.println("1. Consultar Por Vendedor");
		System.out.println("2. Consultar Por Codigo da Venda");
		System.out.println("3. Consultar Por Data");
		System.out.println("4. Menu Principal");
		desenhaLinha();	    


		int op = Teclado.getInt("Opcao");

		switch (op){
		case 1:
			OpcoesMenu.menuConsultarVendaPorVendedor();
			break;
		case 2:
			OpcoesMenu.menuConsultarVendaPorCodigoVenda();
			break;
		case 3:
			OpcoesMenu.menuConsultarVendaPorData();
			break;
		case 4:
			menuPrincipal();
			break;
		default:
			System.out.println("Opcao Invalida!");
			menuConsultarVendas();
			break;
		}		
	}
}
