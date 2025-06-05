package mx.unam.aragon.ico.is.formula1api.repositories;

import mx.unam.aragon.ico.is.formula1api.entities.Formula1Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CocheRepository extends JpaRepository<Formula1Coche, Integer> {
    public Formula1Coche findFormula1CocheByClave(Integer clave);
    public Formula1Coche deleteByClave(Integer clave);
}
