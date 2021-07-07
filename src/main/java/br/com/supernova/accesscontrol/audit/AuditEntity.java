package br.com.supernova.accesscontrol.audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "REVINFO_CUSTOM")
@RevisionEntity(AuditListener.class)
public class AuditEntity extends DefaultRevisionEntity {

    private String usuario;
    private String ip;
}
