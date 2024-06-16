Esta aplicación realiza el proceso de Login y Registro de usuarios usando contraseñas encriptadas
El proceso es muy sencillo

La app cuenta con dos pantallas, Login y Registro de usuarios </br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/925eb135-ed1f-4f44-bc5b-2b66d3359c7b)
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/f15e8f8b-455d-47f8-a68c-6847e85a4672)
</br></br>
## Empecemos con Registrar usuarios</br>¿Como guardo un usuario con su contraseña encriptada?</br>
 
Entonces, creamos la función que me encriptará la contraseña que el usuario escriba</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/eae4d4b4-977c-4119-ae8d-e365fc487fe4)</br>
Esta función siempre será la misma, toda la vida, esta encripta texto usando el metódo "SHA-56"</br></br>

Entonces, usando esa función al darle clic al boton de crear cuenta, encripto lo que el usuario escribió y lo guardo en una variable llamada "contraseniaEncriptada"</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/6430f5a3-3b79-48e7-bcd8-46fc2dd108c7)
</br></br>
Esta variable llamada "contraseniaEncriptada" es la que mando a la base de datos</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/44963162-015b-4bda-885c-35ab2d7e51f2)
</br></br>
Y listo! asi encripto la contraseña!</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/885b93a4-db55-4393-a20b-7ffbbcb274d7)
</br>
### Código completo de Registrar:
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/7805fc2c-b12d-4161-90bb-8805aa78835f)

</br></br></br>
Ahora, para el Login es exactamente lo mismo
</br>
Luego de mandar a llamar a los elementos de la vista, creo la función para encriptar, esta función siempre es la misma</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/4e0f1eb9-fe61-432a-8b8f-c48a772fb519)
</br></br>
Dentro del boton de Ingresar, encripto la contraseña que el usuario escribió y la guardo en una variable</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/64d35849-c364-4fb2-9dba-38f5a1ba0140)
</br>
Esa misma variable que tiene encriptado lo que el usuario escribió en la contraseña esa misma la mando a la base de datos</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/7032e06b-54cd-4cba-9810-00a7d63a158c)
</br>
### Código completo del login:
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/5f2cfbd0-dd7e-4a7b-ab22-83d5107a2e03)

</br>
</br>


Explicación,</br>
Supongamos que el usaurio se registró con la contraseña "12345678" esa contraseña se va a encriptar asi: "asd123kjeqrwe21312"</br>
Luego, cuando inicie sesión, si vuelve a escribir "12345678" se le va a volver a encriptar asi: "asd123kjeqrwe21312"</br>
Si llega a escribir una contraseña diferente, se le va a encriptar diferente y no tendrá acceso</br>

</br></br>
Script por si quieren ejecutar el proyecto: </br>
  ~~~kotlin
CREATE TABLE TB_USUARIO_EMPRESA(
    UUID_Usuario VARCHAR2(50) PRIMARY KEY,
    Correo VARCHAR2(100) NOT NULL UNIQUE,
    Contraseña VARCHAR2(255) NOT NULL
);

select * from TB_USUARIO_EMPRESA
~~~
