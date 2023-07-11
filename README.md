# WhaToDo!?
## > "Do you know what you need to do? WhaToDo!" 


https://github.com/fabiovieirapontoexe/WhaToDo/assets/49982931/8a0f515c-2502-40f1-8e9c-a73c828fd86d


Projeto desenvolvido durante o curso de **PROGRAMAÇÃO: LÓGICA DE ALGORITMOS III** do **Programa Start by Capgemini** para fins de teste de conhecimento. O mesmo, desenvolvido em **JAVA** com o build automation tool **GRADLE** e usando dois banco de dados diferentes para facilitar a utilização e disponibilizar mais flexibilidade: MySQL e SQLite

A primeira versão desenvolvida pode ser adquirida [→ AQUI ](https://codeload.github.com/fabiovieirapontoexe/WhaToDo/zip/refs/heads/main) ou clonando este repositório. Essa versão faz a instanciação do banco de dados na classe `DatabaseConnector.java` em  `\app\src\main\java\util\` possibilitando que configure de acordo com seu SGBD de preferência.
Abaixo, a classe já vem configurada com o Mysql Conector e os parâmetros de configuração padrão.

Observação: Em caso do SGBD ser diferente, é necessário adicionar as dependências no arquivo `build.gradle` em `\app\build.gradle`. 


![image_8](https://github.com/fabiovieirapontoexe/WhaToDo/assets/49982931/ce8f053c-7fde-458c-855f-54715360ffe4)


| Requisito |Versão  |
|--|--|
| Java Development Kit (JDK)| 17 |
| Gradle |  8.0-rc-1 |

---

Já a segunda versão pode ser adquirida [→ AQUI ](https://objects.githubusercontent.com/github-production-release-asset-2e65be/664485122/81b01291-eb6d-449b-9ba9-207c8e7318f1?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230711%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230711T014633Z&X-Amz-Expires=300&X-Amz-Signature=022c52ce73c17266660382196bf617b29a20571993cdf668a3971c6feae79991&X-Amz-SignedHeaders=host&actor_id=49982931&key_id=0&repo_id=664485122&response-content-disposition=attachment%3B%20filename%3Dinstall-whatodo.exe&response-content-type=application%2Foctet-stream)foi desenvolvida usando um arquivo de banco local, feito em SQLite e gerado um fatJar apartir de todas as classes e dependencias da aplicação para ser **EASY-2-USE**. Foi também utilizado a versão gratuita do software [Install Creator 2 by Clickteam](https://www.clickteam.com/install-creator-2) para gerar um instalador e automatizar o processo.

Sendo assim, essa versão não há necessidade de nenhuma configuração e instalação adicional.

| Requisito |Versão  |
|--|--|
| Java Runtime Environment (JRE)| 1.8+ |

---

## O instalador faz basicamente 3 ações:
1. Cria uma pasta chamada `WhaToDo`  em `C:\`
2. Copia todo o conteúdo necessário para a aplicação dentro de `C:\WhaToDo\`.
3. Cria o atalho do fatJar (arquivo `.jar` que contém toda a aplicação) na área de trabalho para facilitar a execução.


# >**E prontinho! Agora é só usar. 💜👀📋🥳🎉**

---

# Relation View do banco de dados (MYSQL e SQLITE)

![relation_view](https://github.com/fabiovieirapontoexe/WhaToDo/assets/49982931/fd1832bf-e0a4-43e1-b9c4-67d52a366ff0)

---

# Sobre o Programa Start by Capgemini 

É uma iniciativa da Capgemini para acelerar a formação de novos talentos em tecnologia, valorizando a inclusão e a diversidade, com cursos online gratuitos, que após finalizados, oferecerão a você a chance de conquistar uma vaga e trabalhar no time Capgemini!

![slogan](https://github.com/fabiovieirapontoexe/WhaToDo/assets/49982931/8b697220-ce63-46ff-86ac-5ce4c4309741)

