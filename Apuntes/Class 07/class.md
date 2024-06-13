# Diagramas de Caso de Uso DCU

objetivo de trabajar con estos diagramas es explicar el caso a resolver
nota : Poyecto de bimestre con lleva esto de diagramas de caso de uso , digramas de class
simbologia:

- actor: hacen aciones representan personas sistemas estos se transforman clases
- use (flecha):
- uskase(elipse) : representa el proceso (se transforman en metodos)
- include : obligatorio se usa una ves
- exclude: se utilizan mas de dos veces si no no

## Caso de estudio ejemplo TUTI

Ejemplo de diagrama de uso (foto)
proyecto de  venta /compras
actor : cliente --use--> (compra productos (precensial))     <------cajero  ---use-> (cobra en efectivo) <----sistema /app
                --use--> (compra de productos en linea)       <--use cajero-- supervisor

## Coneptualizacion

Conceptualizar el tema en base al diagra de caso de uso

CLIENTE

**propiedades**
-lista de productos
-cantidad de dinero    ---> **Producto**                      **cajero**       **supervisor**
-Nombre del cliente         -precio                              -nombre             -nombre
-numero de cedula           -stok                                -usuario            -usuario
                            -fecha de vencimiento                + cobrar()          -Cod de autorizacion
**metodos**
+geter /celer                 **APP**
+compra precencial()           -scon BD
~comprar precencial ()         + MAIN

## Concep de Herencia

obtimizar el  codigo de persona se pude utilizar para los otros como cliente...
persona --> cliente - cajero - supervisor
propieda overwriter : personaliza el atributo  en la herencia

## Principio de mantenimiento rapido

Un solo cambio en el pricipal (persona) ya hereda a los demas
nota: todo los que diagramas  y conceptualizamos son objetos dinamicos
datos estaticos no se pueden cambiar el valor

## Diagrama de Clase

De persona o el papa hacia lo demas : especificar
de hijos a papa o persona : generalizacion
Dodo se dibuja como muñequito y lo d elas elipses siemre van en vervos ir er ...
