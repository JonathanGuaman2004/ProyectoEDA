package Data;

import java.util.List;
/**
 * interface para las clases DAO
 */
public interface IDAO<T> {

    /**
     * metodo readAll para leer todos los elementos de unatabla
     * @return: todos los elementos de una tabla
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public List<T> readAll() throws Exception;

    /**
     * El metodo create pemritirá crear un objeto para que despues pueda ser subido a la base de datos
     * @param entity: el objeto
     * @return: Devolvera un booleano al ejecutar el metodo de la clase en cuestion para realizar su creación
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean create(T entity) throws Exception;

    /**
     * El metodo update pemritirá crear un objeto para que despues puedan ser actualizados sus datos y ser subido a la base de datos
     * @param entity: el objeto
     * @return: Devolvera un booleano al ejecutar el metodo de la clase en cuestion para realizar su actualizacion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean update(T entity) throws Exception;

    /**
     * El metodo permitira borrar, cambiar de estado
     * @param entity: el objeto
     * @return: Devolvera un booleano al ejecutar el metodo de la clase en cuestion para realizar su actualizacion de estado
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean delete(T entity) throws Exception;

    /**
     * El metodo permitira leer un dato
     * @param id
     * @return: Devolvera un objeto al ejecutar el metodo de la clase en cuestion para realizar lectura
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public T readBy(int id) throws Exception;
}
