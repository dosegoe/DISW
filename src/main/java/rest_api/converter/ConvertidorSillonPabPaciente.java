package rest_api.converter;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import rest_api.entity.SillonPabPaciente;
import rest_api.model.MSillonPabPaciente;

@Component("ConSillonPabPaciente")
public class ConvertidorSillonPabPaciente {
    public List<MSillonPabPaciente> convertirLista(List<SillonPabPaciente> sillonpabpacientes) {
        List<MSillonPabPaciente> msillonpabpaciente = new ArrayList<>();
        for (SillonPabPaciente sillonpabpaciente : sillonpabpacientes) {
            msillonpabpaciente.add(new MSillonPabPaciente(sillonpabpaciente));
        }
        return msillonpabpaciente;
    }

    public MSillonPabPaciente convertir(SillonPabPaciente sillonpabpaciente) {
        MSillonPabPaciente msillonpabpaciente = new MSillonPabPaciente(sillonpabpaciente);
        return msillonpabpaciente;
    }

    public SillonPabPaciente convertirmtoe(MSillonPabPaciente sillonpabpaciente) {
        SillonPabPaciente esillonpabpaciente = new SillonPabPaciente(sillonpabpaciente.getId(), sillonpabpaciente.getidPaciente(), sillonpabpaciente.getidPabellon(), sillonpabpaciente.getidSillon());
        return esillonpabpaciente;
    }
}