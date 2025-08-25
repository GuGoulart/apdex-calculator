# APDEX CALCULATOR

Projeto Java para cálculo do índice Apdex (Application Performance Index) desenvolvido para a disciplina de Compliance, Quality Assurance & Tests.

DESCRIÇÃO
=========

O Apdex é uma métrica que mede a satisfação do usuário com o tempo de resposta de aplicações web, com valores de 0 a 1:

• 0.94 - 1.00: Excelente

• 0.85 - 0.93: Bom 
 
• 0.70 - 0.84: Regular

• 0.50 - 0.69: Pobre

• 0.00 - 0.49: Inaceitável

FÓRMULA:
Apdex = (Satisfied + Tolerating/2) / Total de Amostras

TECNOLOGIAS
===========

• Java 17

• Maven

• JUnit 5

COMO EXECUTAR
=============

1. Clone o repositório
2. Abra no IntelliJ IDEA
3. Execute os testes unitários na classe ApdexTest
4. Execute a aplicação pela classe principal Apdex

ESTRUTURA DO PROJETO
===================

src/main/java/Apdex.java - Classe principal com a lógica de cálculo

src/test/java/ApdexTest.java - Classe de testes unitários

REQUISITOS ATENDIDOS
===================

[x] Projeto Java com Maven e JUnit

[x] Total de amostras baseado no RM

[x] Classes com nome completo e RM na primeira linha

[x] Uso de annotations BeforeEach/BeforeAll

[x] Testes cobrindo todas as classificações Apdex

[x] Todos os testes passando no IntelliJ com JDK 17

FEITO POR
===================
AUTOR: Gustavo Goulart

RM: 555708
