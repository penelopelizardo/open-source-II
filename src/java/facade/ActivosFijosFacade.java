/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.ActivosFijos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.ActivosFijos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Departamentos;
import Model.Ubicaciones;
import Model.TiposActivos;
import Model.CalculoDepreciacion;
import java.util.Collection;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class ActivosFijosFacade extends AbstractFacade<ActivosFijos> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivosFijosFacade() {
        super(ActivosFijos.class);
    }

    public boolean isDepartamentoEmpty(ActivosFijos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ActivosFijos> activosFijos = cq.from(ActivosFijos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(activosFijos, entity), cb.isNotNull(activosFijos.get(ActivosFijos_.departamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamentos findDepartamento(ActivosFijos entity) {
        return this.getMergedEntity(entity).getDepartamento();
    }

    public boolean isUbicacionEmpty(ActivosFijos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ActivosFijos> activosFijos = cq.from(ActivosFijos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(activosFijos, entity), cb.isNotNull(activosFijos.get(ActivosFijos_.ubicacion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ubicaciones findUbicacion(ActivosFijos entity) {
        return this.getMergedEntity(entity).getUbicacion();
    }

    public boolean isTipoactivoEmpty(ActivosFijos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ActivosFijos> activosFijos = cq.from(ActivosFijos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(activosFijos, entity), cb.isNotNull(activosFijos.get(ActivosFijos_.tipoactivo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposActivos findTipoactivo(ActivosFijos entity) {
        return this.getMergedEntity(entity).getTipoactivo();
    }

    public boolean isCalculoDepreciacionCollectionEmpty(ActivosFijos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ActivosFijos> activosFijos = cq.from(ActivosFijos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(activosFijos, entity), cb.isNotEmpty(activosFijos.get(ActivosFijos_.calculoDepreciacionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<CalculoDepreciacion> findCalculoDepreciacionCollection(ActivosFijos entity) {
        ActivosFijos mergedEntity = this.getMergedEntity(entity);
        Collection<CalculoDepreciacion> calculoDepreciacionCollection = mergedEntity.getCalculoDepreciacionCollection();
        calculoDepreciacionCollection.size();
        return calculoDepreciacionCollection;
    }
    
}
