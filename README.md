Folha de Pagamento - Android Studio
Descrição do Projeto

Este aplicativo foi desenvolvido como atividade avaliativa com o objetivo de criar uma Folha de Pagamento utilizando Java no Android Studio.

O sistema permite calcular o salário líquido de um funcionário com base nas informações fornecidas pelo usuário, realizando automaticamente:

Cálculo do desconto do INSS;
Cálculo do desconto do IR;
Verificação do direito ao salário-família;
Exibição do salário líquido final.
Funcionalidades

Entrada de Dados

O aplicativo possui os seguintes campos:

Nome do Funcionário
Salário Bruto
Sexo (Masculino ou Feminino usando RadioButton)
Número de Filhos

Regras de Cálculo

Desconto do INSS
Faixa Salarial	Alíquota
Até R$ 1.212,00	7,5%
De R$ 1.212,01 até R$ 2.427,35	9%
De R$ 2.427,36 até R$ 3.641,03	12%
De R$ 3.641,04 até R$ 7.087,22	14%

Desconto do IR
Faixa Salarial	Alíquota
Até R$ 1.903,98	Isento
De R$ 1.903,99 até R$ 2.826,65	7,5%
De R$ 2.826,66 até R$ 3.751,05	15%
De R$ 3.751,06 até R$ 4.664,68	22,5%

Salário-Família

Funcionários com salário bruto de até R$ 1.212,00 recebem:

R$ 56,47 por filho

Fórmula Utilizada
O salário líquido é calculado utilizando a fórmula:

Salário Liquido=Salário Bruto−(Desconto INSS+Desconto IR)+Salário Família

Tecnologias Utilizadas
Java
Android Studio
XML para interface gráfica
Componentes Android:
EditText
RadioButton
Button
TextView
Toast

Funcionamento do Aplicativo
O usuário informa:
Nome;
Salário;
Sexo;
Quantidade de filhos.
Ao clicar no botão Calcular:
O sistema valida os dados;
Calcula INSS;
Calcula IR;
Verifica salário-família;
Exibe os resultados na tela.

Validações Implementadas

O aplicativo possui tratamento para entradas inválidas, como:

Nome vazio;
Salário negativo;
Número de filhos negativo;
Campos vazios;
Sexo não selecionado.

Quando ocorre algum erro, o sistema exibe mensagens utilizando Toast.


Resultados Exibidos

Após o cálculo, o aplicativo mostra:

Nome do funcionário com tratamento:
Sr. para masculino
Sra. para feminino
Valor do desconto do INSS;
Valor do desconto do IR;
Valor do salário-família;
Valor do salário líquido.
