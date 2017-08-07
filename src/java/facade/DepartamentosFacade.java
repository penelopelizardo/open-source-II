/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.Departamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Departamentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ActivosFijos;
import Model.Empleados;
import java.util.Collection;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class DepartamentosFacade extends AbstractFacade<Departamentos> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentosFacade() {
        super(Departamentos.class);
    }

    public boolean isActivosFijosCollectionEmpty(Departamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamentos> departamentos = cq.from(Departamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamentos, entity), cb.isNotEmpty(departamentos.get(Departamentos_.activosFijosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<ActivosFijos> findActivosFijosCollection(Departamentos entity) {
        Departamentos mergedEntity = this.getMergedEntity(entity);
        Collection<ActivosFijos> activosFijosCollection = mergedEntity.getActivosFijosCollection();
        activosFijosCollection.size();
        return activosFijosCollection;
    }

    public boolean isEmpleadosCollectionEmpty(Departamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamentos> departamentos = cq.from(Departamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamentos, entity), cb.isNotEmpty(departamentos.get(Departamentos_.empleadosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Empleados> findEmpleadosCollection(Departamentos entity) {
        Departamentos mergedEntity = this.getMergedEntity(entity);
        Collection<Empleados> empleadosCollection = mergedEntity.getEmpleadosCollection();
        empleadosCollection.size();
        return empleadosCollection;
    }
    
}
