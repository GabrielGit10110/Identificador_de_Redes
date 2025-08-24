# 👨‍🚀 Identificador de Redes
Software simples que permite a visualização do IP e a latência em ms.

## 🤔 O que faz?
Usa comandos de sistemas UNIX e Windows para identificar endereços IPV4, além de permitir a 
visualização da latência atual enviando um ping para www.google.com.br.

### Como usar:
1. Clone localmente esse repositório:
```bash
git clone https://github.com/GabrielGit10110/Identificador_de_Redes.git
```

*(2a: terminal, 2b: IDE)*
2.a Entre no diretório clonado:
```bash
cd Identificador_de_Redes
```

2.a2 Compile os arquivos para arquivos.class:
```bash
javac -s src -d bin /src/controller/RedesController.java /src/view/Main.java
```

2.a3 Execute:
```bash
java -cp dist view.Main
```

---

2.b Importe a pasta com o projeto em sua IDE (Eclipse, Intellij, etc).

2.b2 Execute ou compile para um jar executável.
