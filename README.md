# Practica en casa markdown

## Errores a corregir

 Hacemos un **Cambio en el log**
´´´
logger.warning("..."+puntos);

´´´

### Lo cambiamos por

´´´
logger.log(level.WARNING,"...{0}",puntos);

´´´
