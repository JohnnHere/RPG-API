# RPG-API

Este projeto se trata de uma API para jogadores de RPG de mesa cadastrarem as fichas de seus personagens. A ideia central do projeto é ser flexível, portanto é possível criar diferentes versões desta ideia para adaptar a regras específicas de determinadas história e universo.

## Linguagens

<div style="display: inline_block"><br>
  <img align="center" alt="Joao-Java" height="30" width="40" src="https://raw.githubusercontent.com/jmnote/z-icons/master/svg/java.svg">
  <img align="center" alt="Joao-Spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg">
  <img align="center" alt="Joao-MySQL" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg">
</div>

## Regras de Negócio
```bash
Um personagem só pode ter uma raça e uma classe. Para criar um personagem, ele deve ser atrelado a uma classe e raça já existentes.
```
```bash
Um personagem pode ter no máximo três profissões.
```
```bash
Raças e Classes são únicas, não podem ter nome repetido.
```
```bash
Para criar características, elas devem ser associadas a personagens. 
```
```bash
O ID de uma característica não pode ser duplicado, é único para cada personagem.
```
```bash
Se o personagem já possuir um ID de características associado a ele, ele não pode associar um novo. Apenas atualizar o atual.
```
```bash
É possível criar perícias, profissões e equipamentos sem associar a um personagem.
```

## Modelo Conceitual: Modelo Entidade-Relacionamento
![image](https://user-images.githubusercontent.com/92900668/196811807-f197fbd7-6e4e-457e-a72d-b08538dee8f7.png)

## Implementações Futuras
O projeto ainda é embrionário e o código será implementado gradativamente. Algumas regras estão, também, sujeitas a alterações, assim como remoções e adições também podem acontecer.
