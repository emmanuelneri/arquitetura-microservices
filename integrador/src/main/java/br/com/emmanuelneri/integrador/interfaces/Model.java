package br.com.emmanuelneri.integrador.interfaces;

import java.io.Serializable;

public interface Model<ID extends Serializable> extends Serializable {

    ID getId();
}
