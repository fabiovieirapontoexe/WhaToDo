package controller;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Project;
import java.sql.Date;
import java.util.ArrayList;

import util.DatabaseConnector;

public class ProjectController {

    public void save(Project project) {

        //SETA A CONEXÃO COM STATUS NULL
        Connection connection = null;

        //SETA A CONEXÃO COM STATUS NULL
        PreparedStatement statement = null;

        //STRING QUE GUARDA O COMANDO SQL A SER EXECUTADO
        String sql = "INSERT INTO projects (name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";

        //UM TRY|CATCH|FINALLY PARA CONSECUTIVAMENTE:
        //EXECUTAR O BLOCO TRY -> CONECTAR COM O BANCO, PREPARAR A QUERY, SETAR OS VALORES E EXECUTAR A QUERY PARA SALVAR DADOS NO BANCO
        //PEGAR O ERRO E EXIBI-LO CASO DÊ ALGO NO BLOCO TRY
        try {

            //ESTABELECE CONEXÃO COM O BANCO
            connection = DatabaseConnector.getConnection();

            //PREPARA A QUERY
            statement = connection.prepareStatement(sql);

            //SETA OS VALORES PARA A QUERY
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

            //INSERINDO OS DADOS NO BANCO DE DADOS
            statement.execute();

        } catch (Exception e) {

            //MENSAGEM DE ERRO CASO OCORRA ALGUMA EXCEÇÃO / ERRO NO BLOCO TRY ACIMA
            throw new RuntimeException("Erro ao gravar o projeto. " + e.getMessage(), e);

        } finally {

            //INDEPENDENTEMENTE DO RESULTADO DOS BLOCOS TRY|CATCH O FINALLY VAI EXECUTAR E FECHAR A CONXÃO COM O BANCO DE DADOS E O PREPARED STATEMENT
            DatabaseConnector.closeConnection(connection, statement);
        }
    }

