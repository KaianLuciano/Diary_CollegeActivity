package Program;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entitites.Contato;

public class AgendaDeContatos {

	private JFrame frmAgendaDeContatos;
	private JTextField jtsNome;
	private JTextField jtsNumero;
	private JTextField jtsEmail;
	private JTable table_1;
	private List<Contato> contatos = new ArrayList<>();
	
	public List<Contato> getContatos() {
		return contatos;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaDeContatos window = new AgendaDeContatos();
					window.frmAgendaDeContatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgendaDeContatos() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeContatos = new JFrame();
		frmAgendaDeContatos.setResizable(false);
		frmAgendaDeContatos.setTitle("Agenda De Contatos");
		frmAgendaDeContatos.setBounds(100, 100, 714, 504);
		frmAgendaDeContatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaDeContatos.getContentPane().setLayout(null);
		frmAgendaDeContatos.setLocationRelativeTo(null);
		
		JPanel jpnBotoes = new JPanel();
		jpnBotoes.setBounds(10, 11, 679, 66);
		frmAgendaDeContatos.getContentPane().add(jpnBotoes);
		jpnBotoes.setLayout(null);
		
		JButton jbAtualizar = new JButton("Atualizar");
		
		JButton jbNovo = new JButton("Novo");
		jbNovo.setBounds(10, 5, 120, 33);
		
		jbNovo.setMnemonic('N');
		jbNovo.setIcon(new ImageIcon(AgendaDeContatos.class.getResource("/img/novo.png")));
		jpnBotoes.add(jbNovo);
		
		JButton jbAlterar = new JButton("Alterar");
		jbAlterar.setBounds(140, 5, 120, 33);

		jbAlterar.setMnemonic('A');
		jbAlterar.setIcon(new ImageIcon(AgendaDeContatos.class.getResource("/img/modificar.png")));
		jpnBotoes.add(jbAlterar);
		
		JButton jbExcluir = new JButton("Excluir");
		jbExcluir.setBounds(275, 5, 120, 33);
		jbExcluir.setMnemonic('E');
		jbExcluir.setIcon(new ImageIcon(AgendaDeContatos.class.getResource("/img/deletar.png")));
		
		jpnBotoes.add(jbExcluir);
		
		JButton jbSalvar = new JButton("Salvar");
		jbSalvar.setBounds(410, 5, 120, 33);
		jbSalvar.setMnemonic('S');
		jbSalvar.setIcon(new ImageIcon(AgendaDeContatos.class.getResource("/img/salvar.png")));
		jpnBotoes.add(jbSalvar);
		
		JButton jbCancelar = new JButton("Cancelar");
		jbCancelar.setBounds(545, 5, 120, 33);
		
		jbCancelar.setMnemonic('C');
		jbCancelar.setIcon(new ImageIcon(AgendaDeContatos.class.getResource("/img/cancelar.png")));
		jpnBotoes.add(jbCancelar);
		
		JPanel jpnFormulario = new JPanel();
		jpnFormulario.setBounds(10, 88, 679, 71);
		frmAgendaDeContatos.getContentPane().add(jpnFormulario);
		jpnFormulario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome ");
		lblNewLabel.setBounds(20, 11, 46, 14);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jpnFormulario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número (XX) XXXXX-XXXX");
		lblNewLabel_1.setBounds(260, 11, 162, 14);
		jpnFormulario.add(lblNewLabel_1);
		
		jtsNome = new JTextField();
		jtsNome.setBounds(20, 34, 230, 20);
		jpnFormulario.add(jtsNome);
		jtsNome.setColumns(10);
		
		jtsNumero = new JTextField();
		jtsNumero.setBounds(260, 34, 162, 20);
		jpnFormulario.add(jtsNumero);
		jtsNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(432, 11, 46, 14);
		jpnFormulario.add(lblNewLabel_2);
		
		jtsEmail = new JTextField();
		jtsEmail.setBounds(432, 34, 230, 20);
		jpnFormulario.add(jtsEmail);
		jtsEmail.setColumns(10);
		
		JPanel jpnConsulta = new JPanel();
		jpnConsulta.setBackground(Color.WHITE);
		jpnConsulta.setBounds(10, 170, 679, 279);
		frmAgendaDeContatos.getContentPane().add(jpnConsulta);
		jpnConsulta.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Lista De Contatos");
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(282, 39, 124, 14);
		jpnConsulta.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 61, 609, 190);
		jpnConsulta.add(scrollPane);
		
