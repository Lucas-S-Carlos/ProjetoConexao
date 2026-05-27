package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaFClienteFicha extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblId;
	private JLabel lblNome;
    private JLabel lblNomeSocial;
    private JLabel lblCpf;
    private JLabel lblDataNascimento;
    private JLabel lblAfrodescendente;
    
    private JLabel lblEscolaridadePublica;
    private JLabel lblLocalNascimento;
    private JLabel lblNacionalidade;
    private JLabel lblPaisOrigem;
    
    private JLabel lblFiliacao1;
    
    private JLabel lblFiliacao2;
    
    private JLabel lblResponsavelLegal;
    
    private JLabel lblGrauParentesco;
    
    private JLabel lblHabilitacao;
    
    private JLabel lblSerie;
    
    private JLabel lblPeriodo;
    

    private JLabel lblRua;
    
    private JLabel lblComplemento;
    
    private JLabel lblApto;
    
    private JLabel lblBloco;
    
    private JLabel lblBairro;
    
    private JLabel lblCidade;
    
    private JLabel lblCep;
    
    private JLabel lblTelefone;
    
    private JLabel lblCelular;
    
    private JLabel lblEmail;
    
    
    
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtNomeSocial;
    private JTextField txtCpf;
    private JTextField txtDataNascimento;
    private JTextField txtAfrodescendente;
    private JTextField txtEscolaridadePublica;
    private JTextField txtLocalNascimento;
    private JTextField txtNacionalidade;
    private JTextField txtPaisOrigem;
    private JTextField txtFiliacao1;
    private JTextField txtFiliacao2;
    private JTextField txtResponsavelLegal;
    private JTextField txtGrauParentesco;
    private JTextField txtHabilitacao;
    private JTextField txtSerie;
    private JTextField txtPeriodo;

    private JTextField txtRua;
    private JTextField txtComplemento;
    private JTextField txtApto;
    private JTextField txtBloco;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtCep;
    private JTextField txtTelefone;
    private JTextField txtCelular;
    private JTextField txtEmail;

    private JTable tabelaFicha;
    private DefaultTableModel modeloTabela;

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    

    private ClienteController controller;
    

    public TelaFClienteFicha() {
        setTitle("Ficha de Matrícula");
        setSize(1200, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout( ));

        criarComponentes();
        
        controller = new ClienteController(this);
        configurarEventos();
        controller.carregarTabela();
    }

    private void criarComponentes() {
        JPanel painelFormulario = new JPanel(new GridLayout(0, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Ficha dos Alunos"));

        lblId = new JLabel("ID:");
        txtId = new JTextField();
        txtId.setEditable(false);
        
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        lblNomeSocial = new JLabel("Nome Social:");
        txtNomeSocial = new JTextField();

        lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField();

        lblDataNascimento = new JLabel("Data de Nascimento:");
        txtDataNascimento = new JTextField();

        lblAfrodescendente = new JLabel("Afrodescendente:");
        txtAfrodescendente = new JTextField();

        lblEscolaridadePublica = new JLabel("Escolaridade Pública:");
        txtEscolaridadePublica = new JTextField();

        lblLocalNascimento = new JLabel("Local de Nascimento:");
        txtLocalNascimento = new JTextField();

        lblNacionalidade = new JLabel("Nacionalidade:");
        txtNacionalidade = new JTextField();

        lblPaisOrigem = new JLabel("País de Origem:");
        txtPaisOrigem = new JTextField();

        lblFiliacao1 = new JLabel("Filiação 1:");
        txtFiliacao1 = new JTextField();

        lblFiliacao2 = new JLabel("Filiação 2:");
        txtFiliacao2 = new JTextField();

        lblResponsavelLegal = new JLabel("Responsável Legal:");
        txtResponsavelLegal = new JTextField();

        lblGrauParentesco = new JLabel("Grau de Parentesco:");
        txtGrauParentesco = new JTextField();

        lblHabilitacao = new JLabel("Habilitação:");
        txtHabilitacao = new JTextField();

        lblSerie = new JLabel("Série / Módulo:");
        txtSerie = new JTextField();

        lblPeriodo = new JLabel("Período:");
        txtPeriodo = new JTextField();

        lblRua = new JLabel("Rua / Avenida:");
        txtRua = new JTextField();

        lblComplemento = new JLabel("Complemento:");
        txtComplemento = new JTextField();

        lblApto = new JLabel("Apto:");
        txtApto = new JTextField();

        lblBloco = new JLabel("Bloco:");
        txtBloco = new JTextField();

        lblBairro = new JLabel("Bairro:");
        txtBairro = new JTextField();

        lblCidade = new JLabel("Cidade:");
        txtCidade = new JTextField();

        lblCep = new JLabel("CEP:");
        txtCep = new JTextField();

        lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();

        lblCelular = new JLabel("Celular:");
        txtCelular = new JTextField();

        lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField();
        
        

        painelFormulario.add(lblId);
        painelFormulario.add(txtId);
        
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);

        painelFormulario.add(lblNomeSocial);
        painelFormulario.add(txtNomeSocial);

        painelFormulario.add(lblCpf);
        painelFormulario.add(txtCpf);

        painelFormulario.add(lblDataNascimento);
        painelFormulario.add(txtDataNascimento);

        painelFormulario.add(lblAfrodescendente);
        painelFormulario.add(txtAfrodescendente);

        painelFormulario.add(lblEscolaridadePublica);
        painelFormulario.add(txtEscolaridadePublica);

        painelFormulario.add(lblLocalNascimento);
        painelFormulario.add(txtLocalNascimento);

        painelFormulario.add(lblNacionalidade);
        painelFormulario.add(txtNacionalidade);

        painelFormulario.add(lblPaisOrigem);
        painelFormulario.add(txtPaisOrigem);

        painelFormulario.add(lblFiliacao1);
        painelFormulario.add(txtFiliacao1);

        painelFormulario.add(lblFiliacao2);
        painelFormulario.add(txtFiliacao2);

        painelFormulario.add(lblResponsavelLegal);
        painelFormulario.add(txtResponsavelLegal);

        painelFormulario.add(lblGrauParentesco);
        painelFormulario.add(txtGrauParentesco);

        painelFormulario.add(lblHabilitacao);
        painelFormulario.add(txtHabilitacao);

        painelFormulario.add(lblSerie);
        painelFormulario.add(txtSerie);

        painelFormulario.add(lblPeriodo);
        painelFormulario.add(txtPeriodo);

        painelFormulario.add(lblRua);
        painelFormulario.add(txtRua);

        painelFormulario.add(lblComplemento);
        painelFormulario.add(txtComplemento);

        painelFormulario.add(lblApto);
        painelFormulario.add(txtApto);

        painelFormulario.add(lblBloco);
        painelFormulario.add(txtBloco);

        painelFormulario.add(lblBairro);
        painelFormulario.add(txtBairro);

        painelFormulario.add(lblCidade);
        painelFormulario.add(txtCidade);

        painelFormulario.add(lblCep);
        painelFormulario.add(txtCep);

        painelFormulario.add(lblTelefone);
        painelFormulario.add(txtTelefone);

        painelFormulario.add(lblCelular);
        painelFormulario.add(txtCelular);

        painelFormulario.add(lblEmail);
        painelFormulario.add(txtEmail);

        add(painelFormulario, BorderLayout.EAST);

        modeloTabela = new DefaultTableModel(
            new Object[] {
                "Id", "Nome", "Nome Social", "CPF",  "Nascimento", "Afrodescendente",
                "Escolaridade", "Local Nasc.", "Nacionalidade", "País Origem",
                "Filiação 1", "Filiação 2", "Resp. Legal", "Parentesco",
                "Habilitação", "Série", "Período", "Rua", "Complemento",
                "Apto", "Bloco", "Bairro", "Cidade", "CEP",
                "Telefone", "Celular", "Email"
            }, 0
        ) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaFicha = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaFicha);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Alunos"));
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
    }
    
    private void configurarEventos() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.salvar();
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.excluir();
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        tabelaFicha.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.preencherFormulario();
            }
        });
    }

    public JTextField getId() {
        return txtId;
    }

    public JTextField getNome() {
        return txtNome;
    }
    public JTextField getNomeSocial() {
        return txtNomeSocial;
    }
    public JTextField getCpf() {
        return txtCpf;
    }
    public JTextField getDataNascimento() {
        return txtDataNascimento;
    }
    public JTextField getAfrodescendente() {
        return txtAfrodescendente;
    }
    public JTextField getEscolaridadePublica() {
        return txtEscolaridadePublica;
    }
    public JTextField getLocalNascimento() {
        return txtLocalNascimento;
    }
    public JTextField getNacionalidade() {
        return txtNacionalidade;
    }
    public JTextField getPaisOrigem() {
        return txtPaisOrigem;
    }
    public JTextField getFiliacao1() {
        return txtFiliacao1;
    }

    public JTextField getFiliacao2() {
        return txtFiliacao2;
    }

    public JTextField getResponsavelLegal() {
        return txtResponsavelLegal;
    }

    public JTextField getParentesco() {
        return txtGrauParentesco;
    }

    public JTextField getHabilitacao() {
        return txtHabilitacao;
    }

    public JTextField getSerie() {
        return txtSerie;
    }

    public JTextField getPeriodo() {
        return txtPeriodo;
    }

    public JTextField getRua() {
        return txtRua;
    }

    public JTextField getComplemento() {
        return txtComplemento;
    }

    public JTextField getApto() {
        return txtApto;
    }

    public JTextField getBloco() {
        return txtBloco;
    }

    public JTextField getBairro() {
        return txtBairro;
    }

    public JTextField getCidade() {
        return txtCidade;
    }

    public JTextField getCep() {
        return txtCep;
    }

    public JTextField getTelefone() {
        return txtTelefone;
    }

    public JTextField getCelular() {
        return txtCelular;
    }

    public JTextField getEmail() {
        return txtEmail;
    }
   


  public JTable getTabelaClientes() {
      return tabelaFicha;
  } 
}