    public void update(Project project) {

        //ESTABELECE CONEXÃO COM O BANCO
        Connection connection = null;

        //PREPARA A QUERY
        PreparedStatement statement = null;

        //STRING QUE GUARDA O COMANDO SQL A SER EXECUTADO
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";

        //UM TRY|CATCH|FINALLY PARA CONSECUTIVAMENTE:
        //EXECUTAR O BLOCO TRY -> CONECTAR COM O BANCO, PREPARAR A QUERY, SETAR OS VALORES E EXECUTAR A QUERY PARA SALVAR DADOS NO BANCO
        //PEGAR O ERRO E EXIBI-LO CASO DÊ ALGO NO BLOCO TRY
        //FECHAR A CONEXÃO COM O BANCO E COM O PREPAREDSTATEMENT INDEPENDENTE DO RESULTADO DO TRY E CATCH
        try {
            connection = DatabaseConnector.getConnection();

            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());

            //INSERINDO OS DADOS NO BANCO DE DADOS
            statement.execute();

        } catch (Exception e) {

            //MENSAGEM DE ERRO CASO OCORRA ALGUMA EXCEÇÃO / ERRO NO BLOCO TRY ACIMA
            throw new RuntimeException("Erro ao atualizar o projeto" + e.getMessage(), e);

        } finally {

            //INDEPENDENTEMENTE DO RESULTADO DOS BLOCOS TRY|CATCH, O FINALLY VAI EXECUTAR E FECHAR A CONEXÃO COM O BANCO DE DADOS E O STATEMENT
            DatabaseConnector.closeConnection(connection, statement);
        }

    }

    public void removeById(int idProject) {
        //ESTABELECE CONEXÃO COM O BANCO
        Connection connection = null;

        //PREPARA A QUERY
        PreparedStatement statement = null;

        //STRING QUE GUARDA O COMANDO SQL A SER EXECUTADO
        String sql = "DELETE FROM projects WHERE id = ?";

        //UM TRY|CATCH|FINALLY PARA CONSECUTIVAMENTE:
        //EXECUTAR O BLOCO TRY -> CONECTAR COM O BANCO, PREPARAR A QUERY, SETAR OS VALORES E EXECUTAR A QUERY PARA SALVAR DADOS NO BANCO
        //PEGAR O ERRO E EXIBI-LO CASO DÊ ALGO NO BLOCO TRY
        //FECHAR A CONEXÃO COM O BANCO E COM O PREPAREDSTATEMENT INDEPENDENTE DO RESULTADO DO TRY E CATCH
        try {

            //ESTABELECE CONEXÃO COM O BANCO
            connection = DatabaseConnector.getConnection();

            //PREPARA A QUERY
            statement = connection.prepareStatement(sql);

            //SETA OS VALORES PARA A QUERY
            statement.setInt(1, idProject);

            //INSERINDO OS DADOS NO BANCO DE DADOS
            statement.execute();

        } catch (Exception e) {

            //MENSAGEM DE ERRO CASO OCORRA ALGUMA EXCEÇÃO / ERRO NO BLOCO TRY ACIMA
            throw new RuntimeException("Erro ao remover o projeto" + e.getMessage(), e);

        } finally {

            //INDEPENDENTEMENTE DO RESULTADO DOS BLOCOS TRY|CATCH, O FINALLY VAI EXECUTAR E FECHAR A CONEXÃO COM O BANCO DE DADOS E O O PREPARED STATEMENT.
            DatabaseConnector.closeConnection(connection, statement);
        }

    }

    public List<Project> getAll() {

        //ESTABELECE CONEXÃO COM O BANCO
        Connection connection = null;

        //PREPARA A QUERY
        PreparedStatement statement = null;

        //STRING QUE GUARDA O COMANDO SQL A SER EXECUTADO
        String sql = "SELECT * FROM projects";

        //CRIA UMA LISTA VAZIA DO TIPO ARRAYLIST E SETA ELA COMO NOVA LISTA PARA RECEBER SOMENTE OBJETOS DO TIPO PROJECT(CLASSE PROJECT)
        List<Project> projects = new ArrayList<Project>();

        ResultSet resultSet = null;

        //UM TRY|CATCH|FINALLY PARA CONSECUTIVAMENTE:
        //EXECUTAR O BLOCO TRY -> CONECTAR COM O BANCO, PREPARAR A QUERY, SETAR OS VALORES E EXECUTAR A QUERY PARA SALVAR DADOS NO BANCO
        //PEGAR O ERRO E EXIBI-LO CASO DÊ ALGO NO BLOCO TRY
        //FECHAR A CONEXÃO COM O BANCO E COM O PREPAREDSTATEMENT INDEPENDENTE DO RESULTADO DO TRY E CATCH
        try {

            //ESTABELECE CONEXÃO COM O BANCO
            connection = DatabaseConnector.getConnection();

            //PREPARA A QUERY
            statement = connection.prepareStatement(sql);

            //EXECUTA UMA CONSULTA SQL NO BANCO DE DADOS E ARMAZENA O RESULTADO EM UM OBJETO RESULTSET
            resultSet = statement.executeQuery();

            //ITERA SOBRE OS RESULTADOS DO RESULTSET E CRIA OBJETOS PROJECT COM BASE NO BANCO DE DADOS
            while (resultSet.next()) {

                //CRIA UM NOVO OBJETO PROJECT PARA ARMAZENAR OS DADOS DO REGISTRO ATUAL DO RESULTSET
                Project project = new Project();

                //SETA OS VALORES DESSA CONSULTA AO BANCO DE DADOS, 1 A 1
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));

                // CAPTURA TODOS OS DADOS E INSERE NA LISTA PROJECTS
                projects.add(project);

            }

        } catch (Exception e) {

            //MENSAGEM DE ERRO CASO OCORRA ALGUMA EXCEÇÃO / ERRO NO BLOCO TRY ACIMA
            throw new RuntimeException("Erro ao consultar o projeto." + e.getMessage(), e);

        } finally {

            //INDEPENDENTEMENTE DO RESULTADO DOS BLOCOS TRY|CATCH, O FINALLY VAI EXECUTAR E FECHAR A CONEXÃO COM O BANCO DE DADOS O PREPARED STATEMENT E O RESULTSET.
            DatabaseConnector.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }
}
