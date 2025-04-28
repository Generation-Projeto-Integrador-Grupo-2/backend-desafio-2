<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>rebU98 - Aplicativo de Caronas</h1>

<h2>Descrição</h2>
<p>
    O <strong>rebU98</strong> é um aplicativo de caronas desenvolvido para facilitar a oferta e a busca de corridas
    de maneira prática e intuitiva. A plataforma é responsiva e foi pensada para proporcionar uma experiência eficiente
    para motoristas e usuários que desejam oferecer ou buscar caronas.
</p>
<div style="text-align: center;">
  <img src="https://i0.wp.com/maracujaroxo.com/wp-content/uploads/2017/06/gif-carona-viajar-sem-dinheiro.gif?ssl=1" alt="Gif de Carona" width="380">
</div>

<h2>Integrantes</h2>
<ul>
    <li>Guilherme Lima</li>
    <li>Maria de Fátima</li>
    <li>Leonardo de Paula</li>
    <li>Caio Nascimento</li>
    <li>Laura Nery</li>
    <li>Luana Cardoso</li>
</ul>

<h2>Tecnologias Utilizadas</h2>

<h3>Backend</h3>
<ul>
    <li>Spring Boot</li>
    <li>Spring Boot Web</li>
    <li>Spring Boot DevTools</li>
    <li>Spring Boot Data JPA</li>
    <li>Spring Boot Validation</li>
    <li>Spring Security</li>
    <li>JWT (JSON Web Token)</li>
    <li>Lombok</li>
</ul>

<h3>Banco de Dados</h3>
<ul>
    <li>MySQL</li>
</ul>

<h2>Entidades e Atributos</h2>

<h3>Usuário (<code>Usuario</code>)</h3>
<ul>
    <li>nome</li>
    <li>email</li>
    <li>tipoUsuario</li>
    <li>senha</li>
    <li>foto</li>
    <li>motorista (associação com Motorista)</li>
    <li>listaCorridas (corridas associadas)</li>
</ul>

<h3>Motorista (<code>Motorista</code>)</h3>
<ul>
    <li>carro</li>
    <li>cnh</li>
    <li>placa</li>
    <li>usuario (associação com Usuario)</li>
    <li>listaCorridas (corridas associadas)</li>
</ul>

<h3>Corrida (<code>Corrida</code>)</h3>
<ul>
    <li>origem</li>
    <li>destino</li>
    <li>preco</li>
    <li>horario</li>
    <li>distanciaKm</li>
    <li>motorista (associação com Motorista)</li>
    <li>usuario (associação com Usuario)</li>
    <li>velocidadeMedia</li>
</ul>

<h2>Funcionalidades Principais (CRUD)</h2>

<h3>Usuário</h3>
<ul>
    <li>Cadastrar novo usuário</li>
    <li>Login de usuário</li>
    <li>Listar todos os usuários</li>
    <li>Buscar usuário por ID</li>
    <li>Atualizar dados do usuário</li>
    <li>Deletar usuário</li>
</ul>

<h3>Motorista</h3>
<ul>
    <li>Cadastrar motorista</li>
    <li>Listar todos os motoristas</li>
    <li>Buscar motorista por ID</li>
    <li>Buscar motorista por CNH</li>
    <li>Buscar motorista por modelo de carro</li>
    <li>Buscar motorista por placa</li>
    <li>Atualizar motorista</li>
    <li>Deletar motorista</li>
</ul>

<h3>Corrida</h3>
<ul>
    <li>Cadastrar corrida</li>
    <li>Calcular tempo de corrida</li>
    <li>Buscar corrida por ID</li>
    <li>Buscar corrida por usuário</li>
    <li>Buscar corrida por motorista</li>
    <li>Atualizar corrida</li>
    <li>Deletar corrida</li>
</ul>

</body>
</html>
