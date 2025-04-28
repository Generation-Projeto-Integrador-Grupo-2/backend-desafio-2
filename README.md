# 🚗✨ **rebU98 - Aplicativo de Caronas** ✨🚗

---

## 🌟 Descrição

O **rebU98** é um aplicativo inovador que conecta motoristas e passageiros de forma prática, rápida e segura. Pensado para facilitar deslocamentos diários ou oferecer uma carona a quem precisa, nossa plataforma responsiva garante uma experiência intuitiva e eficiente em qualquer dispositivo.

> 💡 **Conectando pessoas, facilitando viagens!**

---
</p>
<div style="text-align: center;">
  <img src="https://i0.wp.com/maracujaroxo.com/wp-content/uploads/2017/06/gif-carona-viajar-sem-dinheiro.gif?ssl=1" alt="Gif de Carona" width="380">
</div>

---

## 🧑‍🤝‍🧑 **Integrantes**

- Guilherme Lima  
- Maria de Fátima  
- Leonardo de Paula  
- Caio Nascimento  
- Laura Nery  
- Luana Cardoso  

---

## 🛠️ Tecnologias Utilizadas

### Backend
- ⚙️ **Spring Boot**
  - Spring Boot Web
  - Spring Boot DevTools
  - Spring Boot Data JPA
  - Spring Boot Validation
  - Spring Security
  -  JWT (JSON Web Token)
  - Lombok

### Banco de Dados
- 🗄️ **MySQL**

---

## 📋 Entidades e Atributos

### 👤 Usuário (`Usuario`)
- `nome`
- `email`
- `tipoUsuario` (ex: passageiro ou motorista)
- `senha`
- `foto`
- `motorista` (associação com `Motorista`)
- `listaCorridas` (corridas associadas)

### 🚗 Motorista (`Motorista`)
- `carro`
- `cnh`
- `placa`
- `usuario` (associação com `Usuario`)
- `listaCorridas` (corridas associadas)

### 🏁 Corrida (`Corrida`)
- `origem`
- `destino`
- `preco`
- `horario`
- `distanciaKm`
- `motorista` (associação com `Motorista`)
- `usuario` (associação com `Usuario`)
- `velocidadeMedia`

---

## ⚙️ Funcionalidades Principais (CRUD)

### 👤 Usuário
✅ Cadastrar novo usuário  
🔑 Login seguro com JWT  
📋 Listar todos os usuários  
🔍 Buscar usuário por ID  
✏️ Atualizar dados do usuário  
🗑️ Deletar usuário  

### 🚗 Motorista
✅ Cadastrar motorista  
📋 Listar todos os motoristas  
🔍 Buscar por ID, CNH, modelo do carro ou placa  
✏️ Atualizar informações do motorista  
🗑️ Deletar motorista  

### 🏎️ Corrida
✅ Criar nova corrida  
⏱️ Calcular tempo estimado da corrida  
🔍 Buscar corrida por ID, usuário ou motorista  
✏️ Atualizar detalhes da corrida  
🗑️ Deletar corrida  

---
# 🎨✨ Diagrama ✨🎨



![image](https://github.com/user-attachments/assets/ea484efe-aae8-45e5-bca2-4639198a05e2)


✨ Obrigado por visitar! ✨
