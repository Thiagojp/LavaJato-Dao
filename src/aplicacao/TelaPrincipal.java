package aplicacao;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Sistema;

public class TelaPrincipal {
	
	

	private JFrame frmPrincipal;
	private JMenuItem mntmCadastrarCli;
	private JMenuItem mntmCadastrarCar;
	private JMenuItem mntmCadastrarFun;
	private JMenuItem mntmCadastrarPed;
	private JMenuItem mntmListarCli;
	private JMenuItem mntmListarCar;
	private JMenuItem mntmListarFun;
	private JMenuItem mntmListarPed;
	private JMenuItem mntmListar;
	private JMenuItem mntmListarCons2;	
	private JMenu mnCadastrar;
	private JMenu mnListar;
	private JMenu mnConsultar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Sistema.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frmPrincipal.setTitle("LAVA JATO");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		mnCadastrar = new JMenu("Cadastro ");
		menuBar.add(mnCadastrar);
		
		mntmCadastrarCli = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCliente j = new TelaCadastroCliente();
				j.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarCli);
		
		mntmCadastrarCar = new JMenuItem("Cadastrar Carro");
		mntmCadastrarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCarro j = new TelaCadastroCarro();
				j.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarCar);
		
		mntmCadastrarFun = new JMenuItem("Cadastrar Funcionario");
		mntmCadastrarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroFun j = new TelaCadastroFun();
				j.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarFun);
		
		mntmCadastrarPed = new JMenuItem("Cadastrar Pedido");
		mntmCadastrarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPed j = new TelaCadastroPed();
				j.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarPed);
		
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmListarCli = new JMenuItem("Listar Clientes");
		mntmListarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarCliente j = new TelaListarCliente();
				j.setVisible(true);
			}
		});
		mnListar.add(mntmListarCli);
		
		
		JMenuItem mntmListarCar = new JMenuItem("Listar Carros");
		mntmListarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarCarro j = new TelaListarCarro();
				j.setVisible(true);
			}
		});
		mnListar.add(mntmListarCar);
		
		JMenuItem mntmListarFun = new JMenuItem("Listar Funcionários");
		mntmListarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarFun j = new TelaListarFun();
				j.setVisible(true);
			}
		});
		mnListar.add(mntmListarFun);
		
		JMenuItem mntmListarPed = new JMenuItem("Listar Pedidos");
		mntmListarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPed j = new TelaListarPed();
				j.setVisible(true);
			}
		});
		mnListar.add(mntmListarPed);
		
		JMenu mnConsultar = new JMenu("Consultas");
		menuBar.add(mnConsultar);
		
		JMenuItem mntmListarCons1 = new JMenuItem("Nome dos carros pertencentes ao clientes");
		mntmListarCons1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarConsulta j = new TelaListarConsulta();
				j.setVisible(true);
			}
		});
		mnConsultar.add(mntmListarCons1);
		
		JMenuItem mntmListarCons2 = new JMenuItem("Listar média e total de vendas do funcionário");
		mntmListarCons2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaDadosmat j = new TelaConsultaDadosmat();
				j.setVisible(true);
			}
		});
		mnConsultar.add(mntmListarCons2);
		

//		mnConsultar.add(mnListar);	
//		JMenuItem mntmListar_1 = new JMenuItem("Listar");
//		mntmListar_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				TelaListagemCliente j = new TelaListagemCliente();
//				j.setVisible(true);
//			}
//		});
//		mnPrateleira.add(mntmListar_1);
//		
//		JMenuItem mntmInserirProduto = new JMenuItem("Inserir produto");
//		mntmInserirProduto.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				TelaInserirProduto j = new TelaInserirProduto();
//				j.setVisible(true);
//			}
//		});
//		mnPrateleira.add(mntmInserirProduto);
	}
}
