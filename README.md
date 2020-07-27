# URL Shortener
Se creo un cortador de URL asignando un alias para cada una con los siguientes requisitos:
- Si la URL contiene la palabra __google__ 
  - El alias tendrá un tamaño de 5
  - Estará compuesto de carácteres alfabéticos
- Si la URL contiene la palabra __yahoo__ 
  - El alias tendrá un tamaño de 7
  - Estará compuesto de carácteres alfanuméricos
- Cualquier URL
  - Estará basado en la URL original eliminando vocales, números y carácteres especiales

## Crear alias

### Request
- Método: POST
- URL: localhost/
- Cuerpo: content-type = json
```json
{
   "url": "www.google.com"
}
```

### Respuesta
- Estado 200
  - alias: XUVDQ
- Estado 404
  - La url no es correcta
  
## Obtener URL original por medio del alias

### Request
- Método: GET
- URL: localhost/{alias}

### Respuesta
- Estado 200
  - URL original
- Estado 404
  - ```Alias no encontrado```
  
## Ejemplos
- https://nearsoft.com <br />
  ```alias: httpsnrsftcm```
- https://espanol.yahoo.com/ <br />
  ```alias: t4oRj9N```
- https://news.google.com/topstories?hl=es-419&tab=wn&gl=MX&ceid=MX:es-419 <br />
  ```alias: uPzdJ```
- www.una7$url#.com <br />
  ```La url no es correcta```
  
## División del proyecto

### Modelo
Modelo  ```UrlFormat``` el cual tiene los atributos url y alias con sus respectivos métodos de acceso

### Controlador
Responde a las solicitudes GET y POST

### Servicio
Se encuentran los métodos usados por el controlador
- validateUrl. Verifica que el valor ingresado sea una URL, regresa un booleano.
- createAlias. Llama al método validateUrl.
- generateAlias. Crea el alias para la url.
- foundUrl. Verifica la existencia de la url en la lista de url a través del alias envíado por get.
- getOriginalUrl. Busca la url que corresponda con el alias. 
