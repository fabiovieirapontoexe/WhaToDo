package TodoApp;

//import controller.ProjectController;

import view.MainScreen;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//import java.sql.Date;
//import model.Project;
//import util.DatabaseConnector;

public class App {

    public static void main(String[] args) {
        
        
        MainScreen appMainScreen = new MainScreen();
        appMainScreen.setVisible(true);
        
        /*
        
        //TESTANDO A CONEXÃO
        Connection connection = DatabaseConnector.getConnection();

        System.out.println("CONEXÃO FOI PICA!");

        DatabaseConnector.closeConnection(connection);
        ProjectController projectController = new ProjectController();
        
        
        //INSERINDO DADOS - TESTES
        Project project = new Project();
        project.setName("Projeto teste");
        project.setDescription("Descrição teste");
        projectController.save(project);
        
        //ATUALIZANDO DADOS - TESTE
        project.setId(1);
        project.setName("novo nome de Projeto");
        project.setDescription("Descrição teste123");
        projectController.update(project);
        
        //REMOVENDO DADOS - TESTE
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos = " + projects.size());
        
        projectController.removeById(1);
        
        */
    }
}
