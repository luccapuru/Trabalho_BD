import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insere {
    PreparedStatement pStmt;
    Connection conn = null;

    public Connection connect() {

        try {
            String url = "jdbc:sqlite:esports.db";
            // conectando com o banco
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON");

            System.out.println("Conexão efetuada com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    void insereJogador(int id, String nome, String nacionalidade, String data){
        try {
            pStmt = conn.prepareStatement("INSERT INTO JOGADOR VALUES (?, ?, ?, ?)");
            pStmt.setInt(1, id);
            pStmt.setString(2, nome);
            pStmt.setString(3, nacionalidade);
            pStmt.setString(4, data);
            pStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereTecnico(int id, String nome, String nacionalidade, String data){
        try {
            pStmt = conn.prepareStatement("INSERT INTO TECNICO VALUES (?, ?, ?, ?)");
            pStmt.setInt(1, id);
            pStmt.setString(2, nome);
            pStmt.setString(3, nacionalidade);
            pStmt.setString(4, data);
            pStmt.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereCampeonato (String nome, float premiacao){
        try {
            pStmt = conn.prepareStatement("INSERT INTO CAMPEONATO VALUES (?, ?)");
            pStmt.setString(1, nome);
            pStmt.setFloat(2, premiacao);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereTime (String nome, String jogo, String dono, String pais, String datacriacao){
        try {
            pStmt = conn.prepareStatement("INSERT INTO TIME VALUES (?, ?, ?, ?, ?)");
            pStmt.setString(1, nome);
            pStmt.setString(2, jogo);
            pStmt.setString(3, dono);
            pStmt.setString(4, pais);
            pStmt.setString(5, datacriacao);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void inserePatrocinador (int id, String nome){
        try {
            pStmt = conn.prepareStatement("INSERT INTO PATROCINADOR VALUES (?, ?)");
            pStmt.setInt(1, id);
            pStmt.setString(2, nome);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void inserePartida (int fase, int rodada, int numero, String nomeCampeonato){
        try {
            pStmt = conn.prepareStatement("INSERT INTO PARTIDA VALUES (?, ?, ?, ?)");
            pStmt.setInt(1, fase);
            pStmt.setInt(2, rodada);
            pStmt.setInt(3, numero);
            pStmt.setString(4, nomeCampeonato);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereContrataJogador (int id_jogador, String nome_time){
        try {
            pStmt = conn.prepareStatement("INSERT INTO CONTRATA_JOGADOR VALUES (?, ?)");
            pStmt.setInt(1, id_jogador);
            pStmt.setString(2, nome_time);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereContrataTecnico (int id_tecnico, String nome_time){
        try {
            pStmt = conn.prepareStatement("INSERT INTO CONTRATA_TECNICO VALUES (?, ?)");
            pStmt.setInt(1, id_tecnico);
            pStmt.setString(2, nome_time);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void inserejoga (int fase, int rodada, int numero, int id_jogador) {
        try {
            pStmt = conn.prepareStatement("INSERT INTO JOGA VALUES (?, ?, ?, ?)");
            pStmt.setInt(1, fase);
            pStmt.setInt(2, rodada);
            pStmt.setInt(3, numero);
            pStmt.setInt(4, id_jogador);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void insereParticipaCampeonato (String nome_time, String nome_campeonato, int ano, int colocacao, String local) {
        try {
            pStmt = conn.prepareStatement("INSERT INTO PARTICIPA_CAMPEONATO VALUES (?, ?, ?, ?, ?)");
            pStmt.setString(1, nome_time);
            pStmt.setString(2, nome_campeonato);
            pStmt.setInt(3, ano);
            pStmt.setInt(4, colocacao);
            pStmt.setString(5, local);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void inserePatrocinaTime (int id_patrocinador, String nome_time) {
        try {
            pStmt = conn.prepareStatement("INSERT INTO PATROCINA_TIME VALUES (?, ?)");
            pStmt.setInt(1, id_patrocinador);
            pStmt.setString(2, nome_time);
            pStmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaJogador(int id_jogador) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM JOGADOR WHERE ID_JOGADOR = ?");
            pStmt.setInt(1, id_jogador);

            int linhasdeletadas = pStmt.executeUpdate();
            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaTecnico(int id_tecnico) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM TECNICO WHERE ID_TECNICO = ?");
            pStmt.setInt(1, id_tecnico);

            int linhasdeletadas = pStmt.executeUpdate();
            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaCampeonato(String nome) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM CAMPEONATO WHERE NOME = ?");
            pStmt.setString(1, nome);

            int linhasdeletadas = pStmt.executeUpdate();
            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaPartida(int fase, int rodada, int numero) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM PARTIDA WHERE FASE = ? AND RODADA = ? AND NUMERO = ?");
            pStmt.setInt(1, fase);
            pStmt.setInt(2, rodada);
            pStmt.setInt(3, numero);


            int linhasdeletadas = pStmt.executeUpdate();

            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaPatrocinador(int id_patriocinador) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM PATRIOCINADOR WHERE ID_PATRIOCINADOR = ?");
            pStmt.setInt(1, id_patriocinador);

            int linhasdeletadas = pStmt.executeUpdate();

            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void deletaTime(String nome) {
        try {
            pStmt = conn.prepareStatement("DELETE FROM TIME WHERE NOME = ?");
            pStmt.setString(1, nome);

            int linhasdeletadas = pStmt.executeUpdate();

            System.out.println("Foram deletados " + linhasdeletadas + "Registros");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }



}


