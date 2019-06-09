<h3>Analisador Léxico e Sintático para a linguagem SLP (Simple Lisp) criada em sala de aula.</h3>
</br>
A linguagem é sintaticamente baseada em LISP.</br>
Possui escopo de função, estruturas de repetição e condição.
</br></br>

<b> Terminais:</b>
```
id = {Letter}{AlphaNumeric}*
cls = '"' {String Chars}* '"'
cli = {Digit}{Digit}*
clr = {Digit}{Digit}* '.' {Digit}{Digit}*
cll = V | F
```
<b>Gramática</b>
```
<programa> ::= <comando> <programa> | <funcao> <programa> |
<funcao> ::= '(' <funcao-interna> ')'
<funcao-interna> ::= 'fun' id <params> ':' <tipo> <comandos>
<params> ::= <param> <params> |
<param> ::= '(' <tipo> id ')'
<tipo> ::= 'int' | 'real' | 'texto' | 'logico' | 'nada'
<comandos> ::= <comando> <comandos> |
<comando> ::= '(' <comando-interno> ')'
<comando-interno> ::= <decl> | <atrib> | <invoca> | <se> | <leitura> | <enquanto> | <para> | <retorno> | <mostrar>
<decl> ::= <tipo> <ids>
<ids> ::= id <ids2>
<ids2> ::= id <ids2> |
<atrib> ::= '=' id <expr>
<expr> ::= <operan> | '(' <op2> <expr> <expr> ')' | '(' <op1> id ')' | '(' <invoca> ')' 
<op1> ::= '++' | '--'
<op2> ::= '&&' | '||' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '.' | '+' | '-' | '*' | '/'
<invoca> ::= id <args>
<args> ::= <expr> <args> | 
<operan> ::= id | cli | clr | cll | cls 
<se> ::= 'se' <expr> '(' <comandos> ')' <senao>
<senao> ::= '(' <comandos> ')' |
<leitura> ::= 'le' id
<mostrar> ::= 'mostra '<expr>
<enquanto> ::= 'enquanto' <expr> <comandos>
<para> ::= 'para' <atrib> <expr> <atrib> <comandos>
<retorno> ::= 'ret' <expr>
```
