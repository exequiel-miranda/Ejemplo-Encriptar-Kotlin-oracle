# Explicación de como Encriptar contraseñas 

Esta aplicación realiza el proceso de Login y Registro de usuarios usando contraseñas encriptadas
El proceso es muy sencillo

La app cuenta con dos pantallas, Login y Registro de usuarios </br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/925eb135-ed1f-4f44-bc5b-2b66d3359c7b)
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/f15e8f8b-455d-47f8-a68c-6847e85a4672)
</br></br>
## Empecemos con Registrar usuarios</br>¿Como guardo un usuario con su contraseña encriptada?</br>
 
Entonces, creamos la función que me encriptará la contraseña que el usuario escriba</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/eae4d4b4-977c-4119-ae8d-e365fc487fe4)</br>
Esta función siempre será la misma, toda la vida, esta ecripta texto usando el metódo "SHA-56"</br></br>

Entonces, usando esa función al darle clic al boton de crear cuenta, encripto lo que el usuario escribió y lo guardo en una variable llamada "contraseniaEncriptada"</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/6430f5a3-3b79-48e7-bcd8-46fc2dd108c7)
</br></br>
Esta variable llamada "contraseniaEncriptada" es la que mando a la base de datos</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/44963162-015b-4bda-885c-35ab2d7e51f2)
</br></br>
Y listo! asi encripto la contraseña!</br>
![image](https://github.com/exequiel-miranda/Ejemplo-Encriptar-Kotlin-oracle/assets/94820436/885b93a4-db55-4393-a20b-7ffbbcb274d7)
</br></br></br>
Ahora, para el Login es exactamente lo mismo
</br>