		Object[][] data = {};
		String[] columnNames = {"Nome", "Email", "N\u00FAmero"};
		
		DefaultTableModel model = new DefaultTableModel(data,columnNames){
            /**
		*
		*/
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int linha, int coluna) {  
                return false;
            }  
        };
		
		table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
		table_1.getTableHeader().setReorderingAllowed(false);	
		
		JButton jbApagar = new JButton("Apagar Contato");
		jbApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRowCount() == 1) {
					model.removeRow(table_1.getSelectedRow());
					jbNovo.setEnabled(true);
					jbAlterar.setEnabled(true);
					jbExcluir.setEnabled(true);
					jbSalvar.setEnabled(false);
					jbCancelar.setEnabled(false);
					jtsNome.setEnabled(false);
					jtsEmail.setEnabled(false);
					jtsNumero.setEnabled(false);
					jbApagar.setEnabled(false);
					jtsNome.setEnabled(false);
					jtsEmail.setEnabled(false);
					jtsNumero.setEnabled(false);
					jbApagar.setEnabled(false);
					jbAtualizar.setEnabled(false);
					jtsNome.setText("");
					jtsEmail.setText("");
					jtsNumero.setText("");
					JOptionPane.showMessageDialog(null, "Contato Excluido!");
				} else {
					if(table_1.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Tabela Vazia!");
					} else {
						JOptionPane.showMessageDialog(null, "Porfavor, selecionar a linha do contato que deseja apagar!");
					}
				}
			}
		});
		jbApagar.setBounds(34, 35, 124, 23);
		jpnConsulta.add(jbApagar);
		/*table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nome", "Email", "N\u00FAmero"
			}
		));*/
		
		jbSalvar.setEnabled(false);
		jbCancelar.setEnabled(false);
		jtsNome.setEnabled(false);
		jtsEmail.setEnabled(false);
		jtsNumero.setEnabled(false);
		jbApagar.setEnabled(false);
		jtsNome.setEnabled(false);
		jtsEmail.setEnabled(false);
		jtsNumero.setEnabled(false);
		jbApagar.setEnabled(false);
		jbAtualizar.setEnabled(false);
		
		jbAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRowCount() == 1) {
					model.setValueAt(jtsNome.getText(), table_1.getSelectedRow(), 0);
					model.setValueAt(jtsEmail.getText(), table_1.getSelectedRow(), 1);
					model.setValueAt(jtsNumero.getText(), table_1.getSelectedRow(), 2);					
					jbNovo.setEnabled(true);
					jbAlterar.setEnabled(true);
					jbExcluir.setEnabled(true);
					jbSalvar.setEnabled(false);
					jbCancelar.setEnabled(false);
					jtsNome.setEnabled(false);
					jtsEmail.setEnabled(false);
					jtsNumero.setEnabled(false);
					jbApagar.setEnabled(false);
					jtsNome.setEnabled(false);
					jtsEmail.setEnabled(false);
					jtsNumero.setEnabled(false);
					jbApagar.setEnabled(false);
					jbAtualizar.setEnabled(false);
					jtsNome.setText("");
					jtsEmail.setText("");
					jtsNumero.setText("");
					JOptionPane.showMessageDialog(null, "Contato Atualizado!");
		
				} else {
					if(table_1.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Tabela Vazia");
					} else {
						JOptionPane.showMessageDialog(null, "Porfavor, selecionar a linha do contato que deseja atualizar!");
					}
				}
			}
		});
		jbAtualizar.setBounds(554, 35, 89, 23);
		jpnConsulta.add(jbAtualizar);
		
		jbNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbNovo.setEnabled(false);
				jbAlterar.setEnabled(false);
				jbExcluir.setEnabled(false);
				jbSalvar.setEnabled(true);
				jbCancelar.setEnabled(true);
				jtsNome.setEnabled(true);
				jtsEmail.setEnabled(true);
				jtsNumero.setEnabled(true);
			}
		});
		
		jbAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbNovo.setEnabled(false);
				jbAlterar.setEnabled(false);
				jbExcluir.setEnabled(false);
				jbSalvar.setEnabled(false);
				jbCancelar.setEnabled(true);
				jbApagar.setEnabled(false);
				jtsNome.setEnabled(true);
				jtsEmail.setEnabled(true);
				jtsNumero.setEnabled(true);
				jbAtualizar.setEnabled(true);
				jtsNome.setText("");
				jtsEmail.setText("");
				jtsNumero.setText("");
				
				//JOptionPane.showMessageDialog(null, "Selecione a linha que deseja alterar,\n em seguida digite os novos dados.");
			}
		});
		
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbNovo.setEnabled(true);
				jbAlterar.setEnabled(true);
				jbExcluir.setEnabled(true);
				jbSalvar.setEnabled(false);
				jbCancelar.setEnabled(false);
				jtsNome.setEnabled(false);
				jtsEmail.setEnabled(false);
				jtsNumero.setEnabled(false);
				jbApagar.setEnabled(false);
								
				if(verificarTamanhoNumero(jtsNumero.getText())) {
					JOptionPane.showMessageDialog(null, "Número inserido não segue o padrão permitido de 11 números (DD) XXXXX-XXXX", "Formato Invalido", JOptionPane.ERROR_MESSAGE);
					jtsNome.setText("");
					jtsEmail.setText("");
					jtsNumero.setText("");
					return;
				}
				if(!verificarSomenteNumero(jtsNumero.getText())) {
					JOptionPane.showMessageDialog(null, "Número inserido não segue o padrão permitido de 11 números (DD) XXXXX-XXXX", "Formato Invalido", JOptionPane.ERROR_MESSAGE);
					jtsNome.setText("");
					jtsEmail.setText("");
					jtsNumero.setText("");
					return;
				}

				
				contatos.add(new Contato(jtsNome.getText(), jtsEmail.getText(), Long.parseLong(jtsNumero.getText())));
				
				Object[] newRow= {jtsNome.getText(), jtsEmail.getText(), Long.parseLong(jtsNumero.getText())};
				model.addRow(newRow);;	
				jtsNome.setText("");
				jtsEmail.setText("");
				jtsNumero.setText("");
				JOptionPane.showMessageDialog(null, "Contato Inserido!");
			}
		});
		
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbNovo.setEnabled(false);
				jbAlterar.setEnabled(false);
				jbExcluir.setEnabled(false);
				jbSalvar.setEnabled(false);
				jbCancelar.setEnabled(true);
				jtsNome.setEnabled(false);
				jtsEmail.setEnabled(false);
				jtsNumero.setEnabled(false);
				jbApagar.setEnabled(true);
				jbAtualizar.setEnabled(false);
			}
		});
		
		
		jbCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbNovo.setEnabled(true);
				jbAlterar.setEnabled(true);
				jbExcluir.setEnabled(true);
				jbSalvar.setEnabled(false);
				jbCancelar.setEnabled(false);
				jtsNome.setEnabled(false);
				jtsEmail.setEnabled(false);
				jtsNumero.setEnabled(false);
				jbApagar.setEnabled(false);
				jtsNome.setText("");
				jtsEmail.setText("");
				jtsNumero.setText("");
			}
		});
		
	}

	private boolean verificarTamanhoNumero(String numero) {
		if (numero.length() > 11 || numero.length() < 11){
		      return true;
		}else{
		      return false;
		}		
	}
	
	private boolean verificarSomenteNumero(String numero) {
		return numero.matches("[0-9]+");
	}
}
