package mx.unam.aragon.ico.is.formula1api.services;

import mx.unam.aragon.ico.is.formula1api.entities.Formula1Coche;
import mx.unam.aragon.ico.is.formula1api.repositories.CocheRepository;
import mx.unam.aragon.ico.is.formula1api.services.interfaces.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CocheServiceImpl implements CocheService {
    @Autowired
    private CocheRepository cocheRepository;


    @Override
    public Formula1Coche crear(Formula1Coche coche) {
        return cocheRepository.save(coche);
    }

    @Override
    public Iterable<Formula1Coche> listarTodos() {
        return cocheRepository.findAll();
    }

    @Override
    public Optional<Formula1Coche> buscarPorId(Integer clave) {
        return cocheRepository.findById(clave);
    }

    @Override
    public Formula1Coche actualizar(Integer clave, Formula1Coche coche) {
        Optional<Formula1Coche> cocheActual = cocheRepository.findById(clave);
        if (cocheActual.isPresent()) {
            Formula1Coche tmp = cocheActual.get();
            // if(coche.getModelo() != null)
            tmp.setModelo(coche.getModelo());
            tmp.setClave(coche.getClave());
            tmp.setEquipo(coche.getEquipo());
            tmp.setFoto(coche.getFoto());
            tmp.setMotor(coche.getMotor());
            tmp.setPeso(coche.getPeso());
            return cocheRepository.save(tmp);
        }else{
            return null;
        }
    }

    @Override
    public void eliminar(Integer clave) {
        cocheRepository.deleteById(clave);
    }
}
