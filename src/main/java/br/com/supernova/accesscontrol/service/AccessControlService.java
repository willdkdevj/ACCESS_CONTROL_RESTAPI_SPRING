package br.com.supernova.accesscontrol.service;

import br.com.supernova.accesscontrol.exception.CategoriaUsuarioException;
import br.com.supernova.accesscontrol.exception.JornadaTrabalhoException;
import br.com.supernova.accesscontrol.exception.NivelAcessoException;
import br.com.supernova.accesscontrol.exception.TipoDataException;
import br.com.supernova.accesscontrol.model.CategoriaUsuario;
import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import br.com.supernova.accesscontrol.model.NivelAcesso;
import br.com.supernova.accesscontrol.model.TipoData;
import br.com.supernova.accesscontrol.repository.CategoriaUsuarioRepository;
import br.com.supernova.accesscontrol.repository.JornadaTrabalhoRepository;
import br.com.supernova.accesscontrol.repository.NivelAcessoRepository;
import br.com.supernova.accesscontrol.repository.TipoDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccessControlService {

    private final JornadaTrabalhoRepository repositoryWorkday;
    private final NivelAcessoRepository repositoryLevel;
    private final CategoriaUsuarioRepository repositoryCategory;
    private final TipoDataRepository repositoryDate;

    public Object findByObject(Long id, Object obj) throws CategoriaUsuarioException, JornadaTrabalhoException, NivelAcessoException, TipoDataException {
        try {
            if (obj instanceof CategoriaUsuario) {
                CategoriaUsuario categoria = repositoryCategory.findById(id).orElseThrow(() -> new CategoriaUsuarioException(id));
                return categoria;
            } else if (obj instanceof JornadaTrabalho) {
                JornadaTrabalho jornada = repositoryWorkday.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
                return jornada;
            } else if (obj instanceof NivelAcesso) {
                NivelAcesso nivelAcesso = repositoryLevel.findById(id).orElseThrow(() -> new NivelAcessoException(id));
                return nivelAcesso;
            } else if (obj instanceof TipoData) {
                TipoData data = repositoryDate.findById(id).orElseThrow(() -> new TipoDataException(id));
                return data;
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        return obj;
    }

    public Object registerObject(Object obj){
        Object savedObj = null;
        try {
            if(obj instanceof CategoriaUsuario){
                CategoriaUsuario categoria = (CategoriaUsuario) obj;
                savedObj = repositoryCategory.save(categoria);
            } else if(obj instanceof JornadaTrabalho){
                JornadaTrabalho jornada = (JornadaTrabalho) obj;
                savedObj = repositoryWorkday.save(jornada);
            } else if(obj instanceof NivelAcesso) {
                NivelAcesso nivel = (NivelAcesso) obj;
                savedObj = repositoryLevel.save(nivel);
            } else if(obj instanceof TipoData) {
                TipoData type = (TipoData) obj;
                savedObj = repositoryDate.save(type);
            }
        } catch (RuntimeException ex) {
            System.out.println("Error returning Object to created " + ex.getMessage());
        }
        return savedObj;
    }

    public Object returnAllObject(Object obj){
    List<Object> repositoryAll = null;
        try {
            if (obj instanceof CategoriaUsuario) {
                repositoryAll = Collections.singletonList(repositoryCategory.findAll());
            } else if (obj instanceof JornadaTrabalho) {
                repositoryAll = Collections.singletonList(repositoryWorkday.findAll());
            } else if (obj instanceof NivelAcesso) {
                repositoryAll = Collections.singletonList(repositoryLevel.findAll());
            } else if (obj instanceof TipoData) {
                repositoryAll = Collections.singletonList(repositoryCategory.findAll());
            }
        } catch (RuntimeException ex){
            System.out.println("Error returning Object listing " + ex.getMessage());
        }
        return repositoryAll;
    }

    public Object updateByObjectId(Long id, Object obj) throws CategoriaUsuarioException, JornadaTrabalhoException, NivelAcessoException, TipoDataException {
        Object updatedObj = null;
        try {
            if(obj instanceof CategoriaUsuario){
                CategoriaUsuario categoria = (CategoriaUsuario) obj;
                CategoriaUsuario findUserCategory = repositoryCategory.findById(id).orElseThrow(() -> new CategoriaUsuarioException(id));
                categoria.setId(findUserCategory.getId());
                updatedObj = repositoryCategory.save(categoria);
            } else if(obj instanceof JornadaTrabalho){
                JornadaTrabalho jornada = (JornadaTrabalho) obj;
                JornadaTrabalho findWorkday = repositoryWorkday.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
                jornada.setId(findWorkday.getId());
                updatedObj = repositoryWorkday.save(jornada);
            } else if(obj instanceof NivelAcesso){
                NivelAcesso nivelAcesso = (NivelAcesso) obj;
                NivelAcesso findAccessLevel = repositoryLevel.findById(id).orElseThrow(() -> new NivelAcessoException(id));
                nivelAcesso.setId(findAccessLevel.getId());
                updatedObj = repositoryLevel.save(nivelAcesso);
            } else if(obj instanceof TipoData){
                TipoData tipoData = (TipoData) obj;
                TipoData findDateType = repositoryDate.findById(id).orElseThrow(() -> new TipoDataException(id));
                tipoData.setId(findDateType.getId());
                updatedObj = repositoryDate.save(tipoData);
            }
        } catch (RuntimeException ex){
            System.out.println("Error returning Object to updated " + ex.getMessage());
        }
        return updatedObj;
    }

    public Map<String, Boolean> deleteByObjectId(Long id, Object obj) throws CategoriaUsuarioException, JornadaTrabalhoException, NivelAcessoException, TipoDataException {
        Map<String, Boolean> mapDelete = new HashMap<>();
        try {
            if(obj instanceof CategoriaUsuario){
                CategoriaUsuario findCategory = repositoryCategory.findById(id).orElseThrow(() -> new CategoriaUsuarioException(id));
                mapDelete.put(findCategory.getDescricao(), true);
            } else if(obj instanceof JornadaTrabalho){
                JornadaTrabalho findWorkday = repositoryWorkday.findById(id).orElseThrow(() -> new JornadaTrabalhoException(id));
                mapDelete.put(findWorkday.getDescricao(), true);
            } else if(obj instanceof NivelAcesso) {
                NivelAcesso findAccessLevel = repositoryLevel.findById(id).orElseThrow(() -> new NivelAcessoException(id));
                mapDelete.put(findAccessLevel.getDescricao(), true);
            } else if(obj instanceof TipoData){
                TipoData findType = repositoryDate.findById(id).orElseThrow(() -> new TipoDataException(id));
                mapDelete.put(findType.getDescricao(), true);
            }
        } catch (RuntimeException ex) {
            System.out.print("Error returning Object to deleted " + ex.getMessage());
        }
        return mapDelete;
    }
}
