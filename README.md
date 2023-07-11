# WhaToDo!?
## > "Do you know what you need to do? WhaToDo!" 

Projeto desenvolvido durante o curso de **PROGRAMAÇÃO: LÓGICA DE ALGORITMOS III** para fins de teste de conhecimentos. O mesmo, desenvolvido em **JAVA** com o build automation tool **GRADLE** e usando dois banco de dados diferentes para facilitar a utilização e disponibilizar mais flexibilidade: MySQL e SQLite

A primeira versão desenvolvida pode ser adquirida [→ AQUI ](https://codeload.github.com/fabiovieirapontoexe/WhaToDo/zip/refs/heads/main) ou clonando este repositório. Essa versão faz a instanciação do banco de dados na classe `DatabaseConnector.java` em  `\app\src\main\java\util\` possibilitando que configure de acordo com seu SGBD de preferência.
Abaixo, a classe já vem configurada com o Mysql Conector e os parâmetros de configuração padrão.

Observação: Em caso do SGBD ser diferente, é necessário adicionar as dependências no arquivo `build.gradle` em `\app\build.gradle`. 

![image_8](https://github.com/fabiovieirapontoexe/WhaToDo/assets/49982931/ce8f053c-7fde-458c-855f-54715360ffe4)

| Requisito |Versão  |
|--|--|
| Java Development Kit (JDK)| 17 |
| Gradle |  8.0-rc-1 |
---

Já a segunda versão, foi desenvolvida usando um arquivo de banco local, feito em SQLite e gerado um fatJar apartir de todas as classes e dependencias da aplicação para ser **EASY-2-USE**. Foi também utilizado a versão gratuita do software [Install Creator 2 by Clickteam](https://www.clickteam.com/install-creator-2) para gerar um instalador e automatizar o processo.
Sendo assim, essa versão não tem a necessidade de nenhuma configuração e instalação adicional.
| Requisito |Versão  |
|--|--|
| Java Runtime Environment (JRE)| 1.8 |
---
