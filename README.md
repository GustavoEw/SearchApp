# 🔍 App de Pesquisa de Apps (Laboratório Android)

Este aplicativo é um **laboratório de estudos Android**, criado com o objetivo de compreender e testar, de forma isolada, conceitos fundamentais da plataforma antes de aplicá-los em projetos maiores.

O foco não é ser um produto final, mas sim um ambiente controlado para **experimentação, erro, aprendizado e validação de ideias**.

---

## 🎯 Objetivo

Explorar e compreender na prática:

- Funcionamento de **Intent** (implícito e explícito)
- Navegação entre telas
- Listagem de aplicativos instalados
- Uso de **SearchView**
- Layouts dinâmicos e flutuantes
- Pop-ups fixos
- Abertura de apps externos via Intent
- Separação entre lógica e interface

---

## 🧪 Natureza do Projeto

Este projeto é intencionalmente:

- 🔬 Experimental  
- 🧱 Modular  
- 🚧 Não definitivo  

Cada funcionalidade é desenvolvida como um **bloco independente**, permitindo testes rápidos e refatoração constante sem comprometer outros projetos.

---

## 🧠 Conceitos Estudados

### 🔹 Intents
- Intents explícitos para navegação entre telas
- Intents implícitos para consulta de aplicativos
- Uso de `ACTION_MAIN` e `CATEGORY_LAUNCHER`

### 🔹 PackageManager
- Consulta de aplicativos instalados
- Filtragem de apps que podem ser abertos
- Recuperação de nome, ícone e package name

### 🔹 UI e Experiência
- Campo de pesquisa dinâmico
- Atualização em tempo real da lista de apps
- Layouts flutuantes e sobrepostos
- Pop-ups fixos para interação rápida

---

## 🧩 Arquitetura (Visão Geral)

UI (Activity / View)
↓
Controller (Eventos do usuário)
↓
Lógica (Consulta de apps / filtros)
↓
Android System (PackageManager / Intent)

yaml
Copiar código

A arquitetura prioriza **clareza e separação de responsabilidades**, evitando acoplamento desnecessário.

---

## 🚀 Fluxo Básico do App

1. Usuário abre o app
2. Barra de pesquisa é exibida
3. Apps instalados são listados
4. Usuário pesquisa pelo nome
5. Usuário seleciona um app
6. App selecionado é aberto via Intent

---

## 📌 Status do Projeto

🚧 Em desenvolvimento contínuo  
📚 Foco em aprendizado e testes  
🔁 Refatorações frequentes conforme novos conceitos são estudados

---

## 📖 Observações

- Este projeto **não utiliza BroadcastReceiver**, pois todo o fluxo depende de interação direta do usuário.
- O uso de Broadcast será aplicado apenas em cenários apropriados, como eventos de sistema ou tempo, em outros projetos (ex: app de rotina).

---

## 🛠️ Tecnologias

- Java
- Android SDK
- Android Studio / JVroid
- Material Components

---

## 🧭 Próximos Estudos Planejados

- Otimização de busca
- Organização de layouts flutuantes
- Melhor separação entre UI e lógica
- Reutilização de componentes em outros projetos

---

## ✍️ Autor
Gustavo Ewerthon Alves Silva
Desenvolvido como projeto de estudo e laboratório pessoal.

