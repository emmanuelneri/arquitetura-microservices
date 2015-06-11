package br.com.emmanuelneri.relatorios.util;

import java.io.Serializable;

public interface Model<ID extends Serializable> extends Serializable {

    ID getId();
}
