
package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;
import Modelo.*;

public class TelaCadastroPed extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNomecli;
	private JLabel lblMatFun;
	private JLabel lblPlacaCar;
	private JLabel lblValor;	
	private JButton btnCriar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPed frame = new TelaCadastroPed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroPed() {
		setTitle("Cadastrar Pedido");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		textField = new JTextField();
		textField.setBounds(120, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNomecli = new JLabel("Nome do cliente");
		lblNomecli.setBounds(10, 14, 100, 14);
		contentPane.add(lblNomecli);

		lblMatFun = new JLabel("Matricula do funcionário");
		lblMatFun.setBounds(10, 52, 110, 14);
		contentPane.add(lblMatFun);

		lblPlacaCar = new JLabel("Placa do carro");
		lblPlacaCar.setBounds(10, 83, 100, 14);
		contentPane.add(lblPlacaCar);
		
		lblValor = new JLabel("Valor do pedido");
		lblValor.setBounds(10, 115, 100, 14);
		contentPane.add(lblValor);

		textField_1 = new JTextField();
		textField_1.setBounds(120, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(120, 80, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 115, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					int mat = Integer.parseInt(textField_1.getText());
					String placa = textField_2.getText();
					Double valor =Double.parseDouble(textField_3.getText());
					
					Pedido p = Sistema.cadastrarPedido(nome, mat, placa,valor);
					JOptionPane.showMessageDialog(null,"cadastrado ");
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(50, 150, 115, 23);
		contentPane.add(btnCriar);
	}

}

