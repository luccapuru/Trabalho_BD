import java.sql.*;

public class Consulta {
    PreparedStatement pStmt;
    Connection conn = null;

    public Connection connect() {

        try {
            String url = "jdbc:sqlite:esports.db";
            // conectando com o banco
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("PRAGMA foreign_keys = ON");

            System.out.println("Conexao efetuada com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    String consultaJogador(int id){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM JOGADOR WHERE ID_JOGADOR = ?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaTecnico(int id){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM TECNICO WHERE ID_TECNICO = ?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaCampeonato(String nome){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM CAMPEONATO WHERE NOME LIKE ?");
            pStmt.setString(1, nome);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaTime(String nome){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM TIME WHERE NOME LIKE ?");
            pStmt.setString(1, nome);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaPatrocinador(int id_patrocinador){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM PATROCINADOR WHERE ID_PATROCINADOR = ?");
            pStmt.setInt(1, id_patrocinador);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaPartida(int fase, int rodada, int numero){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM PARTIDA WHERE FASE = ? AND RODADA = ? AND NUMERO = ?");
            pStmt.setInt(1, fase);
            pStmt.setInt(2, rodada);
            pStmt.setInt(3, numero);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaContrataJogador(int id_jogador, String nome_time){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM CONTRATA_JOGADOR WHERE ID_JOGADOR = ? AND NOME_TIME LIKE ?");
            pStmt.setInt(1, id_jogador);
            pStmt.setString(2, nome_time);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) +  "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaContrataTecico(int id_tecnico, String nome_time){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM CONTRATA_TECNICO WHERE ID_TECNICO = ? AND NOME_TIME LIKE ?");
            pStmt.setInt(1, id_tecnico);
            pStmt.setString(2, nome_time);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) +  "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaJoga(int fase, int rodada, int numero, int id_jogador){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM JOGA WHERE FASE = ? AND RODADA = ? AND NUMERO = ? AND ID_JOGADOR = ?");
            pStmt.setInt(1, fase);
            pStmt.setInt(2, rodada);
            pStmt.setInt(3, numero);
            pStmt.setInt(4, id_jogador);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2)  + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaParticipaCampeonato(String nome_time, String nome_campeonato){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM PARTICIPA_CAMPEONATO WHERE NOME_TIME LIKE ? AND NOME_CAMPEONATO LIKE ?");
            pStmt.setString(1, nome_time);
            pStmt.setString(2, nome_campeonato);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2)  + " " + rs.getString(3) + " " + rs.getString(4) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    String consultaPatrocinaTime(int id_patrocinador, String nome_time){
        String resultado = "nenhum resultado";
        try {
            pStmt = conn.prepareStatement("SELECT * FROM PATROCINA_TIME WHERE ID_PATROCINADOR = ? AND NOME_TIME LIKE ?");
            pStmt.setInt(1, id_patrocinador);
            pStmt.setString(2, nome_time);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                resultado = rs.getString(1) + " " + rs.getString(2) + "\n";
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

}
