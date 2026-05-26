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

        if (nome.isEmpty() || nomeSocial.isEmpty()) {
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
                Cliente cliente = new Cliente(nome, nomeSocial);
                clienteDAO.salvar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso.");
            } else {
                Cliente cliente = new Cliente(Integer.parseInt(idTexto), nome, nomeSocial);
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
        }
    }
}