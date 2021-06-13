package com.company;

///INTERFACE PARA TODOS LOS TIPO DE DATOS

public interface DataBaseAL<T> {
    public boolean exist(T obj);
    public T searchClient (T obj);
}
