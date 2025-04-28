rebU98 - Aplicativo de Caronas

Descrição

O rebU98 é um aplicativo de caronas desenvolvido para facilitar a oferta e a busca de corridas de maneira prática e intuitiva. A plataforma é responsiva e foi pensada para proporcionar uma experiência eficiente para motoristas e usuários que desejam oferecer ou buscar caronas.

Integrantes

Guilherme Lima

Maria de Fátima

Leonardo de Paula

Caio Silva

Laura Nery

Luana Cardoso

Tecnologias Utilizadas

Backend

Spring Boot

Spring Boot Web

Spring Boot DevTools

Spring Boot Data JPA

Spring Boot Validation

Spring Security

JWT (JSON Web Token)

Lombok

Banco de Dados
MySQL

Entidades e Atributos

Usuário (Usuario)

nome

email

tipoUsuario

senha

foto

motorista (associação com Motorista)

listaCorridas (corridas associadas)

Motorista (Motorista)

carro

cnh

placa

usuario (associação com Usuario)

listaCorridas (corridas associadas)

Corrida (Corrida)

origem

destino

preco

horario

distancia

motorista (associação com Motorista)

usuario (associação com Usuario)

velocidade

Funcionalidades Principais (CRUD)

Usuário

Cadastrar novo usuário

Login de usuário

Listar todos os usuários

Buscar usuário por ID

Atualizar dados do usuário

Deletar usuário

Motorista

Cadastrar motorista

Listar todos os motoristas

Buscar motorista por ID

Buscar motorista por CNH

Buscar motorista por modelo de carro

Buscar motorista por placa

Atualizar motorista

Deletar motorista

Corrida

Cadastrar corrida

Calcular tempo de corrida

Buscar corrida por ID

Buscar corrida por usuário

Buscar corrida por motorista

Atualizar corrida

Deletar corrida

