/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.DatabaseConnector;

/**
 *
 * @author Fábio Vieira
 */
public class TaskController {

    /* ---------------------------------------------------------------------------------------------------------------------------------------------------
       * GRAVAR DADOS DAS TASKS NO BANCO DE DADOS *
       --------------------------------------------------------------------------------------------------------------------------------------------------- */
    public void save(Task task) {
        //seta a conexão com o banco de dados e a statement como null
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            //Estabele conexão com o banco de dados 
            connection = DatabaseConnector.getConnection();

            //Prepara a query
            statement = connection.prepareStatement(sql);

            //Setando os valores
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            //Acima capta o erro da exceção caso algo de errado e dispara abaixo a mensagem de erro caso não consiga executar o bloco "try".
            throw new RuntimeException("Erro ao gravar a tarefa."
                    + e.getMessage(), e);

        } finally {
            //Independente de tudo dar certo ou errado nos blocos try e catch, o bloco abaixo é executado e finaliza a conexão com o banco de dados.
            DatabaseConnector.closeConnection(connection, statement);
        }

    }

    /* ---------------------------------------------------------------------------------------------------------------------------------------------------
       * ATUALIZAR DADOS DAS TASKS NO BANCO DE DADOS *
       --------------------------------------------------------------------------------------------------------------------------------------------------- */
    public void update(Task task) {
        //seta a conexão com o banco de dados e a statement como null
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "notes = ?, "
                + "completed = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";

        try {
            //Estabelecendo a conexão com o banco de dados 
            connection = DatabaseConnector.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            //Acima capta o erro da exceção caso algo de errado e dispara abaixo a mensagem de erro caso não consiga executar o bloco "try".
            throw new RuntimeException("Erro ao atualizar a tarefa." + e.getMessage(), e);
        } finally {
            //independente de tudo dar certo ou errado nos blocos try e catch, o bloco abaixo é executado e finaliza a conexão com o banco de dados.
            DatabaseConnector.closeConnection(connection, statement);
        }
    }

    /* ---------------------------------------------------------------------------------------------------------------------------------------------------
       * DELETA DADOS DAS TASKS NO BANCO DE DADOS *
       --------------------------------------------------------------------------------------------------------------------------------------------------- */
    public void removeById(int taskID) {
        //seta a conexão com o banco de dados e a statement como null
        Connection connection = null;
        PreparedStatement statement = null;

        //comando SQL armazenado na variável para executar e remover a TASK pela ID dela
        String sql = "DELETE FROM tasks WHERE id = ?";

        try {
            //Estabelecendo a conexão com o banco de dados 
            connection = DatabaseConnector.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores
            statement.setInt(1, taskID);

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            //acima capta o erro da exceção caso algo de errado e dispara abaixo a mensagem de erro caso não consiga executar o bloco "try".
            throw new RuntimeException("Erro ao deletar a tarefa.");

        } finally {
            //independente de tudo dar certo ou errado nos blocos try e catch, o bloco abaixo é executado e finaliza a conexão com o banco de dados.
            DatabaseConnector.closeConnection(connection, statement);
        }

    }

    /* ---------------------------------------------------------------------------------------------------------------------------------------------------
       * LISTAR DADOS DAS TASKS NO BANCO DE DADOS *
       --------------------------------------------------------------------------------------------------------------------------------------------------- */
    public List<Task> getAll(int idProject) {
        // o banco de dados e a statement como null
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        List<Task> tasks = new ArrayList<Task>();

        try {
            //Estabelecendo conexão com o banco de dados 
            connection = DatabaseConnector.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            //enquanto tiver próximo registro no banco, o while vai pegar e guardar na fila da lista <tasks>
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);
            }

        } catch (Exception e) {//acima capta o erro da exceção caso algo de errado e dispara abaixo a mensagem de erro caso não consiga executar o bloco "try".
            throw new RuntimeException("Erro ao acessar a lista de tarefa.");

        } finally {
            //independente de tudo dar certo ou errado nos blocos try e catch, o bloco abaixo é executado e finaliza a conexão com o banco de dados.
            DatabaseConnector.closeConnection(connection, statement);
        }

        //lista de tarefas que foi criada ee carregada do banco de dados
        return tasks;
    }
    
    
    public Task findOne(int idTask) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT * FROM tasks WHERE id = ?";
        
        Task task = new Task();

        try {
            connection = DatabaseConnector.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idTask);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setCreatedAt(resultSet.getDate("updatedAt"));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar tarefa", e);
        } finally {
            DatabaseConnector.closeConnection(connection, statement);
        }

        return task;
    }

}