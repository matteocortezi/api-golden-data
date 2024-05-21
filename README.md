# Golden-Data-API

## Pitch
Assista ao nosso pitch https://youtu.be/Gd7xjo8WuCk

## Integrantes do Grupo
- **Vitor da Silva Ruas** (550871): Responsável pelo planejamento do projeto, garantindo a coesão entre o desenvolvimento do sistema, modelos de IA, APIs, banco de dados, front-end, entre outros.
- **Gabriel Previ de Oliveira** (98774): Encarregado da criação, modelagem e manutenção do banco de dados da aplicação, colaborando na implementação do JavaSpring Boot para assegurar a compatibilidade de entidades e atributos do projeto.
- **Gustavo Soares Fosaluza** (97850): Responsável pelo treinamento dos modelos de machine learning e pela virtualização do projeto.
- **Mateus Vinicius da Conceição Silva** (551692): Encarregado das entregas Java, Spring Boot, orientação a objetos, entre outros.
- **Pedro Henrique Figueiredo de Oliveira** (552000): Responsável pelo desenvolvimento do front-end do projeto.

## Instruções de Execução:
Para executar o projeto Golden Data, siga os passos abaixo:

1. Abra sua IDE (Integrated Development Environment) preferida.
2. Localize o arquivo `ApiApplication.java` na estrutura do projeto.
3. Execute a aplicação clicando com o botão direito do mouse no arquivo `ApiApplication.java` e escolhendo a opção "Run As" > "Java Application" (ou equivalente na sua IDE).

### Utilização dos Métodos HTTP:

Certifique-se de estar utilizando o Maven e de ter as dependências necessárias instaladas na sua máquina.

- **Método POST (Inserção de Dados):**
  - Utilize o padrão JSON encontrado no software de testes de API (como o Insomnia ou Postman) para enviar novos dados à API Golden Data.

- **Método PUT (Atualização de Dados):**
  - Siga o padrão PUT presente no software de testes de API para atualizar informações existentes na API Golden Data.

- **Método DELETE (Remoção de Dados):**
  - Para deletar dados, identifique o caminho correspondente ao recurso que deseja remover. Por exemplo, para remover um cliente específico, utilize o caminho `https://localhost:8080/clientes/{id}`, substituindo `{id}` pelo identificador do cliente a ser removido.

- **Método GET (Consulta de Dados):**
  - Para consultar dados persistentes nas tabelas do banco de dados, selecione o método GET no software de testes de API e especifique o caminho correspondente ao recurso desejado. Por exemplo, para consultar todos os clientes, utilize o caminho `https://localhost:8080/clientes`.

Essas instruções são baseadas na forma padrão de execução e uso de métodos HTTP em uma API Spring Boot como a Golden Data.

## Listagem de todos os Endpoints (Documentação da API):

- **CadastroConsumidor:**
  - Manipula dados sobre o consumidor, como nome, estado, e-mail, data de nascimento, etc. O consumidor é fundamental para a aplicação, representando a parte entrevistada para compreender suas preferências.

- **CadastroEmpresa:**
  - Manipula dados sobre a empresa, como o cnpj, razão-social, email, login e etc. A empresa é o nosso cliente real, forneceremos os dados dos consumidores para ela.

- **Histórico de Compras:**
  - Armazena o histórico de compras da empresa, incluindo atributos como valor e data.

- **Pagamento:**
  - Armazena o histórico de pagamentos da empresa.

- **InfoConsumidor:**
  - Este endpoint gerenciára os dados mais importantes do projeto. Referentes aos consumidores, é através destes dados que treinaremos nosso modelo de inteligência artificial.

## ARTEFATOS DE SOFTWARE:

### 1. Documento de Requisitos:

**Requisitos Funcionais:**
- Análise do histórico de compras dos clientes.
- Classificação de emoções associadas aos feedbacks dos clientes.
- Geração de relatórios detalhados sobre desempenho de vendas, comportamento dos clientes e tendências de mercado.
- Análises preditivas para prever comportamentos futuros dos clientes.
- Integrações personalizadas com outros sistemas de análise de dados.

**Requisitos Não Funcionais:**
- Escalabilidade para lidar com grandes volumes de dados.
- Segurança dos dados dos clientes seguindo padrões de criptografia.
- Interface de usuário intuitiva e amigável.
- Desempenho eficiente ao processar análises complexas.
- Adesão a padrões de usabilidade e acessibilidade.

### 2. Diagrama de Arquitetura:

O diagrama de arquitetura incluirá:
- Camada de Coleta e Interpretação de Dados.
- Algoritmos de Machine Learning e Inteligência Artificial.
- Interface de Usuário para empresas.

### 3. Protótipo de Interface de Usuário:

Incluirá representações visuais das seguintes telas:
- Tela de Login.
- Tela de Cadastro de Clientes das Empresas.
- Página de Análise de Histórico de Compras.
- Página de Análise de Feedbacks.
- Página de Análise de Histórico de Navegação.
- Página de Relatórios Detalhados e Padrões de Recomendações.

### 5. Código-fonte:

Incluirá:
- Lógica de Coleta e Interpretação de Dados.
- Algoritmos de Análise de Dados (incluindo Machine Learning e IA).
- Front-end para a Interface de Usuário.
- Integrações com formatos de dados .csv e .xlsx.
- Testes unitários e de integração.

### 6. Casos de Teste:

Abordarão diferentes cenários de uso da aplicação, testando as funcionalidades para um cliente da empresa e para os próprios clientes.

### 7. Documentação do Usuário:

Incluirá manuais e guias para:
- Utilização das funcionalidades disponíveis.
- Interpretação dos relatórios gerados.
- Configuração de integrações personalizadas.
