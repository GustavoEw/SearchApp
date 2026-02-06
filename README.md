# 📱 SearchApp – Overlay Flutuante para Abertura de Aplicativos

SearchApp é um aplicativo Android que utiliza **overlay flutuante** para permitir que o usuário pesquise e abra aplicativos instalados no dispositivo de forma rápida, sem precisar sair da tela atual.

O projeto foi desenvolvido com foco em **boas práticas**, **compatibilidade entre versões do Android** e **arquitetura limpa**, separando claramente responsabilidades entre Service, UI e lógica de negócio.

---

## ✨ Funcionalidades

- Overlay flutuante sempre acessível (estilo bolha)
- Interface com dois estados: contraído e expandido
- Campo de busca para localizar aplicativos pelo nome
- Abertura direta de aplicativos instalados
- Execução em **Foreground Service**
- Funcionamento contínuo mesmo com a tela bloqueada
- Compatibilidade com versões antigas e recentes do Android

---

## 🧠 Arquitetura do Projeto

O projeto foi estruturado para facilitar manutenção, testes e evolução futura.

### 🔹 Service
Responsável por:
- Gerenciar o ciclo de vida do app em segundo plano
- Criar e manter o **Foreground Service**
- Configurar o canal de notificação
- Solicitar permissões necessárias

O Service **não contém lógica de UI**.

---

### 🔹 Overlay
Classe dedicada exclusivamente ao controle da janela flutuante.

Responsabilidades:
- Gerenciar o `WindowManager`
- Inflar o layout do overlay
- Adicionar e remover a view da tela
- Controlar parâmetros da janela flutuante

Essa classe **não depende de Activity**, podendo ser utilizada diretamente pelo Service.

---

### 🔹 Layout XML
- `FrameLayout` como view raiz do overlay
- `ImageView` representando a bolha (modo contraído)
- `LinearLayout` representando o modo expandido
- Controle total de visibilidade via código

---

## 🧩 Tecnologias e APIs Utilizadas

- Java
- Android SDK
- WindowManager
- Foreground Service
- NotificationChannel
- LayoutInflater
- SYSTEM_ALERT_WINDOW
- Controle de versão via `Build.VERSION.SDK_INT`

---

# 👨‍💻 Autor

Gustavo Ewerthon
Desenvolvedor Android
Foco em automação, interfaces flutuantes e sistemas inteligentes




