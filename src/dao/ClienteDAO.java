package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.Conexao;

public class ClienteDAO {

    public void salvar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO cliente ("
                + "nome, "
                + "nomeSocial, "
                + "cpf, "
                + "dataNascimento, "
                + "afrodescendente, "
                + "escolaridadePublica, "
                + "localNascimento, "
                + "nacionalidade, "
                + "paisOrigem, "
                + "filiacao1, "
                + "filiacao2, "
                + "responsavelLegal, "
                + "grauParentesco, "
                + "habilitacao, "
                + "serieModulo, "
                + "periodo, "
                + "ruaAvenida, "
                + "complemento, "
                + "apto, "
                + "bloco, "
                + "bairro, "
                + "cidade, "
                + "cep, "
                + "telefone, "
                + "celular, "
                + "email"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getNomeSocial());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getDataNascimento());
            stmt.setString(5, cliente.getAfrodescendente());
            stmt.setString(6, cliente.getEscolaridadePublica());
            stmt.setString(7, cliente.getLocalNascimento());
            stmt.setString(8, cliente.getNacionalidade());
            stmt.setString(9, cliente.getPaisOrigem());
            stmt.setString(10, cliente.getFiliacao1());
            stmt.setString(11, cliente.getFiliacao2());
            stmt.setString(12, cliente.getResponsavelLegal());
            stmt.setString(13, cliente.getGrauParentesco());
            stmt.setString(14, cliente.getHabilitacao());
            stmt.setString(15, cliente.getSerieModulo());
            stmt.setString(16, cliente.getPeriodo());
            stmt.setString(17, cliente.getRuaAvenida());
            stmt.setString(18, cliente.getComplemento());
            stmt.setString(19, cliente.getApto());
            stmt.setString(20, cliente.getBloco());
            stmt.setString(21, cliente.getBairro());
            stmt.setString(22, cliente.getCidade());
            stmt.setString(23, cliente.getCep());
            stmt.setString(24, cliente.getTelefone());
            stmt.setString(25, cliente.getCelular());
            stmt.setString(26, cliente.getEmail());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao salvar cliente: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar(Cliente cliente) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE cliente SET "
                + "nome = ?, "
                + "nomeSocial = ?, "
                + "cpf = ?, "
                + "dataNascimento = ?, "
                + "afrodescendente = ?, "
                + "escolaridadePublica = ?, "
                + "localNascimento = ?, "
                + "nacionalidade = ?, "
                + "paisOrigem = ?, "
                + "filiacao1 = ?, "
                + "filiacao2 = ?, "
                + "responsavelLegal = ?, "
                + "grauParentesco = ?, "
                + "habilitacao = ?, "
                + "serieModulo = ?, "
                + "periodo = ?, "
                + "ruaAvenida = ?, "
                + "complemento = ?, "
                + "apto = ?, "
                + "bloco = ?, "
                + "bairro = ?, "
                + "cidade = ?, "
                + "cep = ?, "
                + "telefone = ?, "
                + "celular = ?, "
                + "email = ? "
                + "WHERE id = ?";

        try {

            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getNomeSocial());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getDataNascimento());
            stmt.setString(5, cliente.getAfrodescendente());
            stmt.setString(6, cliente.getEscolaridadePublica());
            stmt.setString(7, cliente.getLocalNascimento());
            stmt.setString(8, cliente.getNacionalidade());
            stmt.setString(9, cliente.getPaisOrigem());
            stmt.setString(10, cliente.getFiliacao1());
            stmt.setString(11, cliente.getFiliacao2());
            stmt.setString(12, cliente.getResponsavelLegal());
            stmt.setString(13, cliente.getGrauParentesco());
            stmt.setString(14, cliente.getHabilitacao());
            stmt.setString(15, cliente.getSerieModulo());
            stmt.setString(16, cliente.getPeriodo());
            stmt.setString(17, cliente.getRuaAvenida());
            stmt.setString(18, cliente.getComplemento());
            stmt.setString(19, cliente.getApto());
            stmt.setString(20, cliente.getBloco());
            stmt.setString(21, cliente.getBairro());
            stmt.setString(22, cliente.getCidade());
            stmt.setString(23, cliente.getCep());
            stmt.setString(24, cliente.getTelefone());
            stmt.setString(25, cliente.getCelular());
            stmt.setString(26, cliente.getEmail());

            stmt.setInt(27, cliente.getId());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao atualizar cliente: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void excluir(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM cliente WHERE id = ?";

        try {

            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao excluir cliente: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM cliente ORDER BY id DESC";

        try {

            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNomeSocial(rs.getString("nomeSocial"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getString("dataNascimento"));
                cliente.setAfrodescendente(rs.getString("afrodescendente"));
                cliente.setEscolaridadePublica(rs.getString("escolaridadePublica"));
                cliente.setLocalNascimento(rs.getString("localNascimento"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setPaisOrigem(rs.getString("paisOrigem"));
                cliente.setFiliacao1(rs.getString("filiacao1"));
                cliente.setFiliacao2(rs.getString("filiacao2"));
                cliente.setResponsavelLegal(rs.getString("responsavelLegal"));
                cliente.setGrauParentesco(rs.getString("grauParentesco"));
                cliente.setHabilitacao(rs.getString("habilitacao"));
                cliente.setSerieModulo(rs.getString("serieModulo"));
                cliente.setPeriodo(rs.getString("periodo"));
                cliente.setRuaAvenida(rs.getString("ruaAvenida"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setApto(rs.getString("apto"));
                cliente.setBloco(rs.getString("bloco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));

                lista.add(cliente);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao listar clientes: " + e.getMessage()
            );

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}