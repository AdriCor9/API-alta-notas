package org.adri.apinotaalta.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.adri.apinotaalta.DTO.AltaInDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AltaService {

    public AltaService() {
    }

    public String guardarDato(AltaInDTO dataIn) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();

        Map<String,Object> data = new HashMap<>();
        data.put("user",dataIn.getUser());
        data.put("title",dataIn.getTitulo());
        data.put("description",dataIn.getDescripcion());
        data.put("date", LocalDateTime.now().toString());
        data.put("color",dataIn.getColor());

        firestore.collection("notas")
                .add(data)
                .get();

       return "Registro guardado exitosamente";
    }
}
