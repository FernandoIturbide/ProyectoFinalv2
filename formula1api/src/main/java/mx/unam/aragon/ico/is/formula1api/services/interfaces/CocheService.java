package mx.unam.aragon.ico.is.formula1api.services.interfaces;

import mx.unam.aragon.ico.is.formula1api.entities.Formula1Coche;

import java.util.Optional;

public interface CocheService {
    public abstract Formula1Coche crear(Formula1Coche coche);
    public abstract Iterable<Formula1Coche> listarTodos();
    public abstract Optional<Formula1Coche> buscarPorId(Integer clave);
    public abstract Formula1Coche actualizar(Integer clave, Formula1Coche coche);
    public abstract void eliminar(Integer clave);
}
