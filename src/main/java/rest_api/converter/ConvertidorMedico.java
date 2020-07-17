package rest_api.converter;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import rest_api.entity.Medico;
import rest_api.model.MMedico;

@Component("ConMedico")
public class ConvertidorMedico {
    public List<MMedico> convertirLista(List<Medico> medicos){
        List<MMedico> mmedico = new ArrayList<>();
        for(Medico medico : medicos){
            mmedico.add(new MMedico(medico));
        }
        return mmedico;
    }

    public MMedico convertir(Medico medico){
        MMedico mmedico = new MMedico(medico);
        return mmedico;
    }
    public Medico convertirmtoe(MMedico medico){
        Medico  emedico = new Medico(medico.getNombre(),medico.getCargo(),medico.getEstado());
        return emedico;
    }
}