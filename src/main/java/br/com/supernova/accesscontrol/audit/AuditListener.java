package br.com.supernova.accesscontrol.audit;

import org.hibernate.envers.RevisionListener;

public class AuditListener implements RevisionListener {
    @Override
    public void newRevision(Object revision) {
        AuditEntity auditEntity = (AuditEntity) revision;
        auditEntity.setUsuario("inserir sessão ao spring");
    }
}
