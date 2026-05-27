package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import model.Cliente;
import view.TelaFClienteFicha;

public class ClienteController {

    private TelaFClienteFicha tela;
    private ClienteDAO clienteDAO;

    public ClienteController(TelaFClienteFicha tela) {
        this.tela = tela;
        this.clienteDAO = new ClienteDAO();
    }

    public void salvar() {
        String nome = tela.getNome().getText().trim();
        String nomeSocial = tela.getNomeSocial().getText().trim();
        String cpf = tela.getCpf().getText().trim();
        String dataNascimento = tela.getDataNascimento().getText().trim();
        String afrodescendente = tela.getAfrodescendente().getText().trim();
        String escolaridadePublica = tela.getEscolaridadePublica().getText().trim();
        String localNascimento = tela.getLocalNascimento().getText().trim();
        String nacionalidade = tela.getNacionalidade().getText().trim();
        String paisOrigem = tela.getPaisOrigem().getText().trim();
        String filiacao1 = tela.getFiliacao1().getText().trim();
        String filiacao2 = tela.getFiliacao2().getText().trim();
        String responsavelLegal = tela.getResponsavelLegal().getText().trim();
        String grauParentesco = tela.getParentesco().getText().trim();
        String habilitacao = tela.getHabilitacao().getText().trim();
        String serieModulo = tela.getSerie().getText().trim();
        String periodo = tela.getPeriodo().getText().trim();
        String ruaAvenida = tela.getRua().getText().trim();
        String complemento = tela.getComplemento().getText().trim();
        String apto = tela.getApto().getText().trim();
        String bloco = tela.getBloco().getText().trim();
        String bairro = tela.getBairro().getText().trim();
        String cidade = tela.getCidade().getText().trim();
        String cep = tela.getCep().getText().trim();
        String telefone = tela.getTelefone().getText().trim();
        String celular = tela.getCelular().getText().trim();
        String email = tela.getEmail().getText().trim();

        if (nome.isEmpty()
        		|| nomeSocial.isEmpty()
                || cpf.isEmpty()
                || dataNascimento.isEmpty()
                || afrodescendente.isEmpty()
                || escolaridadePublica.isEmpty()
                || localNascimento.isEmpty()
                || nacionalidade.isEmpty()
                || paisOrigem.isEmpty()
                || filiacao1.isEmpty()
                || filiacao2.isEmpty()
                || responsavelLegal.isEmpty()
                || grauParentesco.isEmpty()
                || habilitacao.isEmpty()
                || serieModulo.isEmpty()
                || periodo.isEmpty()
                || ruaAvenida.isEmpty()
                || complemento.isEmpty()
                || apto.isEmpty()
                || bloco.isEmpty()
                || bairro.isEmpty()
                || cidade.isEmpty()
                || cep.isEmpty()
                || telefone.isEmpty()
                || celular.isEmpty()
                || email.isEmpty()) {
            JOptionPane.showMessageDialog(
                tela,
                "Preencha os campos.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        try {
            String idTexto = tela.getId().getText().trim();

            if (idTexto.isEmpty()) {
                Cliente cliente = new Cliente(nome,
                        nomeSocial,
                        cpf,
                        dataNascimento,
                        afrodescendente,
                        escolaridadePublica,
                        localNascimento,
                        nacionalidade,
                        paisOrigem,
                        filiacao1,
                        filiacao2,
                        responsavelLegal,
                        grauParentesco,
                        habilitacao,
                        serieModulo,
                        periodo,
                        ruaAvenida,
                        complemento,
                        apto,
                        bloco,
                        bairro,
                        cidade,
                        cep,
                        telefone,
                        celular,
                        email);
                clienteDAO.salvar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso.");
            } else {
                Cliente cliente = new Cliente(Integer.parseInt(idTexto), nome,
                        nomeSocial,
                        cpf,
                        dataNascimento,
                        afrodescendente,
                        escolaridadePublica,
                        localNascimento,
                        nacionalidade,
                        paisOrigem,
                        filiacao1,
                        filiacao2,
                        responsavelLegal,
                        grauParentesco,
                        habilitacao,
                        serieModulo,
                        periodo,
                        ruaAvenida,
                        complemento,
                        apto,
                        bloco,
                        bairro,
                        cidade,
                        cep,
                        telefone,
                        celular,
                        email);
                clienteDAO.atualizar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso.");
            }

            limpar();
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao salvar: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void excluir() {
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(
                tela,
                "Selecione um cliente na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o cliente selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getId().getText());
            clienteDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Cliente excluído com sucesso.");
            limpar();
            carregarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void limpar() {
    	tela.getId().setText("");
        tela.getNome().setText("");
        tela.getNomeSocial().setText("");
        tela.getCpf().setText("");
        tela.getDataNascimento().setText("");
        tela.getAfrodescendente().setText("");
        tela.getEscolaridadePublica().setText("");
        tela.getLocalNascimento().setText("");
        tela.getNacionalidade().setText("");
        tela.getPaisOrigem().setText("");
        tela.getFiliacao1().setText("");
        tela.getFiliacao2().setText("");
        tela.getResponsavelLegal().setText("");
        tela.getParentesco().setText("");
        tela.getHabilitacao().setText("");
        tela.getSerie().setText("");
        tela.getPeriodo().setText("");
        tela.getRua().setText("");
        tela.getComplemento().setText("");
        tela.getApto().setText("");
        tela.getBloco().setText("");
        tela.getBairro().setText("");
        tela.getCidade().setText("");
        tela.getCep().setText("");
        tela.getTelefone().setText("");
        tela.getCelular().setText("");
        tela.getEmail().setText("");
        
        tela.getNome().requestFocus();
        tela.getTabelaClientes().clearSelection();
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaClientes().getModel();
        modelo.setRowCount(0);

        try {
            List<Cliente> clientes = clienteDAO.listar();

            int i;
            for (i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                modelo.addRow(new Object[] {
                        c.getId(),
                        c.getNome(),
                        c.getNomeSocial(),
                        c.getCpf(),
                        c.getDataNascimento(),
                        c.getAfrodescendente(),
                        c.getEscolaridadePublica(),
                        c.getLocalNascimento(),
                        c.getNacionalidade(),
                        c.getPaisOrigem(),
                        c.getFiliacao1(),
                        c.getFiliacao2(),
                        c.getResponsavelLegal(),
                        c.getGrauParentesco(),
                        c.getHabilitacao(),
                        c.getSerieModulo(),
                        c.getPeriodo(),
                        c.getRuaAvenida(),
                        c.getComplemento(),
                        c.getApto(),
                        c.getBloco(),
                        c.getBairro(),
                        c.getCidade(),
                        c.getCep(),
                        c.getTelefone(),
                        c.getCelular(),
                        c.getEmail()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void preencherFormulario() {
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha != -1) {
            tela.getId().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getNome().setText(tela.getTabelaClientes().getValueAt(linha, 1).toString());
            tela.getNomeSocial().setText(tela.getTabelaClientes().getValueAt(linha, 2).toString());
            tela.getCpf().setText(tela.getTabelaClientes().getValueAt(linha, 3).toString());
            tela.getDataNascimento().setText(tela.getTabelaClientes().getValueAt(linha, 4).toString());
            tela.getAfrodescendente().setText(tela.getTabelaClientes().getValueAt(linha, 5).toString());
            tela.getEscolaridadePublica().setText(tela.getTabelaClientes().getValueAt(linha, 6).toString());
            tela.getLocalNascimento().setText(tela.getTabelaClientes().getValueAt(linha, 7).toString());
            tela.getNacionalidade().setText(tela.getTabelaClientes().getValueAt(linha, 8).toString());
            tela.getPaisOrigem().setText(tela.getTabelaClientes().getValueAt(linha, 9).toString());
            tela.getFiliacao1().setText(tela.getTabelaClientes().getValueAt(linha, 10).toString());
            tela.getFiliacao2().setText(tela.getTabelaClientes().getValueAt(linha, 11).toString());
            tela.getResponsavelLegal().setText(tela.getTabelaClientes().getValueAt(linha, 12).toString());
            tela.getParentesco().setText(tela.getTabelaClientes().getValueAt(linha, 13).toString());
            tela.getHabilitacao().setText(tela.getTabelaClientes().getValueAt(linha, 14).toString());
            tela.getSerie().setText(tela.getTabelaClientes().getValueAt(linha, 15).toString());
            tela.getPeriodo().setText(tela.getTabelaClientes().getValueAt(linha, 16).toString());
            tela.getRua().setText(tela.getTabelaClientes().getValueAt(linha, 17).toString());
            tela.getComplemento().setText(tela.getTabelaClientes().getValueAt(linha, 18).toString());
            tela.getApto().setText(tela.getTabelaClientes().getValueAt(linha, 19).toString());
            tela.getBloco().setText(tela.getTabelaClientes().getValueAt(linha, 20).toString());
            tela.getBairro().setText(tela.getTabelaClientes().getValueAt(linha, 21).toString());
            tela.getCidade().setText(tela.getTabelaClientes().getValueAt(linha, 22).toString());
            tela.getCep().setText(tela.getTabelaClientes().getValueAt(linha, 23).toString());
            tela.getTelefone().setText(tela.getTabelaClientes().getValueAt(linha, 24).toString());
            tela.getCelular().setText(tela.getTabelaClientes().getValueAt(linha, 25).toString());
            tela.getEmail().setText(tela.getTabelaClientes().getValueAt(linha, 26).toString());
        }
    }
}