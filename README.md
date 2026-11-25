EntreLaços 💜


Aplicação de relacionamento desenvolvida em Java, como projeto acadêmico da disciplina Programação de Soluções Computacionais.


O EntreLaços é um aplicativo fictício de encontros voltado para adultos, que permite cadastrar perfis, adicionar interesses, descobrir outros usuários, enviar curtidas, formar matches e trocar mensagens.


👩‍💻 Integrante




Gabriela de Andrade




Turma: Programação de Soluções Computacionais (2026.2 – 4ª feira – manhã e tarde)


🛠️ Tecnologias utilizadas




Linguagem: Java


Versão: Java 21.0.7


Interface: Console (terminal)


Armazenamento: Dados mantidos em memória durante a execução.




▶️ Como executar o projeto




Certifique-se de ter o Java 21 instalado.


Baixe ou clone este repositório.


Abra o projeto em uma IDE compatível com Java ou pelo terminal.


Compile os arquivos .java.


Execute a classe Main, que contém o método principal do programa.




Pelo terminal, caso todos os arquivos estejam no mesmo diretório:


javac *.java
java Main



✨ Funcionalidades




Cadastro de perfis com nome, e-mail, idade, cidade e plano.


Validação de dados cadastrais, incluindo idade mínima de 18 anos e e-mail único.


Seleção de até três interesses por perfil.


Listagem e pesquisa de perfis por nome e cidade.


Dois planos disponíveis:



Essencial: limite de duas curtidas.


Conexão: limite de cinco curtidas.






Envio de curtidas entre perfis.


Identificação de curtidas recíprocas e criação automática de matches.


Visualização dos matches.


Troca de mensagens entre usuários que possuem match.




🧩 Organização das classes



O projeto foi estruturado em 12 classes, com responsabilidades específicas: 

 

| Classe | Responsabilidade |
|---|---|
| `Main` | Controla a interação com o usuário por meio dos menus do console. |
| `Perfil` | Representa os usuários cadastrados e armazena seus dados e interesses. |
| `Cadastro` | Gerencia os perfis, curtidas, matches, pesquisas e envio de mensagens. |
| `Plano` | Classe abstrata que define a estrutura dos planos e o limite de curtidas. |
| `PlanoEssencial` | Implementa o plano Essencial, com limite de duas curtidas. |
| `PlanoConexao` | Implementa o plano Conexão, com limite de cinco curtidas. |
| `Interesse` | Representa os interesses disponíveis em um catálogo compartilhado. |
| `Curtida` | Registra o perfil que enviou a curtida e o perfil que a recebeu. |
| `Match` | Representa a conexão entre dois perfis e armazena as mensagens da conversa. |
| `Mensagem` | Armazena o remetente e o conteúdo de cada mensagem. |
| `ValidacaoEmail` | Verifica se o endereço de e-mail possui um formato válido. |
| `NegocioException` | Define exceções personalizadas para o tratamento de regras de negócio. | 

 

🧪 Testes realizados


Durante o desenvolvimento, foram realizados testes funcionais por meio da execução do programa no console, verificando o comportamento das funcionalidades e das regras de negócio.


Os testes realizados foram:


Cadastro e validações




- Cadastro válido.


- Verificação da idade mínima de 18 anos.


- Impedimento de cadastro com nome ou cidade vazios.


- Validação de e-mail inválido.


- Impedimento de cadastro com e-mail duplicado.




Interesses




- Adição de interesses ao perfil.


- Verificação do limite máximo de três interesses.




Curtidas e matches




- Curtir outro perfil.


- Impedimento de curtida no próprio perfil.


- Impedimento de curtida duplicada.


- Verificação dos limites de curtidas de cada plano.


- Criação de match após curtidas recíprocas.


- Verificação de que não ocorre match sem curtida recíproca.




Mensagens e pesquisas




- Envio de mensagem após a formação de um match.


- Impedimento de envio de mensagem vazia.


- Impedimento de envio de mensagem sem match.


- Listagem e pesquisa de perfis.




📌 Observações




O projeto funciona por meio de menus no console, sem interface gráfica.


Os dados são armazenados em memória e não são persistidos após o encerramento do programa.


O sistema possui funcionalidades demonstrativas de cadastro, interação entre perfis e conversas, sem autenticação ou banco de dados.





Projeto acadêmico – Programação de Soluções Computacionais – 2026.2.


